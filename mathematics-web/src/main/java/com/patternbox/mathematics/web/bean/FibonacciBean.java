package com.patternbox.mathematics.web.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patternbox.mathematics.commons.qualifier.Algorithm;
import com.patternbox.mathematics.commons.qualifier.AlgorithmType;
import com.patternbox.mathematics.fibonacci.FibonacciException;
import com.patternbox.mathematics.fibonacci.FibonacciService;

/**
 * @author <a href='http://www.patternbox.com'>D. Ehms, Patternbox</a>
 */
@Named("fiboBean")
@ConversationScoped
public class FibonacciBean implements Serializable {

	private static final long serialVersionUID = -5284117728637787023L;

	@Inject
	@Algorithm(AlgorithmType.RECURSIVE)
	private FibonacciService service;

	private Integer length;

	public Integer getLength() {
		return null;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public ArrayList<Long> getResult() throws FibonacciException {
		ArrayList<Long> result = new ArrayList<Long>();
		if (length != null) {
			long[] sequence = service.compute(length);
			for (int i = 0; i < sequence.length; i++) {
				result.add(sequence[i]);
			}
		}
		return result;
	}
}
