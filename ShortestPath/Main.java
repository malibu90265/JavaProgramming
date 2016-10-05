package test2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		//map ũ�� �Է� (num * num)
		Scanner s = new Scanner(System.in);
		System.out.print("map�� ũ��>>");
		int n = s.nextInt();
		
		System.out.println();
		
		//map �� �Է�
		int[][] map = new int[n][n];
		System.out.println("map>>");
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++	)
				map[i][j] = s.nextInt();
		
		//cnt ������ �迭
		List<Integer> dis = new ArrayList<Integer>();
		
		//�Ÿ� ���ϱ�
		DFS(map, 0, 0, 1, dis);
		
		//�ִ� �Ÿ� ���ϱ�
		getMinDis(dis);
		
	}
	
	public static void DFS(int[][] map, int x, int y, int cnt, List dis){
		//System.out.println("x="+x+", y="+ y);
		
		//�������� ���
		if(x==4 && y==0){
			System.out.println("�Ÿ�>>" + cnt);
			dis.add(cnt);
			return;
		}
		
		//�湮�� �� = 1 , �湮���� �ʰų� �湮�� �� ���� �� = 0
		map[y][x] = 0;
		
		//���� �̵� �������� Ȯ��
		if(y>0 && map[y-1][x] == 1)
			DFS(map, x, y-1, cnt+1, dis);
		//�Ʒ��� �̵� �������� Ȯ��
		if(y<4 && map[y+1][x] == 1)
			DFS(map, x, y+1, cnt+1, dis);
		//���ʷ� �̵� �������� Ȯ��
		if(x>0 && map[y][x-1]==1)
			DFS(map, x-1, y, cnt+1, dis);
		//�����ʷ� �̵� �������� Ȯ��
		if(x<4 && map[y][x+1]==1)
			DFS(map, x+1, y, cnt+1, dis);
		
		//�ƹ� ���� �� �� ������, �������� �Ÿ��� �ٽ� �湮 ���Ѱɷ� ǥ��.
		map[y][x] = 1;
		
	}
	
	public static void getMinDis(List dis){
		int min = (int) dis.get(0);
		for(int i=0; i<dis.size(); i++){
			if(min > (int) dis.get(i))
				min = (int) dis.get(i);
		}
		System.out.println("�ִ� �Ÿ�:" + min);
	}
}
