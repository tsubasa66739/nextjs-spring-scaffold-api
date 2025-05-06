package com.example.spring_boot_trial.dynamicsqlsupport;

import java.sql.JDBCType;

import org.mybatis.dynamic.sql.SqlColumn;

public class NoteDynamicSqlSupport extends BaseSqlTable<NoteDynamicSqlSupport> {
    public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);
    public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);
    public final SqlColumn<String> content = column("content", JDBCType.VARCHAR);

    public NoteDynamicSqlSupport() {
        super("trn_note", NoteDynamicSqlSupport::new);
    }
}
