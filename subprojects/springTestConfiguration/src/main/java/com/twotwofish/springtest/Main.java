package com.twotwofish.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        final ApplicationContext context =
            new ClassPathXmlApplicationContext("beans32.xml");

        final SequenceGenerator generator =
            (SequenceGenerator) context.getBean("sequenceGenerator");

        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());

		System.out.println("");
		System.out.println("Generator 1");
		final SequenceGenerator generator1 =
				(SequenceGenerator) context.getBean("sequenceGenerator1");

		System.out.println(generator1.getSequence());
		System.out.println(generator1.getSequence());

		System.out.println("");
		System.out.println("Generator 2");
		final SequenceGenerator generator2 =
				(SequenceGenerator) context.getBean("sequenceGenerator2");

		System.out.println(generator2.getSequence());
		System.out.println(generator2.getSequence());
	}
}
