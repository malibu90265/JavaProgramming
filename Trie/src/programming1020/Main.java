package programming1020;
/*
 * ���ڿ� ������ ǥ���ϴ� Ʈ�� �ڷᱸ�� - TRIE �˰���
 */
public class Main {
	public static void main(String[] args){
		
		
	}
}


class TrieNode{
	TrieNode[] children;//�ڽ� ���(0~25. A~Z)
	boolean terminal; //���� ������� ����
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