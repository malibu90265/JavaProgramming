package ch19Brackets2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\JEONGHYUN\\Desktop\\input.txt")); //경로 \가 2개임.
		ArrayList<String> s = new ArrayList<String>();
		String str = null;
		while((str = reader.readLine()) != null){
			s.add(str);
		}
		reader.close();	// 파일 입출력 끝나고 반드시 close해줄것!
		
		int testcase = Integer.parseInt(s.get(0));
		for(int i=1; i<=testcase; i++){
			if(wellMatched(s.get(i)))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
	}
	
	public static boolean wellMatched(String s){
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')		//input이 여는 괄호인 경우, 스택에 push
				stack.push(s.charAt(i));					
			else{																//input이 닫는 괄호인 경우, 스택 맨 위의 괄호와 서로 맞춰본다. 맞지 않는 경우 오류 반환		
				if(stack.isEmpty())
					return false;
				if(s.charAt(i) == ')' && !stack.peek().equals('('))
					return false;
				if(s.charAt(i) == '}' && !stack.peek().equals('{'))
					return false;
				if(s.charAt(i) == ']' && !stack.peek().equals('['))
					return false;
				stack.pop();
			}
		}
		
		return stack.isEmpty();
		
	}
}
