
public class CalcStack {
	private StringStack myCharStack;
	private StringStack myNumStack;

	public CalcStack(){
		myCharStack = new StringStack();
		myNumStack = new StringStack();
	}
	
	String special = "+-*/";
	public void compute(String data){
		//TODO
	}
	
	public void computeOp(String data, int priority){
		if(myCharStack.isEmpty()){
			myCharStack.push(data);
			return;
		}
		
		// TODO

	}
	
	public void performOp(char op){

	}
	
	public void finishCompute(){
		while(!myCharStack.isEmpty()){
			performOp(myCharStack.pop().charAt(0));
		}
	}
		
	public static void main(String[] args){
		CalcStack stack = new CalcStack();
		String equation = "5+7*3-2";

		for(int i=0; i < equation.length(); i++){
			stack.compute(equation.substring(i,i+1));
		}
		stack.finishCompute();
		System.out.println(stack.myNumStack.pop());
	}

}
