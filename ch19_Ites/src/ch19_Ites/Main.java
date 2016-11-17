package ch19_Ites;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * ★★★★★★★★★★★★★★★★★★★★★★★★★★★
 * java에서 지원하지 않는 unsigned int 값 때문에 난수 생성이 어려움.
 * 해당 코드는 불완전한 코드임.
 */
public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(countRanges(k,n));
	}
	
	//온라인 알고리즘
	public static int countRanges(int k, int n){
		RNG rng = new RNG();
		Queue<Integer> q = new LinkedList<Integer>();
		int ret=0;
		int rangeSum=0;
		
		for(int i=0; i<n; i++){
			int newSignal = rng.next();
			rangeSum += newSignal;
			q.add(newSignal);
			
			while(rangeSum > k){
				rangeSum -= q.peek();
				q.remove();
			}
			
			if(rangeSum==k)
				ret++;
		}
		return ret;
	}
	
	//오프라인 알고리즘의 최적화
	public int optimized(ArrayList<Integer> signals, int k){
		int ret = 0;
		int tail = 0;
		int rangeSum = signals.get(0);
		
		for(int head = 0; head<signals.size(); ++head){
			while(rangeSum < k && tail+1 < signals.size())
				rangeSum += signals.get(++tail);
			if(rangeSum == k)
				ret++;
			
			rangeSum -= signals.get(head);
		}
		
		return ret;
	}
	
	//메모리에 모든 숫자를 저장하는 '오프라인 알고리즘'
	public int simple(ArrayList<Integer> signals, int k){
		int ret=0;
		for(int head=0; head<signals.size(); ++head){
			int sum = 0;
			for(int tail=head; tail<signals.size(); ++tail){
				sum+=signals.get(tail);
				if(sum==k)
					ret++;
				if(sum>=k)
					break;
			}
		}
		return ret;
	}
	
}

class RNG{
	int seed;
	RNG(){
		seed = 1983;
	}
	
	public int next(){
		int ret = seed;
		seed = ((seed* 214013) + 2531011);
		return ret%10000 +1;
	}
	
}

