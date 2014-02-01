/**************************** Copyright notice ********************************

Copyright (C)2013 by D. Ehms, http://www.patternbox.com
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:
1. Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
notice, this list of conditions and the following disclaimer in the
documentation and/or other materials provided with the distribution.
THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
SUCH DAMAGE.
 ******************************************************************************/
package com.patternbox.mathematics.fibonacci;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.patternbox.mathematics.commons.qualifier.Algorithm;
import com.patternbox.mathematics.commons.qualifier.AlgorithmType;

@SuppressWarnings("serial")
@Algorithm(AlgorithmType.RECURSIVE)
public class FibonacciRecursive implements FibonacciService, Serializable {

	@Inject
	private Logger logger;

	private long fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.patternbox.mathematics.fibonacci.FibonacciService#compute(int)
	 */
	@Override
	public long[] compute(int length) throws FibonacciException {
		logger.info("Recursive computing fibonacci numbers for input: " + length);
		if (length < 0) {
			throw new FibonacciException("Argument should be positive");
		}
		long[] suite = new long[length + 1];
		for (int i = 0; i < length; i++) {
			suite[i] = fib(i);
		}
		return suite;
	}
}
