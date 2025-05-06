package com.example.spring_boot_trial.dynamicsqlsupport;

import java.sql.JDBCType;
import java.time.LocalDateTime;

import org.mybatis.dynamic.sql.SqlColumn;

public class NoteDynamicSqlSupport {
    public static final Note note = new Note();
    public static final SqlColumn<Integer> id = note.id;

    public static final SqlColumn<Integer> userId = note.userId;
    public static final SqlColumn<String> title = note.title;
    public static final SqlColumn<String> content = note.content;

    public static final SqlColumn<LocalDateTime> createdAt = note.createdAt;
    public static final SqlColumn<LocalDateTime> updatedAt = note.updatedAt;
    public static final SqlColumn<LocalDateTime> deletedAt = note.deletedAt;

    public static final class Note extends BaseSqlTable<Note> {
        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);
        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);
        public final SqlColumn<String> content = column("content", JDBCType.VARCHAR);

        public Note() {
            super("trn_note", Note::new);
        }
    }
}
