import java.lang.reflect.*;

public class Main {

	public static void main(String[] args) {
	
		int i, n;
		n=0;	// number of problems
		Method m; 
		Object r; 
		
		for (i=1; i<=n; i++){
			try{
				// if the class exists
				m = Class.forName("Problem" + i).getMethod("calculate");
				
				// invoke the calculate function for each problem
				r = m.invoke(null); 
				
			}catch(Exception e){
				//class or method not found, skip to next call
				continue;
			} 
			
			long startTime = System.currentTimeMillis();
			System.out.println("Problem" + i + " returned: " + (Long) r);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Total time: " + totalTime);
		}
		
		//test
		long startTime = System.currentTimeMillis();
		
		System.out.println("Problem101  .. " + Problem15.calculate()); 
		//System.out.println("isPrime  .. " + SharedFunctions.isPrime(600851475143L));
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		
		
	}

}
