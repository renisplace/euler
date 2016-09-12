import java.util.*;
import Annotations.*;

public class SharedFunctions {

	public SharedFunctions() {
	}
	
	@methodDeff (
			deff = "Returns the smallest factor of n",
			validParms = "Natural numbers >=2",
			notes = "The smallest factor is prime or it would be represented by a*b which are smaller"
			)
	public static long smallestFactor(long n){
		//find the first factor of t, it has to be prime or it would be represented by a*b and then we would have found a or b first
		long i;
		for (i=2; i<n; i++){
			if (n%i==0) return i;
		}
		return n; // when there are no more factors return the remaining prime number
	}

	// not used, very fast but for smaller numbers
	@methodDeff (
			deff = "Returns the list of all prime numbers <= n",
			validParms = "Natural numbers >=2 as the recurssion depends on 2 as a seed. "
					+ "There is a memory limit to how big of a number can be passed in ~5 digits",
			notes = "A number is prime if it is not divisible by all prime numbers smaller than it"
			)
	public static ArrayList<Long> primeNumsRec(long n){
		ArrayList<Long> a;

		//smallest prime number is 2 - end condition
		if (n==2){
			a = new ArrayList<Long>();
			a.add(n);
			return a;
		}

		//else - recursive call
		int i;
		boolean p = true; // p=true indicates that n is prime
		a = primeNumsRec(n-1);

		// loop a[] to check if one of the prime numbers in it is factor of n
		for (i=0; i<a.size(); i++){
			if (n%(long)a.get(i)==0){
				// n is not prime, i is its factor
				p=false;
				break;
			}
		}
		if (p) a.add(n);
		return a;
	}
	
	// not used, memory efficient but very slow
	@methodDeff (
			deff = "Returns the list of all prime numbers <= n",
			validParms = "Natural numbers >=2 as the loop depends on 2 as a seed. "
					+ "No memory issues but the loop is extremely slow",
			notes = "A number is prime if it is not divisible by all prime numbers smaller than it"
			)
	public static LinkedList<Long> primeNums(long n){
		
		LinkedList<Long> primeArray = new LinkedList<Long>(); //array of consecutive prime numbers {2,3,5,7,..}
		long i;
		int j;
		boolean isPrime;
		
		// the first prime number is 2
		primeArray.add(2L);
		
		// for each number smaller than n
		for (i=2; i<=n; i++) {
			isPrime = true;
			
			// check if it has any prime factors smaller than it
			for (j=0; j<primeArray.size(); j++){
				if (i%primeArray.get(j)==0){
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				// add the new prime number to the array
				primeArray.add(i);
			}
		}
		
		// primeArray contains all prime numbers <= n
		return primeArray;
	}


	@methodDeff (
			deff = "Returns TRUE if n is prime number",
			validParms = "Natural number"
			)
	public static boolean isPrime(long n){
			
		// there is no need to check for numbers higher than sqr root of n however the calculation is not more efficient
		for (long i=2; 2*i<n; i++){
			if (n%i==0) return false;
		}
		return true;

	}

}
