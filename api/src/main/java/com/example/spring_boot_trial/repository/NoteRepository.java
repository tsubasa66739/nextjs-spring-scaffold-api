package com.example.spring_boot_trial.repository;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.example.spring_boot_trial.dynamicsqlsupport.NoteDynamicSqlSupport.*;
import com.example.spring_boot_trial.mapper.NoteMapper;
import com.example.spring_boot_trial.model.NoteModel;

@Repository
public class NoteRepository {

    private final NoteMapper mapper;

    @Autowired
    public NoteRepository(NoteMapper mapper) {
        this.mapper = mapper;
    }
    
    public NoteModel selectById(Integer noteId) {
        var stmt = SqlBuilder
            .select(note.allColumns())
            .from(note).where(id, isEqualTo(noteId))
            .build().render(RenderingStrategies.MYBATIS3);
        return mapper.select(stmt);
    }
}
