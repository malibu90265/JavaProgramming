import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BFS {
	private int[][] list;
	private boolean[] visited;
	private ArrayList<Integer> q;
	BFS(int n){
		try {
			Scanner s = new Scanner(new FileInputStream("input.txt"));
			list = new int[5][5];
			visited = new boolean [5];
			q = new ArrayList<Integer>();
			q.add(n);
			
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
	
	public void find(int num){
		if(q.size()!=0){
			visited[num] = true;
			q.remove(0);
			System.out.println("remove " + num );
			for(int i=0; i<5; i++){
				if(num!=i && list[num][i]==1 && !visited[i]){
					q.add(i);
					visited[i] = true;
				}
			}
			if(q.size()!=0){
				find(q.get(0));
			}
		}
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("시작 정점>>");
		int n = s.nextInt();
		BFS bfs = new BFS(n);
		bfs.find(n);
	}
}
