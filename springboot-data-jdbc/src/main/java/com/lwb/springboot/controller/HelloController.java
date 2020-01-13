package com.lwb.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-01-13 15:57
 **/
@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/hello")
    public List<Map<String, Object>> hello(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from qqq");

        return maps;
    }
}
