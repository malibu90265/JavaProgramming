package 이중우선순위큐;

import java.util.ArrayList;
import java.util.Scanner;

public class problemD {

	public static int getMax(ArrayList<Integer> list) {
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i)){
				max = list.get(i);
			}
		}

		return max;
	}
	
	public static int getMaxIdx(ArrayList<Integer> list) {
		int max = 0;
		int cnt =0;
		for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i)){
				max = list.get(i);
				cnt = i;
			}
		}

		return cnt;
	}
	
	public static int getMin(ArrayList<Integer> list) {
		int min = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (min > list.get(i)){
				min = list.get(i);
			}
		}
		return min;
	}
	
	public static int getMinIdx(ArrayList<Integer> list) {
		int min = list.get(0);
		int cnt =0;
		for (int i = 1; i < list.size(); i++) {
			if (min > list.get(i)){
				min = list.get(i);
				cnt = i;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list;
		char[] d;
		int[] n;
		int t;// 입력 데이터의 수
		
		Scanner s = new Scanner(System.in);
		System.out.println("Test case>>");
		t = s.nextInt();
		
		for (int i = 0; i < t; i++) {
			System.out.println("입력할 데이터 갯수>>");
			int k = s.nextInt();
			if (k > 1000000)
				return;

			d = new char[k];
			n = new int[k];
			list = new ArrayList<Integer>();

			for (int j = 0; j < k; j++) {
				String ss = s.next();
				d[j] = ss.charAt(0);
				n[j] = s.nextInt();

				if (d[j] == 'I') {
					list.add(n[j]);
				}
				if (d[j] == 'D') {
					if(list.size()==0)
						continue;
					if(n[j]==-1){
						list.remove(getMinIdx(list));
					}else{
						list.remove(getMaxIdx(list));
					}
				}

			}
			
			if(list.size()!=0){
				System.out.print(getMax(list)+" ");
				System.out.println(getMin(list));
			}else{
				System.out.println("EMPTY");
			}

		}
		
	}

}
