package com.koreate.betty.global.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@DatabaseConfiguration
@MapperScan(basePackages = { "com.koreate.betty.domain.*.dao" })
public class DBConfig {

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig("/database.properties");
		return new HikariDataSource(config);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		
		Configuration config = new Configuration();
		config.setMapUnderscoreToCamelCase(true);
		bean.setConfiguration(config);
		
		bean.setDataSource(ds);
		return bean.getObject();
	}

	@Bean
	public TransactionManager transactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
}
