/*
 * Copyright $today.year Thomson Reuters/ONESOURCE. All rights reserved.
 */

package com.twotwofish.springtest;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Tests the settings in the Java configuration file, using no autowiring. This test uses
 * the {@code @RunWith(SpringJUnit4ClassRunner.class)} that enables configuration of the
 * test class. For this test class the default context file will be:
 * "classpath:/com/twotwofish/springtest/JavaConfigurationTest-context.xml"
 *
 * @author Bill Andrews
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath:simpleJavaConfigContext.xml" })
public final class JavaConfigurationTest
{
	// The Spring context is autowired into the test.
 	@Autowired
	 ApplicationContext context;

	@Test
	public void testUsingJavaConfiguration() throws Exception
	{
		final Object generator = context.getBean("sequenceGenerator");
	  	assertTrue("sequenceGenerator should be a PropertyInjectionGenerator.", generator instanceof PropertyInjectionGenerator);

		final PropertyInjectionGenerator propertyInjectionGenerator = (PropertyInjectionGenerator)generator;
		assertEquals("Invalid initial value.", 100000, propertyInjectionGenerator.getInitial());

		assertTrue("prefix generator property is invalid.",
				   propertyInjectionGenerator.getPrefixGenerator() instanceof DatePrefixGenerator);

		assertTrue("suffixes property is invalid.",
				   Arrays.<Integer>asList(5, 10, 20).equals(propertyInjectionGenerator.getSuffixes()));

		// Ensure we get the same object instance when requesting the same bean.
		final Object generatorSame = context.getBean("sequenceGenerator");
		assertTrue("getBean should return the same instance.", generator == generatorSame);

		// Ensure we get a different instance when requesting a bean by a different name.
		final Object generator2 = context.getBean("sequenceGenerator2");
		assertFalse("getBean should return a different instance.", generator == generator2);

		// Get a generator with a specified name.
		final Object namedGenerator = context.getBean("generator666");
		assertNotNull("Named bean not found.", namedGenerator);

		assertFalse("named bean is not available by default name.", context.containsBean("sequenceGenerator3"));
	}
}
