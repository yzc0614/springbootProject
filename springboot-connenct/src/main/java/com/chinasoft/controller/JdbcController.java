package com.chinasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/getAll")
    public List<Map<String, Object>> jbdc(){
        List<Map<String, Object>> ulist = jdbcTemplate.queryForList("select * from user");
        return ulist;
    }
}
