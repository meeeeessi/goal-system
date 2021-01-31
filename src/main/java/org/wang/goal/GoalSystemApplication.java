package org.wang.goal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.wang.goal.mapper")
public class GoalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoalSystemApplication.class, args);
	}

}
