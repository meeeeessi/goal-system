package org.wang.goal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class GoalSystemApplicationTests {

	@Test
	void contextLoads() {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		String format = simpleDateFormat.format(date.getTime());
		Timestamp ts = Timestamp.valueOf(format);
		System.out.println(ts+"-----------------------");
	}

}
