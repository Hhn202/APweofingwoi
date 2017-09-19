public class DoubleStackImp implements DoubleStack {

	private Double[] stack;
	private int topOfStack;
	private int sizeOfStack;

	DoubleStackImp(){
		stack = new Double[1000];		// for now, change
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
}
