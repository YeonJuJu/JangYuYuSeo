package com.jangyuyuseo.spring.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

<<<<<<< HEAD
import com.jangyuyuseo.spring.mapper.ProductMapper;
=======
import com.jangyuyuseo.spring.interceptor.CategoryInterceptor;
import com.jangyuyuseo.spring.mapper.CategoryMapper;
>>>>>>> 08e73efd1238a9835f15b3483b4a0aa4949b23b2
import com.jangyuyuseo.spring.mapper.UserMapper;
import com.jangyuyuseo.spring.service.CategoryService;

// Spring MVC 프로젝트에 관련된 설정을 하는 클래스

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.jangyuyuseo.spring.controller", "com.jangyuyuseo.spring.dao",
		"com.jangyuyuseo.spring.service" })
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {

	@Value("${db.classname}")
	private String db_classname;

	@Value("${db.url}")
	private String db_url;

	@Value("${db.username}")
	private String db_username;

	@Value("${db.password}")
	private String db_password;

	@Autowired
	private CategoryService categoryService;
	
	/*
	 * Controller 에서 return하는 문자열(경로)에 접두사, 접미사 설정하기
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

	/*
	 * 프로젝트에서 사용하는 정적 파일 경로 설정 (이미지, 사운드, 동영상, js, css 등)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}

	/*
	 * DB 접속 관리 Bean
	 */
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);
		return source;
	}

	/*
	 * Query와 접속정보 관리 객체
	 */
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}
	
	/*
	 * Query 실행 객체 (Mapper 관리)
	 */
	
	// UserMapper 등록
	@Bean
	public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<UserMapper> factoryBean 
		  = new MapperFactoryBean<UserMapper>(UserMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
<<<<<<< HEAD
	// ProductMapper 등록
	@Bean
	public MapperFactoryBean<ProductMapper> getProductMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<ProductMapper> factoryBean 
		  = new MapperFactoryBean<ProductMapper>(ProductMapper.class);
=======
	// CategoryMapper 등록
	@Bean
	public MapperFactoryBean<CategoryMapper> getCategoryMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<CategoryMapper> factoryBean 
		= new MapperFactoryBean<CategoryMapper>(CategoryMapper.class);
>>>>>>> 08e73efd1238a9835f15b3483b4a0aa4949b23b2
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
<<<<<<< HEAD
=======
	/*
	 * Interceptor 등록하기
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    WebMvcConfigurer.super.addInterceptors(registry);
	  	
	  	CategoryInterceptor categoryInterceptor = new CategoryInterceptor(categoryService);
	  	
	  	InterceptorRegistration reg1 = registry.addInterceptor(categoryInterceptor);
	  	
	  	reg1.addPathPatterns("/**");
	}
	
>>>>>>> 08e73efd1238a9835f15b3483b4a0aa4949b23b2
	
	/*
	*properties 폴더 안에 있는 properties 파일들이 충돌되지 않도록 개별적으로 관리해 주는 Bean
	*/
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcePlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/* 
	 * 메세지 등록하기 
	*/
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/error_message");
		return res;
	}
}
