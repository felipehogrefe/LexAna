import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LexicalAnalyzer {
	private ArrayList<String> lines;
	private int cLine, cColumn, tStartL=0, tStartC=0;
	private String line;
	
	
	public LexicalAnalyzer(){
		this.lines = new ArrayList<>();
	}
	
	public void read(String file){
		//preenche o array de linhas a partir da fonte
		BufferedReader r;
		
		try{
			//abre novo arquivo
			r = new BufferedReader(new FileReader(file));
			
			String line = r.readLine();
			
			while(line!=null){
				//enquanto houver linhas, adiciona na lista de linhas
				lines.add(line);
				line=r.readLine();
			}
			r.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Token nextToken(){
		//
		char cChar;
		String tValue = "";
		
		tStartL = cLine;
		tStartC = cColumn;
		
		cChar = line.charAt(cColumn);

		while (Character.toString(cChar).matches(" ") ||Character.toString(cChar).matches("\t")) {
			//while criado para pular espaços em branco
			cChar = nextChar();
			tStartC++;
		}
		
		if(Character.toString(cChar).matches("\\d")){
			//é uma constante, vamos concatenar o numero completo
			tValue +=cChar;
			cChar = nextChar();
			while(Character.toString(cChar).matches("\\d")){
				tValue +=cChar;
				cChar = nextChar();
			}
			//tratamos um inteiro, vamos tratar ponto flutuantes agora
			if(cChar=='.'){
				tValue +=cChar;
				cChar = nextChar();
				System.out.println("aaaaaaa"+tValue);
				while(Character.toString(cChar).matches("\\d")){
					tValue +=cChar;
					cChar = nextChar();
				}
			}
			
		}else{
			//cChar nao e um digito, logo é um id ou palavra chave, vamos compor
			while(!LexTable.sList.contains(cChar) && cChar != '\n'){
				tValue += cChar;
				cChar = nextChar();
			}	
		}
		//lemos um token que pode ser um numero, um id ou um simbolo da linguagem
		//vamos agora tratar o token
		
		if(tValue==""){
			//nao entrou em nenhuma verificacao anterior, o valor esta vazio, logo e 
			//um simbolo da linguagem, da tabela de simbolos temos um switch:
			switch(cChar){
			case '"':
				//tratamento de coisas do tipo "aaa"
				tValue += cChar;
				cChar = nextChar();
				
				if(cChar == '"'){
					tValue += cChar;
					cColumn++;
				}
				while(cChar != '\n' && cChar != '"'){
					tValue += cChar;
					cChar = nextChar();
					if(cChar == '"'){
						tValue += cChar;
						cColumn++;
					}
				}
				break;
			case '/':
				tValue += cChar;
				cChar = nextChar();
				if(cChar == '/'||cChar == '*'){
					tValue += cChar;
					//implementar tratamento de comentario
				}
				// se for apenas o / e uma divisao
				break;
			case '\'':
				//tratamento de coisas do tipo 'a'
				tValue += cChar;
				cChar = nextChar();
				if (cChar != '\n') {
					tValue += cChar;
				}
				cChar = nextChar();
				if (cChar == '\'') {
					tValue += cChar;
					cColumn++;
				}
				break;
			case '=':
			case '<':
			case '!':
			case '~':
			case '^':
			case '*':
			case '%':
			case '|':
				//tratamento de coisas do tipo 'carac'=
				tValue += cChar;
				cChar = nextChar();
				if(cChar == '='){
					tValue += cChar;
					cColumn++;
				}
				break;
			case '+':
				tValue += cChar;
				cChar = nextChar();
				if(cChar == '+'||cChar == '='){
					tValue += cChar;
					cColumn++;
				}
				break;
			case '-':
				tValue += cChar;
				cChar = nextChar();
				if(cChar == '-'||cChar == '='){
					tValue += cChar;
					cColumn++;
				}
				break;
			case '&':
				tValue += cChar;
				cChar = nextChar();
				if(cChar == '&'||cChar == '='){
					tValue += cChar;
					cColumn++;
				}
				break;
			default:
				tValue += cChar;
				cColumn++;
				break;
			// implementar tratamento de shift >>>, >>= etc				
			}
		}
		
		Token t = new Token(tStartL,tStartC,tValue);
		
		if (t.getCategory().equals(TokenType.COM)) {
			if (isOver()) {
				return nextToken();
			}
		}
		return t;
	}

	boolean isOver() {
		if(!lines.isEmpty()){
			if(cLine<lines.size()){
				line = lines.get(cLine);
				line = line.replace('\t', ' ');
				if (line.substring(cColumn).matches("\\s*")) {
					cLine++;
					cColumn = 0;
					while (cLine < lines.size()) {
						line = lines.get(cLine);
						if (line.matches("\\s*")) {
							cLine++;
						} else {
							return true;
						}
					}
				} else if (cColumn < line.length()) {
					return true;
				} else {
					cLine++;
					cColumn = 0;
					while (cLine < lines.size()) {
						line = lines.get(cLine);
						if (line.matches("\\s*")) {
							cLine++;
						} else {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private char nextChar() {
		cColumn ++;
		if(cColumn<line.length()){
			return line.charAt(cColumn);
		}else{
			return '\n';
		}	
	}
}
