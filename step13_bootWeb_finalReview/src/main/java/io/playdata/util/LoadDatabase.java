package io.playdata.util;


import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.playdata.dao.MemberRepository;
import io.playdata.domain.Member;

/* @Aspect사용으로 코드를 모듈로 분리시켜 작성. AOP를 적용하기 위한것인듯. 
 * 설정파일을 만들기 위한 애노테이션 or Bean을 등록하기 위한 애노테이션
 * 임의의 클래스를 만들어서 @Bean 어노테이션을 붙인다고 되는 것이 아니고, @Bean을 사용하는 클래스에는 반드시 @Configuration 어노테이션을 활용하여 해당 클래스에서 Bean을 등록하고자 함을 명시해주어야 한다.
	스프링 빈으로 등록된 다른 클래스 안에서 @Bean으로 직접 빈을 등록해주는 것도 동작은 한다. 
	하지만 @Configuration 안에서 @Bean을 사용해야 싱글톤을 보장받을 수 있으므로 @Bean 어노테이션은 반드시 @Configuration과 함께 사용해주어야 한다.
	
	하지만 method들이 많아질 경우 하나한 @Bean을 붙여줘야 하는 경우가 있는데 이떄는 그냥 해당 class 위에 @Component를 사용하 자동으로 @Bean으로 만들어주도록 한다.*/
@Aspect
@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	/* commandLineRunner : 인터페이스는 구동 시점에 실행되는 코드가 자바 문자열 아규먼트 배열에 접근해야할 필요가 있는 경우에 사용. 
	 * 현재는 log를 남기면서 기본 데이터를 넣기 위해 사용.*/
	@Bean
	CommandLineRunner initDatabase(MemberRepository repository) {
//		System.out.println(repository);

		return args -> {
			log.info("Preloading " + repository.save(new Member("user1", "11", "유재석", "감성지킴이")));
			log.info("Preloading " + repository.save(new Member("user2", "22", "백종원", "건강지킴이")));
		};
	}
}