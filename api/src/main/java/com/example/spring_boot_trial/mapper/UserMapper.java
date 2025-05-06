package com.example.spring_boot_trial.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import com.example.spring_boot_trial.model.UserModel;

@Mapper
public interface UserMapper {
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    public Optional<UserModel> select(SelectStatementProvider stmt);
}
