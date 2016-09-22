
public enum TokenType {	
	ID(1), 
	KEY(2), 
	SEP(3), 
	OPR(4), 
	LIT(5), 
	COM(6);
	private int value;
	
	private TokenType(int val){
		this.value=val;
	}
	
	public int getType(){
		return value;
	}

}
