/* 기본적인 spring boot의 스프링 빈 등록 방식
 * 1. 현 클래스의 package와 다르게 구현했다
 * 	- 애노테이션으로 설정
 *  - step10 단계 참조
 *  
 * 2. 현 클래스와 동일한 package 또는 sub package명으로 구현했다
 * 	- 하위 sub package들로 구성했기 때문에 별도의 애노테이션 생략 가능
 */
package io.playdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Step11BoardMissionAApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step11BoardMissionAApplication.class, args);
	}
}
