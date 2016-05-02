import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Visited{
	private int x;
	private int y;
	
	Visited(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
}

public class Solution {
	private int[][] map;
	private ArrayList<Visited> visited;
	private int cnt;
	private Visited v;
	
	Solution(){
		map = new int[5][5];
		cnt = 0;
		visited = new ArrayList<Visited>();
	}
	
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Solution s = new Solution();
		
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				s.map[i][j] = sc.nextInt();
			}
		}
		
		//탐색 순서: 오른쪽/아래/왼쪽/위 -->시계방향
		s.find(0,0);
		
	}
	
	public void find(int x, int y){
		
		System.out.println("----방문 x:"+x+" y:"+y);
		v = new Visited(x,y);
		visited.add(v);
		cnt++;
		map[x][y] = 2;//방문한 곳은 2로!
		
		//오른쪽
		if(y+1<5 && map[x][y+1]<1){
			find(x, y+1);
		}
		//아래
		else if(x+1<5 && map[x+1][y] <1){
			find(x+1, y);
		}
		//왼쪽
		else if(y-1<=0 && map[x][y-1] <1){
			find(x, y-1);
		}
		//위
		else if(x-1<=0 && map[x-1][y] <1){
			find(x-1, y);
		}
		else{
			//나를 호출한 곳으로 되돌아감.
			//find(a,b);
			cnt -= 2;
			if(cnt<0)
				return;
			else if(x==4 && y==4){
				System.out.println("end");
				return;
			}
			else
				find(visited.get(cnt).getX(), visited.get(cnt).getY());
			
		}
			
	}
}
