import java.lang.reflect.Method;

public class Controller {
		
		protected boolean calcAllProblems(){
			
			int i, n;
			n=200;	// number of problems
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
			
			return true;
		}
		
		protected boolean calcProblem(int n){
			
			Method m; 
			Object r = new Object(); 

			try{
				// if the class exists
				m = Class.forName("Problem" + n).getMethod("calculate");
				
				// invoke the calculate function for each problem
				r = m.invoke(null); 
				
			}catch(Exception e){
				//class or method not found
				System.out.println("Class/method not found: " + e.getMessage());
				return false;
			} 
			
			long startTime = System.currentTimeMillis();
			System.out.println("Problem" + n + " returned: " + (Long) r);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Total time: " + totalTime);
			
			return true;
		}
		
		protected boolean test(){
			//test
			long startTime = System.currentTimeMillis();
			
			Problem16 T = new Problem16();
			
			System.out.println("Result .. " + T.calculate()); 
			//System.out.println("isPrime  .. " + SharedFunctions.isPrime(600851475143L));
			
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println(totalTime);
			
			return true;
		}

}
