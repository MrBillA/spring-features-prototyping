package com.twotwofish.springtest;

import java.text.DecimalFormat;
import java.util.List;


public abstract class AbstractSequenceGenerator
{
	protected String buildSequence(final String prefix, final int value, final List<Integer> suffixes)
	{
		StringBuilder builder = new StringBuilder();
		builder.append(prefix);
		builder.append("-");
		builder.append(value);
		DecimalFormat formatter = new DecimalFormat("0000");
		for (int suffix : suffixes)
		{
			builder.append("-");
			builder.append(formatter.format(suffix));
		}

		return builder.toString();
	}
}
