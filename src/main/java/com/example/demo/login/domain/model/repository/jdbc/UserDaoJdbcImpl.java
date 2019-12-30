package com.example.demo.login.domain.model.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoJdbcImpl {
    @Autowired
    JdbcTemplate jdbc;

    //Userテーブルの件数を取得
}
