
public class Problem1 {
	
	public static int calculate(int t){
		int i,s3,s5;
		s3=0;
		s5=0;
		
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
