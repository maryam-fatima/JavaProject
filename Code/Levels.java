package final_TT;


import java.util.Random;

abstract class Level{

	private Problem prblm = Problem.getInstance();
	private Random random = new Random();
		
	public abstract void generateRandom();
	
	protected Level() {
		
	}
	
	public int getRndInt(int min, int max) {
		  return (random.nextInt(max - min + 1) + min);
		  //including minimum and maximum
	}

	//return problem
	public Problem getPrblm() {
		return prblm;
	}	
	
 }//end abstract class level

 final class Easy extends Level{

	 Easy(){
		 
	 }

	@Override
	public  void generateRandom() {
		
		//generating random integers between 2-8 for multiplicand
        getPrblm().setFirstNum(getRndInt(2, 8));      
        //generating random integers between 1-10 for multiplier
        getPrblm().setSecondNum(getRndInt(1, 10));       
        
	}	
 }//end class easy
 
final class Medium extends Level{
	 
	 Medium(){
		 
	 }

	@Override
	public void generateRandom() {
		
		//generating random integers between 4-12 for multiplicand
		getPrblm().setFirstNum(getRndInt(4,12));      
        //generating random integers between 2-10 for multiplier
		getPrblm().setSecondNum(getRndInt(2,10));

		
	}	
 }//end class medium
 
final class Difficult extends Level{

	 Difficult(){
		 
	 }

	@Override
	public void generateRandom() {
			
		//generating random integers between 7-15 for multiplicand
		getPrblm().setFirstNum(getRndInt(7,15));      
        //generating random integers between 4-12 for multiplier
		getPrblm().setSecondNum(getRndInt(4,12));       

	}	
 }//end class difficult
