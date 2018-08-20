package org.edingsoft.test;

import java.sql.SQLException;

import org.edingsoft.config.DBconfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

public class EdingTest {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.register(DBconfig.class);
		ctx.refresh();
		DruidDataSource ds= (DruidDataSource) ctx.getBean("dataSource");
		System.out.println(ds.getConnection().isClosed());
		ds.close();
	}
}
