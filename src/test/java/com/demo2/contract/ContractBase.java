/*
 * Created by 2020-05-03 20:35:13 
 */
package com.demo2.contract;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo2.product.ProductApplication;
import com.demo2.support.web.OrmController;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author fangang
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=ProductApplication.class)
public class ContractBase {
	@Autowired
	private OrmController controller;
	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(controller);
	}
}
