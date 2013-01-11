package com.twotwofish.springtest;

import java.util.List;

import javax.annotation.Resource;


/**
 * This class does not use Spring IOC annotations
 */
public class PropertyInjectionGenerator extends AbstractSequenceGenerator implements ISequenceGenerator {

    private List<Integer> suffixes;
    private int initial;
    private int counter;

    private IPrefixGenerator prefixGenerator;

	public void setPrefixGenerator(IPrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}

	public IPrefixGenerator getPrefixGenerator()
	{
		return prefixGenerator;
	}

	public void setSuffixes(List<Integer> suffixes) {
		this.suffixes = suffixes;
	}

	public List<Integer> getSuffixes() {
		return suffixes;
	}

	public void setInitial(int initial) {
        this.initial = initial;
    }

	public int getInitial()
	{
		return initial;
	}

    public synchronized String getSequence() {
		return buildSequence(prefixGenerator.getPrefix(), initial + counter++, suffixes);
    }
}
