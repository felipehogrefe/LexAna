import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;

public class LexTable {
	public static Map<String, TokenType> lMap = new HashMap<>();
	public static List<Character> sList = new ArrayList<>();//symbolList
	
	static{
		//palavras reservadas da linguagem
		lMap.put("abstract", TokenType.KEY);
		lMap.put("main", TokenType.KEY);
		lMap.put("continue", TokenType.KEY);
		lMap.put("goto", TokenType.KEY);
		lMap.put("package", TokenType.KEY);
		lMap.put("switch", TokenType.KEY);
		lMap.put("assert", TokenType.KEY);
		lMap.put("default", TokenType.KEY);
		lMap.put("if", TokenType.KEY);
		lMap.put("private", TokenType.KEY);
		lMap.put("print", TokenType.KEY);
		lMap.put("this", TokenType.KEY);
		lMap.put("boolean", TokenType.KEY);
		lMap.put("do", TokenType.KEY);
		lMap.put("implements", TokenType.KEY);
		lMap.put("protected", TokenType.KEY);
		lMap.put("throw", TokenType.KEY);
		lMap.put("break", TokenType.KEY);
		lMap.put("double", TokenType.KEY);
		lMap.put("import", TokenType.KEY);
		lMap.put("public", TokenType.KEY);
		lMap.put("throws", TokenType.KEY);
		lMap.put("byte", TokenType.KEY);
		lMap.put("else", TokenType.KEY);
		lMap.put("instanceof", TokenType.KEY);
		lMap.put("return", TokenType.KEY);
		lMap.put("transient", TokenType.KEY);
		lMap.put("case", TokenType.KEY);
		lMap.put("extends", TokenType.KEY);
		lMap.put("int", TokenType.KEY);
		lMap.put("short", TokenType.KEY);
		lMap.put("try", TokenType.KEY);
		lMap.put("catch", TokenType.KEY);
		lMap.put("final", TokenType.KEY);
		lMap.put("interface", TokenType.KEY);
		lMap.put("static", TokenType.KEY);
		lMap.put("void", TokenType.KEY);
		lMap.put("char", TokenType.KEY);
		lMap.put("finally", TokenType.KEY);
		lMap.put("long", TokenType.KEY);
		lMap.put("strictfp", TokenType.KEY);
		lMap.put("volatile", TokenType.KEY);
		lMap.put("class", TokenType.KEY);
		lMap.put("float", TokenType.KEY);
		lMap.put("native", TokenType.KEY);
		lMap.put("super", TokenType.KEY);
		lMap.put("while", TokenType.KEY);
		lMap.put("const", TokenType.KEY);
		lMap.put("for", TokenType.KEY);
		lMap.put("new", TokenType.KEY);
		lMap.put("synchronized", TokenType.KEY);
		
		//operadores da linguagem
		lMap.put("=", TokenType.KEY);
		lMap.put("<", TokenType.KEY);
		lMap.put(">", TokenType.KEY);
		lMap.put("!", TokenType.KEY);
		lMap.put("~", TokenType.KEY);
		lMap.put("?", TokenType.KEY);
		lMap.put(":", TokenType.KEY);
		lMap.put("==", TokenType.KEY);
		lMap.put("<=", TokenType.KEY);
		lMap.put(">=", TokenType.KEY);
		lMap.put("!=", TokenType.KEY);
		lMap.put("&&", TokenType.KEY);
		lMap.put("||", TokenType.KEY);
		lMap.put("++", TokenType.KEY);
		lMap.put("--", TokenType.KEY);
		lMap.put("+", TokenType.KEY);
		lMap.put("-", TokenType.KEY);
		lMap.put("*", TokenType.KEY);
		lMap.put("/", TokenType.KEY);
		lMap.put("&", TokenType.KEY);
		lMap.put("|=", TokenType.KEY);
		lMap.put("^", TokenType.KEY);
		lMap.put("%", TokenType.KEY);
		lMap.put("+=", TokenType.KEY);
		lMap.put("-=", TokenType.KEY);
		lMap.put("*=", TokenType.KEY);
		lMap.put("/=", TokenType.KEY);
		lMap.put("&=", TokenType.KEY);
		lMap.put("^=", TokenType.KEY);
		lMap.put("%=", TokenType.KEY);
		
		//simbolos que compoe a linguagem
		//!|%|^|&|*|(|)|-|+|=|{|}|||~|[|]|\|;|'|:|"|<|>|?|,|.|/|#|@|`|_
		sList.add('<');
		sList.add('>');
		sList.add('+');
		sList.add('-');
		sList.add('*');
		sList.add('!');
		sList.add('%');
		sList.add('^');
		sList.add('&');
		sList.add('(');
		sList.add(')');
		sList.add('=');
		sList.add('{');
		sList.add('}');
		sList.add('|');
		sList.add('~');
		sList.add('[');
		sList.add(']');
		sList.add('\\');
		sList.add(';');
		sList.add('\'');
		sList.add(':');
		sList.add('"');
		sList.add('?');
		sList.add(',');
		sList.add('.');
		sList.add('/');
		sList.add(' ');
		
		
	}
	
}
