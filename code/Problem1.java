import Annotations.*;

@problemDeff(
	number = 1,
	dateSolved = "9/7/16",
	deff = "Find the sum of all the multiples of 3 or 5 below 1000 ",
	notes = ""
)
public class Problem1 {
	
	public static long calculate(){
		long t = 1000;
		int i;
		long s3=0;
		long s5=0;
		
		//sum of numbers divisible by 3
		for (i=3; i<t; i+=3){
			//need to remove numbers divisible by both 3 and 5, would be counted twice
			//numbers divisible by 5 end in 5 or 0
			if ((i%10!=0 && i%10!=5))	s3 = s3 + i;
		}
		
		//sum of numbers divisible by 5
		for (i=5; i<t; i+=5)
			s5 = s5 +i;
		

		return s3 + s5;
	}
	

}
