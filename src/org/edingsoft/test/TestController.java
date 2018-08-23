package org.edingsoft.test;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	@Autowired
	JdbcTemplate temp;
	
	@RequestMapping("/hello")
	public String hello(@RequestParam Map req,Model model)  {
		System.out.println(req);
		System.out.println(temp.queryForList("select * from test"));
		model.addAttribute("user", req.get("user") );
		return "hello";
	}
	
	
}
