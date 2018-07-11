package com.uracle.future;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@SpringBootApplication
@ComponentScan
@Configuration // spring에서 이 에노테이션이 붙은 클래스를 설정파일로 사용한다
@EnableAutoConfiguration // component scan의 탐색 루트로 묵시적 지정을 하게 됨.
@EnableAspectJAutoProxy
@EnableTransactionManagement
@MapperScan(value = {"com.uracle.future.mapper"})
public class VuexApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuexApplication.class, args);
	}
	
	@Bean
	public InternalResourceViewResolver setResolver() throws Exception {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".html");
		return resolver;
	}

	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
            System.out.println(dataSource);
            sessionFactory.setMapperLocations(res);
            return sessionFactory.getObject();
    }
	
	@Bean
	@Autowired
	public DataSourceTransactionManager txManager(DataSource dataSource) throws Exception {
		System.out.println(dataSource);
		return new DataSourceTransactionManager(dataSource);
	}
}
