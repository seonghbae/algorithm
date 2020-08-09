package valueofbracket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static Stack<Object> bracket = new Stack<>();
	static int val = 1;
	
	public static void Bracket(String brk, int weight) {
		if(bracket.peek() instanceof Integer) {
			val = (int)bracket.peek();
			bracket.pop();
			if(!bracket.empty() && bracket.peek().toString().compareTo(brk) == 0) {
				val *= weight;
				bracket.pop();
				if(!bracket.empty() && bracket.peek() instanceof Integer) {
					val += (int)bracket.peek();
					bracket.pop();
				}
			}
			else {
				System.out.print(0);
				System.exit(0);
			}
			bracket.push(val);
			val = 1;
		}
		else if(bracket.peek().toString().compareTo(brk) == 0) {
			val *= weight;
			bracket.pop();
			if(!bracket.empty() && bracket.peek() instanceof Integer) {
				val += (int)bracket.peek();
				bracket.pop();
			}
			bracket.push(val);
			val = 1;
		}
		else {
			System.out.print(0);
			System.exit(0);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		if(str.length() % 2 == 1) {
			System.out.print(0);
			System.exit(0);
		}
		else if((str.substring(0, 1).compareTo(")") == 0) || (str.substring(0, 1).compareTo("]") == 0) || (str.substring(str.length() - 1, str.length()).compareTo("(") == 0) || (str.substring(str.length() - 1, str.length()).compareTo("[") == 0)) {
			System.out.print(0);
			System.exit(0);
		}
		
		for(int i = 0; i < str.length(); i++) {
			if(str.substring(i, i + 1).compareTo(")") == 0) {
				Bracket("(", 2);
			}
			else if(str.substring(i, i + 1).compareTo("]") == 0) {
				Bracket("[", 3);
			}
			else {
				bracket.push(str.substring(i,  i + 1));
			}
			//System.out.println(bracket);
		}
		System.out.print(bracket.peek());
		
		br.close();
	}
}