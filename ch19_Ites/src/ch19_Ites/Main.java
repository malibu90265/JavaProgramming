package ch19_Ites;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
 * java���� �������� �ʴ� unsigned int �� ������ ���� ������ �����.
 * �ش� �ڵ�� �ҿ����� �ڵ���.
 */
public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(countRanges(k,n));
	}
	
	//�¶��� �˰���
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
	
	//�������� �˰����� ����ȭ
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
	
	//�޸𸮿� ��� ���ڸ� �����ϴ� '�������� �˰���'
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

