import java.util.*;
import Annotations.*;

@problemDeff(
		number = 3,
		dateSolved = "9/8/16",
		deff = "Find the largest prime factor of 600851475143",
		notes = "Every non-prime number can be represented by a product of prime numbers"
		)

public class Problem3 {
	
	public static long calculate(){

		long t = 600851475143L;  // answer 6857, takes 3sec
	
		// 0 and 1 are invalid input parameters as they are lower than the smallest prime
		if (t==0 || t==1) return t;
		
		//find representation of t as a product of primes 
		//List<Long> lPrimeFactors = new ArrayList<Long>();
		long i = 2;
		long p = t;
		
		//find the first factor of t, it has to be prime or it would be represented by a*b and then we would have found a or b first
		while (i<p){
			i = SharedFunctions.smallestFactor(p);
			if (i==p) {
				// if i=p there are no more factors left, p is the largest one left
				return p;
			}
			else p = p/i;

			//lPrimeFactors.add(i);
		}
		//System.out.println("array: " + lPrimeFactors.toString());
		
		//should not get here eva
		return -1;
	}
	


	// very slow or very memory abusive solutions .. there to remind me to think!
	public static long calculate1(){

		long t = 600851475143L; 

		// 0 and 1 are invalid input parameters for primeNums
		if (t==0 || t==1) return t;

		// find all prime numbers <= n
		LinkedList<Long> a = SharedFunctions.primeNums(t);

		// if t is prime it is its highest prime factor
		//if (a.get(a.size())==t) return t;
		
		// t is not prime - loop the prime numbers to find the highest which is a factor
		long f = t;
		for (int i=a.size()-1; i>=0; i--){
			if (t%a.get(i)==0){
				f=a.get(i);
				break;
			}
			else continue;
		}
		return f;
		
		// very slow solution
		/*for (i=t; i>=2; i--){
			// check if i is a factor of t, if not test the next smallest number
			if (t%i!=0) continue;
			
			// i is a factor, check if it is prime
			if (SharedFunctions.isPrime(i)) {
				// i is the highest prime factor
				return i;
			}
			else continue; // not prime, continue
		}*/
	}
}
