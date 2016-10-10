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

	public static long calculate(){
		
		long valU;
		List<Long> UnVals = new ArrayList<Long>();
		
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
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("BOP(2,n)=" + BOP1);
		
		return -1;
	}
	
}
