package com.twotwofish.springtest;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

public class SequenceGenerator extends AbstractSequenceGenerator implements ISequenceGenerator {

    private List<Integer> suffixes;
    private int initial;
    private int counter;

    @Resource(name = "datePrefixGenerator")
    private IPrefixGenerator prefixGenerator;

/*    public IPrefixGenerator getPrefixGenerator() {
		return prefixGenerator;
	}

	public void setPrefixGenerator(IPrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}
*/
	public void setSuffixes(List<Integer> suffixes) {
        this.suffixes = suffixes;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public synchronized String getSequence() {
		return buildSequence(prefixGenerator.getPrefix(), initial + counter++, suffixes);
    }
}
