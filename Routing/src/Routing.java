import java.util.ArrayList;
import java.util.Scanner;

public class Routing {
	private double[] dist;//각 정점의 최단 경로
	private ArrayList<Integer> visited;//방문한 정점 저장
	private int start, end; //시작 및 출발 점
	
	Routing(int start, int end){
		dist = new double[7];
		for(double d : dist)
			d = 0.0;
		visited = new ArrayList<Integer>();
		this.start = start;
		this.end = end;
		dist[start] = 1;
		visited.add(start);
	}
	
	public static void main(String[] args){
		//전체 경로
		double[][] map = { {0, 1.3, 1.1, 1.24, -1, -1, -1},
							{1.3, 0, 1.26, 2, 1.11, 1.37, -1},
							{1.1, 1.26, 0, -1, -1, -1, 1.2},
							{1.24, 2, -1, 0, 1.17, 1.24, -1},
							{-1, 1.11, -1, 1.17, 0, 1.24, 1.77},
							{-1, 1.37, 01, 1.24, 1.24, 0, 1.11},
							{-1, -1, 1.2, -1, 1.77, 1.11, 0}};
		
		Scanner s = new Scanner(System.in);
		System.out.println("점: 총 7개. 0~6까지 선택");
		System.out.print("출발, 도착 점 입력(예: 1 6)>>");
		int start = s.nextInt();
		int end = s.nextInt();
		
		Routing r = new Routing(start, end);
		r.findRoute(map);
		
		
	}
	
	public void findRoute(double[][] map){
		//도착 점에 다다랐을 경우
		if (start == end) {
			for (int v : visited)
				System.out.print(v + " -> ");
			System.out.println("최단거리>>" + dist[start]);
			return;
		}
		
		int minIdx = -1;
		double minDist = 3.0;
		for (int j = 0; j < 7; j++) {
			//인접한 점들 중에서 지나가지 않은 점인 경우
			if ( !isVisited(j) && map[start][j] >= 1.0) {
				if (dist[j]==0)
					dist[j] = dist[start] * map[start][j];
				//현재 방문한 점이 시작점이 아니고, 이미 dist[j]가 기존에 update된 적이 있는 경우
				else if(dist[j] > (dist[start] * map[start][j])){
					dist[j] = dist[start] * map[start][j];
					
				}
				if (minDist > dist[start] * map[start][j]){
					minDist = dist[start] * map[start][j];
					minIdx = j;
				}
			}
		}
		start = minIdx;
		visited.add(start);
		findRoute(map);
		
	}
	//이미 지나온 점인지 확인
	public boolean isVisited(int r){
		for(int v : visited)
			if(v == r)
				return true;
		return false;
	}
	
}
