package org.edingsoft.test;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.pool.DruidDataSource;

@Controller
public class TestController {
	@Autowired
	JdbcTemplate temp;
	
	@RequestMapping("/hello")
	public String hello()  {
		System.out.println("u got it");
		System.out.println(temp.queryForList("select * from test"));
		return "hello";
	}
}
