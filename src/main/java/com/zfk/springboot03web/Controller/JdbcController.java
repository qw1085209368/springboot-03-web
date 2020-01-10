package com.zfk.springboot03web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    //JdbcTemplate 是 core 包的核心类，用于简化 JDBC操作，还能避免一些常见的错误，如忘记关闭数据库连接
    //Spring Boot 默认提供了数据源，默认提供了 org.springframework.jdbc.core.JdbcTemplate
    //JdbcTemplate 中会自己注入数据源，使用起来也不用再自己来关闭数据库连接
    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询student表中所有数据
    //List 中的1个 Map 对应数据库的 1行数据
    //Map 中的 key 对应数据库的字段名，value 对应数据库的字段值
    @GetMapping("/usert")
    public List<Map<String, Object>> userList(){
        String sql = "select * from ssm_book";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    @GetMapping("/test")
    public String test(){

        return "OK";
    }

    //新增一个用户
    @GetMapping("/addBook")
    public String addBook(){
        //插入语句
        String sql = "insert into ssm_book(id,title, catalog) values (12,'小明','123456')";
        jdbcTemplate.update(sql);
        //查询
        return "addBook-ok";
    }

    //修改用户信息
    @GetMapping("/updateBook/{id}")
    public String updateBook(@PathVariable("id") int id){
        //插入语句
        String sql = "update ssm_book set title=?,catalog=? where id="+id;
        //数据
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "zxcvbn";
        jdbcTemplate.update(sql,objects);
        //查询
        return "updateBook-ok";
    }

    //删除用户
    @GetMapping("/delBook/{id}")
    public String delBook(@PathVariable("id") int id){
        //插入语句
        String sql = "delete from ssm_book where id=?";
        jdbcTemplate.update(sql,id);
        //查询
        return "delBook-ok";
    }

}