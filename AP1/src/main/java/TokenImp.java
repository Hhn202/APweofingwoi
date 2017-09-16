
public class TokenImp implements Token {
	
	private int type;
	private String value;
	private int precedence;
	
	public TokenImp(int type, String value, int precedence) {
		this.type = type;
		this.value = value;
		this.precedence = precedence;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}

}
