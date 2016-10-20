package programming1020;
/*
 * 문자열 집합을 표현하는 트리 자료구조 - TRIE 알고리즘
 */
public class Main {
	public static void main(String[] args){
		
		
	}
}


class TrieNode{
	TrieNode[] children;//자식 노드(0~25. A~Z)
	boolean terminal; //종료 노드인지 구분
	TrieNode(int num){
		children = new TrieNode[num];
		terminal = false;
	}
	public void insert(String s){
		if(s.length()==0){
			terminal = true;
			return;
		}else{
			int next = toNumber(s.charAt(0));
			if(children[next]==null)
				children[next] = new TrieNode(26);
			s = s.substring(1);
			children[next].insert(s);
		}
	}
	
	public void find(String s){
		if(s.length() == 0){
			return;
		}
		int num = toNumber(s.charAt(0));
		if(children[num]==null)
			return;
		System.out.println(s.charAt(0));
		s = s.substring(1);
		children[num].find(s);
	}
	
	public int toNumber(char c){
		return c - 'A';
	}
}