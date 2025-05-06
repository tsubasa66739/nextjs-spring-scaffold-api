package com.example.spring_boot_trial.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import com.example.spring_boot_trial.model.NoteModel;

@Mapper
public interface NoteMapper {

    public void insert(InsertStatementProvider<NoteModel> stmt);

    public Optional<NoteModel> select(SelectStatementProvider stmt);
}
