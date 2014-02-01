package com.patternbox.mathematics.web.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patternbox.mathematics.eratosthenes.EratosthenesService;

/**
 * @author <a href='http://www.patternbox.com'>D. Ehms, Patternbox</a>
 */
@SuppressWarnings("serial")
@Named("eratosBean")
@ConversationScoped
public class EratosthenesBean implements Serializable {

	@Inject
	private EratosthenesService service;

	private Integer max;

	public Integer getMax() {
		return null;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public ArrayList<Integer> getResult() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (max != null) {
			int[] sequence = service.compute(max);
			for (int i = 0; i < sequence.length; i++) {
				result.add(sequence[i]);
			}
		}
		return result;
	}
}
