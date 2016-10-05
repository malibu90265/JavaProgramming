package test2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		//map 크기 입력 (num * num)
		Scanner s = new Scanner(System.in);
		System.out.print("map의 크기>>");
		int n = s.nextInt();
		
		System.out.println();
		
		//map 값 입력
		int[][] map = new int[n][n];
		System.out.println("map>>");
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++	)
				map[i][j] = s.nextInt();
		
		//cnt 저장할 배열
		List<Integer> dis = new ArrayList<Integer>();
		
		//거리 구하기
		DFS(map, 0, 0, 1, dis);
		
		//최단 거리 구하기
		getMinDis(dis);
		
	}
	
	public static void DFS(int[][] map, int x, int y, int cnt, List dis){
		//System.out.println("x="+x+", y="+ y);
		
		//도착했을 경우
		if(x==4 && y==0){
			System.out.println("거리>>" + cnt);
			dis.add(cnt);
			return;
		}
		
		//방문한 점 = 1 , 방문하지 않거나 방문할 수 없는 점 = 0
		map[y][x] = 0;
		
		//위로 이동 가능한지 확인
		if(y>0 && map[y-1][x] == 1)
			DFS(map, x, y-1, cnt+1, dis);
		//아래로 이동 가능한지 확인
		if(y<4 && map[y+1][x] == 1)
			DFS(map, x, y+1, cnt+1, dis);
		//왼쪽로 이동 가능한지 확인
		if(x>0 && map[y][x-1]==1)
			DFS(map, x-1, y, cnt+1, dis);
		//오른쪽로 이동 가능한지 확인
		if(x<4 && map[y][x+1]==1)
			DFS(map, x+1, y, cnt+1, dis);
		
		//아무 데도 갈 수 없으면, 지나갔던 거리를 다시 방문 안한걸로 표시.
		map[y][x] = 1;
		
	}
	
	public static void getMinDis(List dis){
		int min = (int) dis.get(0);
		for(int i=0; i<dis.size(); i++){
			if(min > (int) dis.get(i))
				min = (int) dis.get(i);
		}
		System.out.println("최단 거리:" + min);
	}
}
