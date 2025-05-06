package com.example.spring_boot_trial.dynamicsqlsupport;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import java.util.function.Supplier;

import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public abstract class BaseSqlTable<T extends AliasableSqlTable<T>> extends AliasableSqlTable<T> {
    public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);
    public final SqlColumn<LocalDateTime> createdAt = column("created_at", JDBCType.TIMESTAMP);
    public final SqlColumn<LocalDateTime> updatedAt = column("updated_at", JDBCType.TIMESTAMP);
    public final SqlColumn<LocalDateTime> deletedAt = column("deleted_at", JDBCType.TIMESTAMP);

    public BaseSqlTable(String table, Supplier<T> constructor) {
        super(table, constructor);
    }
}
