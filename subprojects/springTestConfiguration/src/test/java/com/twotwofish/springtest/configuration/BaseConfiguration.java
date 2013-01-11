/*
 * Copyright $today.year Thomson Reuters/ONESOURCE. All rights reserved.
 */

package com.twotwofish.springtest.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.twotwofish.springtest.DatePrefixGenerator;
import com.twotwofish.springtest.PropertyInjectionGenerator;


/**
 * BaseConfiguration Description.
 *
 * @author Bill Andrews
 */
@Configuration
public class BaseConfiguration
{
	private PropertyInjectionGenerator baseSequenceGenerator()
	{
		final PropertyInjectionGenerator instance = new PropertyInjectionGenerator();

		instance.setPrefixGenerator(datePrefixGenerator());
		instance.setSuffixes(suffixes());
		instance.setInitial(100000);

		return instance;
	}

	@Bean
	public PropertyInjectionGenerator sequenceGenerator()
	{
		return baseSequenceGenerator();
	}


	@Bean
	public PropertyInjectionGenerator sequenceGenerator2()
	{
		return baseSequenceGenerator();
	}


	@Bean(name = "generator666")
	public PropertyInjectionGenerator sequenceGenerator3()
	{
		final PropertyInjectionGenerator generator = baseSequenceGenerator();

		generator.setInitial(666);

		return generator;
	}


	@Bean
	public List<Integer> suffixes()
	{
		return Arrays.<Integer>asList(5, 10, 20);
	}


	@Bean
	public DatePrefixGenerator datePrefixGenerator()
	{
		final DatePrefixGenerator instance = new DatePrefixGenerator();
		instance.setPattern("yyyyMMdd");

		return instance;
	}
}
