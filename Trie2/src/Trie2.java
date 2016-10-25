import java.util.ArrayList;
import java.util.Scanner;

/*
 * 26.2 ����: �ȳ���, �׸��� ������ �������!(SOLONG)
 * Trie �˰����� ����ؼ� Ǯ��
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
	TrieNode[] children;//�ڽ� ���(0~25. A~Z)
	int terminal; //�� ��忡�� �����ϴ� ���ڿ��� ��ȣ. ������ -1
	int first; //�� ��带 ��Ʈ�� �ϴ� Tire�� ���� ���� �߰��� �ܾ��� ��ȣ. -1�� �ʱ�ȭ.
	TrieNode(int num){
		children = new TrieNode[num];
		terminal = -1;
		first = -1;
	}
	
	public void insert(String s, int id){
		//first�� �켱 ����
		if(first == -1)
			first = id;
		if(s.length()==0){
			terminal = id;
		}else{
			int next = toNumber(s.charAt(0));
			//�ش� �ڽ��� ��尡 ������ ���� �����Ѵ�.
			if(children[next]==null)
				children[next] = new TrieNode(26);
			s = s.substring(1);
			//�ش� �ڽ� ���� ��� ȣ��
			children[next].insert(s, id);
		}
		//System.out.println(s + " ���� �Ϸ�");
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
	
	//�� ������ Ÿ������ ���� ��, ��ȣ id�� key�� Ÿ�����ϱ� ����
	//�ּ� �� ���� Ű�� �� ������ �ϴ���
	public int type(String s, int id){
		//���ڿ� �����
		if(s.length()==0)
			return 0;
		//�� ��忡�� ��õ�Ǵ� ���ڿ��� �� ���ڿ��̸� �� ������ ����.
		if(first == id)
			return 1;
		//�ƴϸ� ���� ���ڸ� Ÿ�����Ѵ�.
		int next = toNumber(s.charAt(0));
		return 1 + children[next].type(s.substring(1), id);
	}
}
