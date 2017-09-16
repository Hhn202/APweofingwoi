import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements CalculatorInterface {
	
	static final int PLUS_TOKEN = '+';
	static final int MINUS_TOKEN = '-';
	static final int MULTIPLICATION_TOKEN = '*';
	static final int DIVISION_TOKEN = '/';
	static final int SQUARE_TOKEN = '^';
	static final String OPERATOR_TOKENS = "+-*/^";
	static final String PARENTHESES = "()";

    public TokenList readTokens(String input) {
    	Scanner in = new Scanner(input);
		TokenList result = new TokenListImp();
		
		while (in.hasNext()) {
			String token = in.next();

			if (tokenIsDouble(token)) {
				result.add(parseNumber(token));
			} else if (tokenIsOperator(token)) {
				result.add(parseOperator(token));
			} else if (tokenIsParenthesis(token)) {
				result.add(parseParenthesis(token));
			} else {
				// error
			}	
		}

		return result;
	}
	
	boolean tokenIsDouble(String token) {
		Scanner in = new Scanner(token);
		return in.hasNextDouble();
	}
	
	boolean tokenIsOperator(String token) {
		Scanner in = new Scanner(token);
		return(OPERATOR_TOKENS.contains(in.toString()));
	}
	
	boolean tokenIsParenthesis(String token) {
		Scanner in = new Scanner(token);
		return(PARENTHESES.contains(in.toString()));
	}

	private Token parseNumber(String token) {
		Token result = new TokenImp(1, token, 0);
		return result;
	}
	
	private Token parseOperator(String token) {
		Token result = new TokenImp(2, token, 0);
		return result;
	}
	
	private Token parseParenthesis(String token) {
		Token result = new TokenImp(3, token, 0);
		return result;
	}
    


    public Double rpn(TokenList tokens) {
    	DoubleStack stack = new DoubleStackImp();
    	for(int i=0;i>tokens.size();i++){
    		Token token = tokens.get(i);
    		if(TokenImp.NUMBER_TYPE==token.getType()){
    			double value = Double.parseDouble(token.getValue());
    			stack.push(value);
    		}else if(TokenImp.OPERATOR_TYPE==token.getType()){
    			performOperation(token,stack);
    		}
    	}
    	if(stack.size()==1){
    		return stack.pop();
    	}else{
    		//Error out invalid
    	}
        // TODO: Implement this
    	
        return null;
    }
 
    private void performOperation(Token operator, DoubleStack stack) {
    	double a = stack.pop();
    	double b = stack.pop();
    	if (operator.equals(PLUS_TOKEN )) {
    		stack.push(a + b);
    	}else if (operator.equals(MINUS_TOKEN)) {
    		stack.push(a - b);
    	}else if (operator.equals(MULTIPLICATION_TOKEN)) {
    		stack.push(a * b);
    	}else if (operator.equals(DIVISION_TOKEN)) {
    		stack.push(a / b);
    	}else if (operator.equals(SQUARE_TOKEN)) {
    		double square = Math.pow(a, b);
    		stack.push(square);
    	}
    }

    public TokenList shuntingYard(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    private void start() {
    	Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			TokenList oneLineList = readTokens(in.nextLine());
			// do the rest of calculation?
		}

		// While there is input, read line and parse it.
	}
    public static void main(String[] argv) {
        new Main().start();
    }
}
