package com.estimating.service;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.estimating.entity.Customers;
import com.estimating.entity.DateEmbedded;
import com.estimating.entity.Departments;

public class ServiceTest extends AbstractBaseServiceTest {

	@SuppressWarnings("unused")
	private ApplicationContext context;

	private DateEmbedded date;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/estimating-config/estimating-config.xml");
		long time = System.currentTimeMillis();
		date = new DateEmbedded();
		date.setCreatedDate(new Timestamp(time));
		date.setUpdatedDate(new Timestamp(time));
	}

	@Test
	public void createCustomerTest() {
		Departments department = departmentService.findOneById(Long
				.parseLong("2"));
		Customers customer1 = new Customers("customer3", new BigDecimal("0"),
				department, date);
		customerService.create(customer1);
		Assert.assertNotNull(customer1);
	}
}
