package com.mike.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController implements RowMapper<UserRestController.User> {

    private final NamedParameterJdbcOperations jdbcOperations;

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("c_username"));
    }

    public record User(int id, String username) {
    }

    @GetMapping
    public List<User> findAllUsers() {
        return this.jdbcOperations.query("select * from t_user", this);
    }
}
