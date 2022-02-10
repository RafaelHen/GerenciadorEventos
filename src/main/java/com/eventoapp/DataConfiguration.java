package com.eventoapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class DataConfiguration {

	private static final org.springframework.orm.jpa.vendor.Database Database = null;
	
	@Bean
     public DataSource dataSource(){
                DriverManagerDataSource dataSource = new DriverManagerDataSource();
               dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
               dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp?useSSL=false");
              dataSource.setUsername("root");
              dataSource.setPassword("1234");
              return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect"); 
		adapter.setPrepareConnection(true);
		return adapter;
	}
}
