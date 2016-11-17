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
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\JEONGHYUN\\Desktop\\input.txt")); //��� \�� 2����.
		ArrayList<String> s = new ArrayList<String>();
		String str = null;
		while((str = reader.readLine()) != null){
			s.add(str);
		}
		reader.close();	// ���� ����� ������ �ݵ�� close���ٰ�!
		
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
			if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')		//input�� ���� ��ȣ�� ���, ���ÿ� push
				stack.push(s.charAt(i));					
			else{																//input�� �ݴ� ��ȣ�� ���, ���� �� ���� ��ȣ�� ���� ���纻��. ���� �ʴ� ��� ���� ��ȯ		
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
