package com.xiaoya.scaffold.provider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhuzhongji
 * @date 2018年7月12日
 * mock单元测试(被测试类中为真实对象)
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProviderApplication.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TestRedis1Service {
	//@InjectMocks:将用@Mock标注的mock对象,注入到被某个被该注解标注的测试的对象中
//	@InjectMocks
//	@Autowired
//	private RedisService redisService = new RedisServiceImpl();
	
	//@Spy：用来标注某个被@Mockito标注的真实对象
//	@Spy
//	@Autowired
//	private ValueOperations<String, Object> valueOperations;
	
//	@Mock
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	
	@Before
    public void setUp() {
        //初始化当前测试类所有@Mock注解模拟对象
        MockitoAnnotations.initMocks(this);
    }
	
//	@Test
//	public void testGet() {
//		//运行方法(真实运行)
//		Object value = redisService.getValue("test2");
//		//判断该方法是否被调用(是否发生交互)
//		Mockito.verify(valueOperations).get(Mockito.anyString());
//		System.out.println(value);
//		//验证返回数据是否相同
//		Assert.assertEquals("test", value);
//	}

	@Test
	public void testRedis() {
		redisTemplate.opsForValue().set("test5", "value5");
		Object o = redisTemplate.opsForValue().get("test5");
		System.out.println(o);
	}
}
