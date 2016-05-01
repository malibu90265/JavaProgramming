import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	private int size;
	private ArrayList<Integer> s;
	private int[][] w;//가중치
	private int[] d;//최소거리
	//private boolean[] visited;
	
	Solution() throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		size = sc.nextInt();
		w  = new int[size][size];
		for(int i=0; i<w.length; i++)
			for(int j=0; j<w.length; j++)
				w[i][j] = sc.nextInt();
		//weight = 0 --> 자기 자신
		//weight = -1 --> 연결되어있지않음
		s = new ArrayList<Integer>();
		d = new int[size];
		//visited = new boolean[size];
	}
	
	public int getMin(int idx){
		//System.out.println("***idx"+ idx);
		int min= 2147483647;
		int minIdx = idx;
		for(int i=0; i<this.size; i++){
			if( !isInS(i) && d[i]>0 && d[i] < min){
				min = d[i];
				minIdx = i;
			}
		}
		System.out.print("최소 정점:"+minIdx+" ///");
		return minIdx;
	}
	
	public boolean isInS(int num){
		for(int i=0; i<s.size(); i++){
			if(s.get(i)==num)
				return true;
		}
		return false;
	}
	
	public void setDistance(int num){
		s.add(num);
		//visited[num]=true;
		for(int i=0; i<size; i++){
			d[i] = w[num][i];
		}
	}
	
	public void find(int num){
		//visited[num] = true;
		int u = getMin(num);
		s.add(u);
		//System.out.println("uuu: " +u);
		printS();
		for(int i=0; i<size; i++){
			if(/*!visited[i] &&*/ w[u][i]>0 && !isInS(i)){
				if(d[i]==-1 || d[u]+w[u][i]<d[i]){
					/*System.out.println("*****************");
					System.out.println("i="+i);
					System.out.println("u="+u);
					System.out.println("d[i]="+d[i]);
					System.out.println("d[u]="+d[u]);
					System.out.println("w[u][i]="+w[u][i]);
					System.out.println("*****************");*/
					d[i] = d[u]+w[u][i];
				}
			}
			
		}
		
	}
	public void printS(){
		System.out.print("S : ");
		for(int i=0; i<s.size(); i++)
			System.out.print(s.get(i)+" ");
		System.out.println();
	}
	public void getDistance(){
		for(int i=0; i<d.length; i++)
			System.out.print(d[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Solution s = new Solution();
		int cnt=0;
		s.setDistance(cnt);
		while(cnt<s.size-1){
			s.find(cnt);
			s.getDistance();
			cnt++;
			System.out.println("------------------------------------");
		}
		
		
	}
	
	
	
}
