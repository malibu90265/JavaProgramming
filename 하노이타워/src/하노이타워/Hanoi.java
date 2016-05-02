package 하노이타워;

public class Hanoi {

	public static void hanoi_tower(int n, char from, char tmp, char to){
		if(n==1)
			System.out.println("원판 1을 " + from +"에서 "+to+"로 이동");
		else{
			//from의 맨 밑판을 제외한 나머지 판을 tmp로 이동
			hanoi_tower(n-1, from, to, tmp);
			System.out.println("원판 "+ n+"을 "+ from +"에서 "+to+"로 이동");
			//tmp
			hanoi_tower(n-1, tmp, from, to);
		}
		
		
	}
	public static void main(String[] args){
		hanoi_tower(3, 'A', 'B', 'C');
	}
}
