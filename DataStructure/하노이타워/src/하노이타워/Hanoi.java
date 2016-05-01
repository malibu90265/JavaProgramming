package �ϳ���Ÿ��;

public class Hanoi {

	public static void hanoi_tower(int n, char from, char tmp, char to){
		if(n==1)
			System.out.println("���� 1�� " + from +"���� "+to+"�� �̵�");
		else{
			//from�� �� ������ ������ ������ ���� tmp�� �̵�
			hanoi_tower(n-1, from, to, tmp);
			System.out.println("���� "+ n+"�� "+ from +"���� "+to+"�� �̵�");
			//tmp
			hanoi_tower(n-1, tmp, from, to);
		}
		
		
	}
	public static void main(String[] args){
		hanoi_tower(3, 'A', 'B', 'C');
	}
}
