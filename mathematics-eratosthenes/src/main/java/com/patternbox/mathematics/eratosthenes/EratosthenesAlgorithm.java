package com.patternbox.mathematics.eratosthenes;

/**
 * Source: http://www.raditha.com/java/primes.php
 * 
 * @author <a href='http://www.patternbox.com'>D. Ehms, Patternbox</a>
 */
public class EratosthenesAlgorithm {

	private final int max;

	private int primes[];

	public EratosthenesAlgorithm(int max) {
		this.max = max;
	}

	public void find_primes() {
		int i, j, k, divisor, offset;
		double sqrt = Math.sqrt(max) + 1;
		int tmp[];
		if (max > 100) {
			primes = new int[max / 2];
		} else {
			primes = new int[max];
		}
		primes[0] = 2;
		primes[1] = 3;
		for (i = 2, j = 5; j < max; j += 2) {
			if (j % 3 != 0) {
				primes[i++] = j;
			}
		}
		for (i = 2, divisor = 5, offset = primes.length; divisor < sqrt;) {
			j = i * i;
			tmp = new int[offset];
			offset = j;
			/*
			 * Copy the numbers that have already been sieved to a new array.
			 */
			System.arraycopy(primes, 0, tmp, 0, j);
			while (j < tmp.length) {
				k = primes[j++];
				if (k == 0) {
					/*
					 * The array may contain some zeros at the end. It's too much trouble to calculate the
					 * exact size for the array. Easier to pad with zeros
					 */
					break;
				}
				if (k % divisor != 0) {
					tmp[offset++] = k;
				}
			}
			primes = null;
			primes = tmp;
			tmp = null;
			divisor = primes[i++];
		}
	}

	/**
	 * @return the primes
	 */
	public int[] getPrimes() {
		return primes;
	}
}
