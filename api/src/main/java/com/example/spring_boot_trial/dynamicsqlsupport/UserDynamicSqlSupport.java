package com.example.spring_boot_trial.dynamicsqlsupport;

import java.sql.JDBCType;

import org.mybatis.dynamic.sql.SqlColumn;

public class UserDynamicSqlSupport extends BaseSqlTable<UserDynamicSqlSupport> {
    public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);
    
    public UserDynamicSqlSupport() {
        super("mst_user", UserDynamicSqlSupport::new);
    }
}
