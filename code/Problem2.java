
public class Problem2 {
	public static int calculate(int t){
		
		if (t<2) return 0;
		
		int i=1; //0 term
		int j=2; //first term
		int s=2; 
		int sum=0; 
		

		
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
