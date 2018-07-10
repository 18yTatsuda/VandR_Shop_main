package jp.co.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jp.co.example.VandR_Shop.service.impl.ShopAdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:servlet-context-test.xml")
public class ExampleServoceTest {

	    @Autowired
	    private ShopAdminService service;

	    @Test
	    public void testService() {
//	        String ret = service.authentication(id, password);
//	        assertEquals("test dao!!", ret);
	    }
	}