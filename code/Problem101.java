import java.util.*;
import Annotations.*;
import java.lang.Math;

@problemDeff(
		number = 101,
		dateSolved = "9/17/16",
		deff = "Find the largest prime factor of 600851475143",
		notes = "Every non-prime number can be represented by a product of prime numbers"
		)
public class Problem101 {

	public long calculate(){
		
		long valU;
		List<Long> UnVals = new ArrayList<Long>();
		List<Long> coefVals = new ArrayList<Long>();
		List<Long> BOPVals = new ArrayList<Long>();
		
		for (int i=1; i<=10;i++){
			// calculate the first i terms of the generating function
			valU = 1-i+(long)Math.pow(i,2)-(long)Math.pow(i,3)+(long)Math.pow(i,4)-(long)Math.pow(i,5)+(long)Math.pow(i,6)-(long)Math.pow(i,7)+(long)Math.pow(i,8)-(long)Math.pow(i,9)+(long)Math.pow(i,10);
			UnVals.add(valU);
			System.out.println("n=" + i + ", Un=" + valU);
		}
		
		
		long a=0;
		long b=0;
		
		//express b with a when n=1:  b = Un(1) - a
		//use this expression when n=2:  2*a + Un(1)-a = Un(2) => a=Un(2)-Un(1)
		a = UnVals.get(1)-UnVals.get(0);
		b = 1-a;
		
		//OP(2,n) = 682*n - 681
		// the first BOP is for n=3 => 1365
		long BOP1 = a*3+b;
		BOPVals.add(BOP1);
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("BOP(2,n)=" + BOP1);
		
		
		
		
		return -1;
	}
	
	// calculates the coefficients of OP(k,n)
	public long solvePolinom(int k, List<Long> UnVals, List<Long> coefVals){ 
				
		if (k==0){
			// OP(0,n) = 1, the first BOP is 1
			return 1;
		}
		if (k==1){
			// first iteration when k=1 => OP(1,n) = a*n + b
			long c0=0;
			long c1=0;
			
			//express b with a when n=1:  b = Un(1) - a
			//use this expression when n=2:  2*a + Un(1)-a = Un(2) => a=Un(2)-Un(1)
			c0 = UnVals.get(1)-UnVals.get(0);
			c1 = 1-c0;
			
			//return the values of a, b
			coefVals.add(c0);
			coefVals.add(c1);
			
			//OP(2,n) = 682*n - 681
			// the first BOP is for n=3 => 1365
			return c0*3+c1;
		}
		
		// recursion (c0 to ck are the coefficients in coefVals)
		// OP(k,n)=c0*pow(n,k)+c1*pow(n,k-1)+ .. + ck*pow(n,1)+ck
		// and PO(k,n)=Un(n) for n=1 .. n=k
		// then c0 = (Un(n) - OP(k-1,n))/pow(n,k)
		// and we can find c1, c2 .. ck by calling the previous iteration of the recursive function, 
		// then substitute them in OP(k-1,n) to find the value of c0
		// once we know c0, c1 .. ck we can calculate the first BOP for OP(k,n) which will be for n=k+1
		
		return -1;
	}
	
}
