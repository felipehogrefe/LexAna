public class Token{
	public TokenType type;
	public String val;
	public int line;
	public int col;
	
	public Token (int line, int col,String val){
		this.type = setType(val);
		this.val = val;
		this.line = line;
		this.col = col;
	}
	
	private TokenType setType(String val) {
		//seta a categoria do token
		if(checkSEP(val)){
			return TokenType.SEP;
		}else if(checkLIT(val)){
			return TokenType.LIT;
		}else if(checkOPR(val)){
			return TokenType.OPR;
		}else if(LexTable.lMap.containsKey(val)){
			//palavras reservadas
			return TokenType.KEY;
		}else if(checkCOM(val)){
			return TokenType.COM;
		}else if(checkID(val)){
			return TokenType.ID;
		}
		
		return null;
	}
	private boolean checkCOM(String val) {
		if(val.startsWith("//")){
			//comentario de linha unica
			return true;
		}else if(val.startsWith("/**") && val.endsWith("*/")){
			//comentario de multiplas linhas
			return true;
		}
		return false;
	}

	
	private boolean checkLIT(String val) {
		if(val=="(\\d)+\\.(\\d)+"||val=="(\\d)+\\."||val=="(\\d)+"){
			//numericas
			return true;
		}else if (val.startsWith("\"") && val.endsWith("\"")){
			//strings
			return true;
		}else if(val.matches("'(.?)'")){
			//chars
			return true;
		}
		else if(val == "true"||val == "false"){
			//booleanos
			return true;
		}else if(val=="\n"||val=="\t"||val=="\b"||val=="\r"||val=="\f"||val=="\\"
				||val=="\\"||val=="\'"||val=="\""){
			return true;
		}
		return false;
	}

	private boolean checkSEP(String val) {
		//separadores
		if(val.matches("[{}().;,\\[\\]]")){
			return true;
		}
		return false;
	}

	private boolean checkOPR(String val){
		//operadores
		if(val.matches("[=<>!|+-^*~?:&/%]")||val.matches("[=<>!+^*|-~&/%][=]")||val=="++"
				||val=="--"||val==">>"||val=="<<"){
			return true;
		}
		return false;
	}

	private boolean checkID(String val) {
		//identificadores
		if (val.matches("^[A-Za-z][A-Za-z0-9_]*")) {
			return true;			
		}
		return false;
	}

	public TokenType getCategory() {
		return this.type;
	}
	
	public String toString(){
		return line+", "+col+", "+type+", "+val;
	}

	public String getValue() {
		return val;
	}
}