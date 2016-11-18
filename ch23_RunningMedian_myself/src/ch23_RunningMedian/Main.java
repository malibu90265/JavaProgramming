package ch23_RunningMedian;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
	test input :
	3
	10 1 0
	10 1 1
	10000 1273 4936
	
	test output:
	19830
	19850
	2448920
	
	** 가장 마지막 input값은 오답이 출력됨.

 */

public class Main {
	private List<Integer> num;
	private int n, a, b, sum;
	
	Main(String[] line){
		this.n = Integer.parseInt(line[0]);
		this.a = Integer.parseInt(line[1]);	
		this.b = Integer.parseInt(line[2]);
		this.sum = 1983;
		
		num = new ArrayList<Integer>();
		num.add(1983);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\JEONGHYUN\\Desktop\\input.txt")); //경로 \가 2개임.
		String str = reader.readLine();
		int c = Integer.parseInt(str);
		
		for(int i=0; i<c; i++){
			String[] line = reader.readLine().split(" ") ;
			Main m = new Main(line);
			m.sortList();
			
		}
		
		reader.close();	// 파일 입출력 끝나고 반드시 close해줄것!
		
	}
	
	public void sortList(){
		int median=0;
		while(num.size()<n){
			//list에 새로운 숫자 추가
			int newNum = (int)((num.get(num.size()-1)*a)+b)%20090711;
			num.add(newNum);
			
			if(num.size()<=2){
				if(num.get(0) < num.get(1))
					median = num.get(0);
				else
					median = num.get(1);
			}else{
				//삽입정렬
				int key;
				int j;
				for(int i=1; i<num.size(); i++){
					key = num.get(i);
					for(j = i-1; j>=0 && num.get(j) > key ; j--){ //key 값보다 정렬된 배열에 있는 값이 클 때
						num.set(j+1, j);
					}
					num.set(j+1, key);
				}
				
				//중간값 찾기
				median = getMedian();
			}
			sum += median;
		}
		
		System.out.println(sum%20090711);
	}
	
	public int getMedian(){
		int median = 0;
		if(num.size()%2==0 && num.get((num.size()/2)-1) < num.get(num.size()/2))
			median = num.get((num.size()/2)-1);
		else
			median = num.get(num.size()/2);
		
		return median;
	}
	
	
}
