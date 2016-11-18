package ch23_RunningMedian;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int i=0; i<testcase; i++){
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			RNG rng = new RNG(a,b);
			System.out.println(runningMedian_heap(n,rng));
		}
	}
	
	
/*	//트립을 사용해 푸는 방법.
	//rng가 생성하는 첫 n개의 난수를 수열에 추가하여 중간 값을 구한다.
	public int runningMedian(int n, RNG rng){
		Node root = null;
		int ret = 0;
		
		for(int cnt=1; cnt<=n; cnt++){
			root = insert(root, new Node(rng.next()));
			int median = kth(root, (cnt+1)/2).key;
			ret = (ret+median) % 20090711;
		}
		return ret;
	}*/
	
	//heap을 사용해서 해결.
	public static int runningMedian_heap(int n, RNG rng){
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		int ret = 0;
		
		for(int cnt=1; cnt<=n; ++cnt){
			if(maxHeap.size() == minHeap.size())
				maxHeap.add(rng.next());
			else
				minHeap.add(rng.next());
			
			if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()){
				int a = maxHeap.peek();
				int b = minHeap.peek();
				
				maxHeap.poll();
				minHeap.poll();
				maxHeap.add(b);
				minHeap.add(a);
			}
			ret = (ret+maxHeap.peek())% 20090711;
		}
		return ret;
	}
}

class RNG{
	int seed, a, b;
	RNG(int a, int b){
		this.a = a;
		this.b = b;
		this.seed = 1983;
	}
	int next(){
		int ret = seed;
		seed = ((seed*a)+b)%20090711;
		return ret;
	}
}
