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

import javax.enterprise.context.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.patternbox.mathematics.commons.qualifier.Algorithm;
import com.patternbox.mathematics.commons.qualifier.AlgorithmType;

@SuppressWarnings("serial")
@Algorithm(AlgorithmType.ITERATIVE)
@Path("/fibo/{length}")
@SessionScoped
public class FibonacciIterative implements FibonacciService, Serializable {

	// @Inject
	private final Logger logger = Logger.getLogger(FibonacciIterative.class.getName());;

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.patternbox.mathematics.fibonacci.FibonacciService#compute(int)
	 */
	@GET
	@Produces("application/json")
	@Override
	public long[] compute(@PathParam("length") int length) throws FibonacciException {
		logger.info("Iterative computing fibonacci numbers for input: " + length);
		if (length < 0) {
			throw new FibonacciException("Argument should be positive");
		}
		long[] suite = new long[length + 1];
		suite[0] = 0;
		if (length == 0) {
			return suite;
		}
		suite[1] = 1;
		for (int i = 2; i <= length; i++) {
			suite[i] = suite[i - 1] + suite[i - 2];
		}
		return suite;
	}
}
