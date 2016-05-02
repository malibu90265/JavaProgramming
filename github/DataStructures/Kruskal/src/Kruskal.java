
class Union{
	private int[] parent;
	private int[] num;
	
	void set_init(int n){
		parent = new int[n];
		num = new int[n];
		for(int i=0; i<n; i++){
			parent[i] = -1;
			num[i] = 1;
		}
	}
	
	int set_find(int vertex){
		int p, s = 0, i=-1;
		for(i=vertex; (p=parent[i])>=0; i=p)
			;
		for(i=vertex; (p=parent[i])>=0; i=p)
			parent[i]=s;
		return s;
	}
	
	void set_union(int s1, int s2){
		if(num[s1]<num[s2]){
			parent[s1] = s2;
			num[s2] += num[s1];
		}else{
			parent[s2] = s1;
			num[s1] += num[s2];
		}
	}
	
}


public class Kruskal {
	private int key, u, v;
	
	
	
	public static void main(String[] args){
		
	
		
	}
}
