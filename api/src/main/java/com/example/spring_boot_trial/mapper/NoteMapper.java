package com.example.spring_boot_trial.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import com.example.spring_boot_trial.model.NoteModel;

@Mapper
public interface NoteMapper {

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    public void insert(InsertStatementProvider<NoteModel> stmt);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    public Optional<NoteModel> select(SelectStatementProvider stmt);
}
