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
	static final String LEFT_PARENTHESIS = "(";
	static final String RIGHT_PARENTHESIS = ")";

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
		return(OPERATOR_TOKENS.contains(in.next()));
	}
	
	boolean tokenIsParenthesis(String token) {
		Scanner in = new Scanner(token);
		return(PARENTHESES.contains(in.next()));
	}

	private Token parseNumber(String token) {
		Token result = new TokenImp(1, token, -1);
		return result;
	}
	
	private Token parseOperator(String token) {
		Token result = null;
		if (token.equals(PLUS_TOKEN )) {
			result = new TokenImp(2, token, 1);
		}else if (token.equals(MINUS_TOKEN )) {
			result = new TokenImp(2, token, 1);
		}else if (token.equals(MULTIPLICATION_TOKEN)) {
			result = new TokenImp(2, token, 2);
		}else if (token.equals(DIVISION_TOKEN)) {
			result = new TokenImp(2, token, 2);
		}else if (token.equals(SQUARE_TOKEN)) {
			result = new TokenImp(2, token, 3);
		}
		return result;
	}
	
	private Token parseParenthesis(String token) {
		Token result = new TokenImp(3, token, -1);
		return result;
	}
    


    public Double rpn(TokenList tokens) {
    	DoubleStack stack = new DoubleStackImp();
    	for(int i=0;i<tokens.size();i++){
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
    	TokenList input = tokens;
    	
    	TokenList result = new TokenListImp();
    	TokenStack stack = new TokenStackImp();
    	int i = 0;
    	while (i< input.size()){
    		Token token = input.get(i);
    		i++;
    		if (token.getType()== Token.NUMBER_TYPE){
    			result.add(token);
    		}
    		else if (token.getType()== Token.OPERATOR_TYPE){
    			while(stack.size()!= 0 && stack.top().getPrecedence() >= token.getPrecedence()) {		// ??
    				result.add(stack.pop());
    			}
    			stack.push(token);	
    		}
    		if (token.getValue().equals(LEFT_PARENTHESIS)){
    			stack.push(token);
    		}
    		if (token.getValue().equals(RIGHT_PARENTHESIS)){
    			while(!stack.top().getValue().equals(LEFT_PARENTHESIS)){
    				result.add(stack.pop());
    			}
    			stack.pop();
    		}
    		
    	}
    	
    	while (stack.size() != 0){
    		result.add(stack.pop());
    	}
        
        return result;
    }

    private void start() {
    	Scanner in = new Scanner(System.in);
    	PrintStream out = new PrintStream(System.out);
		while(in.hasNext()) {
			TokenList oneLineList = readTokens(in.nextLine());
			
			
			
			
			TokenList inputInRPN = shuntingYard(oneLineList);
			out.println("ok");
			int i = 0;
			while(i<inputInRPN.size()){
				out.print(inputInRPN.get(i).getValue());
				i++;
			}
			out.println("rpn done");
			Double result = rpn(inputInRPN);
			out.println("calculation done");
			out.println(result);
		}
	}
    public static void main(String[] argv) {
        new Main().start();
    }
}
