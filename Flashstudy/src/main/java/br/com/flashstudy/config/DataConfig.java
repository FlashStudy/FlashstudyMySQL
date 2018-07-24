package br.com.flashstudy.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

//Configuração para acesso ao banco de dados
@Configuration
public class DataConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/flashspring?useSSL=false");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		
		/*
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/flashspring?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		*/
		return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL94Dialect");
		
		/*
		adapter.setDatabase(Database.MYSQL);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		*/
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setPrepareConnection(true);

		return adapter;
	}
}
