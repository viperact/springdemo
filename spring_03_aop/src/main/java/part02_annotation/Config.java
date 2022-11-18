package part02_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//자바소스를 이용하여 환경설정할때
//annotation 설정

@Configuration
@EnableAspectJAutoProxy // == <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
public class Config {
	public Config() {
		
	}
	
	//따로 설정하지않으면 method명이 Bean의 이름이됨
	@Bean
	public ServiceImp svc() {
		return new ServiceImp();
	}
	
	@Bean
	public AdviceCommon common() {
		return new AdviceCommon();
	}
	
}
