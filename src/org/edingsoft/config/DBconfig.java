package org.edingsoft.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:dbconfig.properties")

public class DBconfig {
		@Value("${url}")
		String url;
		@Value("${userName}")
		String userName;
		@Value("${passWord}")
		String passWord;
		@Value("${driverName}")
		String driverName;
	  @Bean(name="dataSource",initMethod="init",destroyMethod="close")
		public DruidDataSource getDataSource() {
			DruidDataSource ds=new DruidDataSource();
//			ds.setUrl("jdbc:mysql://www.edingsoft.com:3306/eding?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8");
//			ds.setUsername("eding");
//			ds.setPassword("AWDN54JRN2ER5YIS");
//			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
			ds.setUrl(url);
			ds.setUsername(userName);
			ds.setPassword(passWord);
			ds.setDriverClassName(driverName);
			ds.setInitialSize(3);
			ds.setMaxActive(10);
			ds.setMinIdle(1);
			ds.setRemoveAbandoned(true);
			ds.setRemoveAbandonedTimeout(1800);
			return ds;
		}
		
		@Bean
		public JdbcTemplate getTemplate() {
			JdbcTemplate template=new JdbcTemplate();
			template.setDataSource(getDataSource());
			return template;
		}
}
