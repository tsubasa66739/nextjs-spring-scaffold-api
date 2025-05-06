package com.example.spring_boot_trial.repository;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.render.RenderingStrategy;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_trial.dynamicsqlsupport.NoteDynamicSqlSupport;
import com.example.spring_boot_trial.mapper.NoteMapper;
import com.example.spring_boot_trial.model.NoteModel;

@Repository
public class NoteRepository {

    private final NoteMapper mapper;

    private final NoteDynamicSqlSupport note = new NoteDynamicSqlSupport();

    @Autowired
    public NoteRepository(NoteMapper mapper) {
        this.mapper = mapper;
    }

    public void insert(NoteModel model) {
        var stmt = SqlBuilder
            .insert(model)
            .into(note)
            .build().render(RenderingStrategies.MYBATIS3);
        mapper.insert(stmt);
    }
    
    public Optional<NoteModel> selectById(Integer id) {
        var stmt = SqlBuilder
            .select(note.allColumns())
            .from(note).where(note.id, isEqualTo(id))
            .build().render(RenderingStrategies.MYBATIS3);
        return mapper.select(stmt);
    }
}
