import java.util.ArrayList;
import java.util.Scanner;

/*
 * 26.2 문제: 안녕히, 그리고 물고기는 고마웠어요!(SOLONG)
 * Trie 알고리즘을 사용해서 풀기
 */
public class Trie2 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		TrieNode tn = new TrieNode(26);
		tn.insert("ALL", 4);
		tn.insert("AND", 3);
		tn.insert("FISH", 8);
		tn.insert("FOR", 6);
		tn.insert("SO", 4);
		tn.insert("THANKS", 9);
		tn.insert("THE", 9);
		
		int sum = 0;
		ArrayList<String> sen = new ArrayList<String>();
		
		String ss = "SO LONG AND THANKS FOR ALL THE FISH";
		int j=0;
		for(int i=0; i<ss.length(); i++){
			if(ss.charAt(i) == ' '){
				sum += 1;
				sen.add(ss.substring(j, i));
				j = i+1;
			}
		}
		
		for(int i=0; i<sen.size(); i++){
			String word = sen.get(i);
			sum += countKeys(tn, word);
		}
		
		System.out.println("***" + sum);
		
	}
	
	public static int countKeys(TrieNode t, String word){
		TrieNode node = t.find(word);
		if(node == null || node.terminal == -1)
			return word.length();
		return t.type(word, node.terminal);
	}
}

class TrieNode{
	TrieNode[] children;//자식 노드(0~25. A~Z)
	int terminal; //이 노드에서 종료하는 문자열의 번호. 없으면 -1
	int first; //이 노드를 루트로 하는 Tire에 가장 먼저 추가된 단어의 번호. -1로 초기화.
	TrieNode(int num){
		children = new TrieNode[num];
		terminal = -1;
		first = -1;
	}
	
	public void insert(String s, int id){
		//first를 우선 갱신
		if(first == -1)
			first = id;
		if(s.length()==0){
			terminal = id;
		}else{
			int next = toNumber(s.charAt(0));
			//해당 자식의 노드가 없으면 새로 생성한다.
			if(children[next]==null)
				children[next] = new TrieNode(26);
			s = s.substring(1);
			//해당 자식 노드로 재귀 호출
			children[next].insert(s, id);
		}
		//System.out.println(s + " 삽입 완료");
	}
	
	public TrieNode find(String s){
		if(s.length() == 0){
			return this;
		}
		int num = toNumber(s.charAt(0));
		if(children[num]==null)
			return null;
		//System.out.println(s.charAt(0));
		s = s.substring(1);
		return children[num].find(s);
	}
	
	public int toNumber(char c){
		return c - 'A';
	}
	
	//이 노드까지 타이핑해 왔을 때, 번호 id인 key를 타이핑하기 위해
	//최소 몇 번의 키를 더 눌러야 하는지
	public int type(String s, int id){
		//문자열 종료시
		if(s.length()==0)
			return 0;
		//이 노드에서 추천되는 문자열이 이 문자열이면 탭 누르고 종료.
		if(first == id)
			return 1;
		//아니면 다음 문자를 타이핑한다.
		int next = toNumber(s.charAt(0));
		return 1 + children[next].type(s.substring(1), id);
	}
}
