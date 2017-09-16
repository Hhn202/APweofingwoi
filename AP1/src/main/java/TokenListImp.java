
public class TokenListImp implements TokenList {
	
	private Token[] tokenList;					// make max 100 for now, fix later
	private int size;
	
	TokenListImp() {
		tokenList = new Token[100];
		size = 0;
		
	}

	@Override
	public void add(Token token) {
		tokenList [size] = token;
		size ++;

	}

	@Override
	public void remove(int index) {						// ok to assume preconditions are met?
		tokenList [index] = null;
		size --;

	}

	@Override
	public void set(int index, Token token) {
		tokenList [index] = token;						// size does not change?

	}

	@Override
	public Token get(int index) {
		Token token;
		token = tokenList[index];	
		return token;
	}

	@Override
	public int size() {
		return size;
	}

}
