import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DFS {
	private int[][] list;
	private boolean[] visited;
	DFS(){
		try {
			Scanner s = new Scanner(new FileInputStream("input.txt"));
			list = new int[5][5];
			visited = new boolean [5];
			
			for(int i=0; i<list.length; i++	){
				visited[i] = false;
				for(int j=0; j<list.length; j++)
					list[i][j] = s.nextInt();
			}
				
		} catch (FileNotFoundException e) {
			System.out.println("File not founded..");
			e.printStackTrace();
		}
	}
	
	public void track(int u){
		visited[u] = true;
		//자신과 연결된 정점 중 방문 안한 정점 찾기
		for(int i=0; i<list.length; i++){
			if(list[u][i]==1 && !visited[i]){
				System.out.print("->"+i);
				track(i);
			}
		}
	}
	
	public static void main(String[] args){
		
		DFS dfs = new DFS();
		Scanner n = new Scanner(System.in);
		System.out.println("Start Number(0~4) >>");
		int num = n.nextInt();
		System.out.print(num);
		dfs.track(num);
		
	}
}
