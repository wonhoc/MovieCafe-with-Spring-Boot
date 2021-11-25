package com.example.biz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieCafeWebAppApplicationTests {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Test
	public void test1() {
		assertNotNull(this.sqlSessionTemplate);
	}

}
