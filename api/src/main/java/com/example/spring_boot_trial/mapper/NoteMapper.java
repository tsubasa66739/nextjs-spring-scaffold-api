package com.example.spring_boot_trial.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import com.example.spring_boot_trial.model.NoteModel;

@Mapper
public interface NoteMapper {

    @Insert("""
            INSERT INTO note 
            (
                title,
                content
            ) 
            VALUES 
            (
                #{title},
                #{content}
            )
            """)
    public void insert(NoteModel note);

    public NoteModel select(SelectStatementProvider stmt);
}
