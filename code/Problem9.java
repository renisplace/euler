import Annotations.*;
import java.lang.Math;

@problemDeff(
	number = 9,
	dateSolved = "9/11/16",
	deff = "Find the product (a*b*c) of the only Pythagorean triplet (sq(a) + sq(b) = sq(c) and a<b<c) for which a+b+c=1000",
	notes = ""
)
public class Problem9 {

	public static long calculate(){
		
		int t = 12; // 3+4+5
		//int t = 1000;
		int a,b;
		int A = -1;
		int B = -1;
		int C = -1;
		boolean bSolved=false;
		
		//a<b<c and Sq(a)+Sq(b)=Sq(c) => a>=1 and b>1
		//a<b<c and a+b+c=1000 => c>=334 and b<=333 and a<333
		for (b=2; b<333; b++){
			for (a=1;a<b;a++){
				// c can be presented as a function of a and b => c=SqRt(Sq(a)+Sq(b))
				// a+b+c=1000
				// Sq(a+b+c) = Sq(1000)
				// Sq(a)+Sq(b)+Sq(c)+2ab+2bc+2ac+4abc = 1000000
				// replace c with its representation as a function of a and b
				// 2*Sq(a)+2*Sq(b)+(2a+2b+4ab)*SqRt(Sq(a)+Sq(b))+2ab = 1000000
				// now that we have an equation for a and b this loop should find which are the only two numbers that fulfill it
				
				if (validateEquasion(a,b,t)) {
					//if the equation is true then those a and b are the ones we need (there is only one such combination of a,b,c)
					A = a;
					B = b;
					C = (int) Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
					bSolved = true;
					break;
				}
			}
			if (bSolved) break;
		}
		
		//A, B and C contain the solution
		if (Math.pow(A,2) + Math.pow(B,2) == Math.pow(C, 2)) {
			//find the product
			return A*B*C;
		}
		return -1;
	}
	
	
	public static boolean validateEquasion(int a, int b, int limit){
		if (2*Math.pow(a,2) + 2*Math.pow(b,2) + (2*a+2*b+4*a*b)*(Math.sqrt(Math.pow(a,2)+Math.pow(b,2))) + 2*a*b == Math.pow(limit, 2)) return true;
		return false;
	}

}
