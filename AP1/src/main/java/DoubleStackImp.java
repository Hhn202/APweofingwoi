
public class DoubleStackImp implements DoubleStack {
	
	Double[] stack;
	private int topOfStack;
	private int sizeOfStack;
	
	DoubleStackImp(){
		stack = new Double[topOfStack];
		topOfStack = -1;
	}
	
	public void push(Double element) {
		topOfStack ++;
		stack[topOfStack] = element;	
	}
	
	public Double pop() {
		Double token = null;
		if (sizeOfStack > -1){
			token = stack[topOfStack];
			topOfStack--;
		}
		return token;
	}

	public Double top() {
		Double token = null;
		if(topOfStack > -1) {
			token = stack[topOfStack];
		}
		return token;
	}


	public int size() {
		int size = topOfStack+1;
		return size;
	}
	
	public int append(double i){
		// to do
		return 0;
	}
}
