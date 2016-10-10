import Annotations.*;

@problemDeff(
	number = 2,
	dateSolved = "9/7/16",
	deff = "By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.",
	notes = ""
)
public class Problem2 {
	public static long calculate(){
		long t = 4000000;
		//long t = 89;
		if (t<2) return 0;
		
		int i=1; //0 term
		int j=2; //first term
		int s=2; 
		long sum=0; 
		
		do{
			//increment the total sum
			sum += s;
			
			//odd term
			s = i + j;
			i = j;
			j = s;
			
			//even term - add to total sum
			s = i + j;
			i = j;
			j = s;
		} while (s <= t);
		
		return sum;
	}
	
}
