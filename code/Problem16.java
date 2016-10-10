	import java.util.ArrayList;
import java.util.List;

import Annotations.problemDeff;
	
public class Problem16 {

	@problemDeff(
		number = 16,
		dateSolved = "10/9/16",
		deff = "pow(2,15) = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26. What is the sum of the digits of the number pow(2,1000)?",
		notes = ""
	)
	public long calculate(){
		
		int n = 1000; //Result .. 1366
		
		List<Integer> outDigits = new ArrayList<Integer>();
		int sum = 0; // the sum of all digits of pow(2,1000)
		
		//find the list of digits
		outDigits = findDigits(n);
				
		//add up the digits 
		for (int i=0; i<outDigits.size();i++){
			sum += outDigits.get(i);
		}
		
		return sum;
	}
	
	protected List<Integer> findDigits(int n){
		
		List<Integer> outDigits = new ArrayList<Integer>();
		
		//recursion seed 
		if (n==1){
			outDigits.add(2);
			return outDigits;
		}
		else{
			List<Integer> inDigits = new ArrayList<Integer>();
			inDigits = findDigits(n-1);
			boolean extraDigit = false;
			int overflow=0;
			
			// if the first digit is over 4 the number of digits in the number will increase, the outDigits will have an extra element
			if (inDigits.get(0)>4) extraDigit = true; 
				
			// we can find the list of digits of pow(2,n) if we know the list of digits of pow(2,n-1), pow(2,n)=2*pow(2,n-1)
			for (int i=inDigits.size()-1;i>=0;i--){
				
				//find the new digit at index i
				int newDigit = (2*inDigits.get(i))%10;
				
				outDigits.add(0, newDigit+overflow);
				
				// determine if 1 needs to be added in the next iteration 
				if (inDigits.get(i)>4) overflow=1; 
				else overflow=0;
			}
			
			if (extraDigit){
				outDigits.add(0, 1); // add the overflow 1 at position 0
			}
		}
		
		
		return outDigits;
	}
}
