package com.example.spring_boot_trial.repository;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Optional;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_trial.dynamicsqlsupport.UserDynamicSqlSupport;
import com.example.spring_boot_trial.mapper.UserMapper;
import com.example.spring_boot_trial.model.UserModel;

@Repository
public class UserRepository {

    private final UserMapper mapper;

    private final UserDynamicSqlSupport user = new UserDynamicSqlSupport();

    @Autowired
    public UserRepository(UserMapper mapper) {
        this.mapper = mapper;
    }

    public Optional<UserModel> selectByEmail(String email) {
        var stmt = SqlBuilder
            .select(user.allColumns())
            .from(user)
            .where(user.email, isEqualTo(email))
            .build().render(RenderingStrategies.MYBATIS3);
        return mapper.select(stmt);
    }
}
