/*
 * Copyright $today.year Thomson Reuters/ONESOURCE. All rights reserved.
 */

package com.twotwofish.springtest;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Tests the setting in the Spring configuration file, using no autowiring. This test uses
 * the {@code @RunWith(SpringJUnit4ClassRunner.class)} that enables configuration of the
 * test class.
 *
 * @author Bill Andrews
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:simplePropertyBeans.xml" })
public final class XmlConfigurationTest
{
	// The Spring context is autowired into the test.
 	@Autowired
	 ApplicationContext context;

	@Test
	public void testUsingXmlConfiguration() throws Exception
	{
		final Object generator = context.getBean("sequenceGenerator");
	  	assertTrue("sequenceGenerator should be a PropertyInjectionGenerator.", generator instanceof PropertyInjectionGenerator);

		final PropertyInjectionGenerator propertyInjectionGenerator = (PropertyInjectionGenerator)generator;
		assertEquals("Invalid initial value.", 100000, propertyInjectionGenerator.getInitial());

		assertTrue("prefix generator property is invalid.",
				   propertyInjectionGenerator.getPrefixGenerator() instanceof DatePrefixGenerator);

		assertTrue("suffixes property is invalid.",
				   Arrays.<Integer>asList(5, 10, 20).equals(propertyInjectionGenerator.getSuffixes()));
	}
}
