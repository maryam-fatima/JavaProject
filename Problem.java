package final_TT;

//a singleton class
final class Problem {
		
		private int firstNum = 0;
		private int secondNum = 0;
		
		private static final Problem prblm = new Problem();	
		private Problem(){
			
		}//end no-argument constructor
		
		//return firstNum
		public  int getFirstNum() {
			return firstNum;
		}
		
		//set firstNum	
		public void setFirstNum(int firstNum) {
			this.firstNum = firstNum;
		}
		
		//return secondNum
		public  int getSecondNum() {
			return secondNum;
		}
		
		//set secondNum
		public void setSecondNum(int secondNum) {
			this.secondNum = secondNum;
		}
		
		//return product(answer to problem)
		public int getValue() {
			return firstNum * secondNum;
		}
		
		//get the only instance
		public static Problem getInstance() {
			return prblm;
		}
		
		@Override
		public String toString() {
			return firstNum + " x " + secondNum;
		}

	}//end class Problem

