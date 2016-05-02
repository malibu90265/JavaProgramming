package 선택정렬;

import java.util.Scanner;

public class SelectSorting {
	private int[] num;
	private int temp, min, minIdx;
	
	public SelectSorting(){
		Scanner s = new Scanner(System.in);
		System.out.print("숫자 7개 입력>>");
		num = new int[7];
		for(int i=0; i<num.length; i++)
			num[i] = s.nextInt();
	}
	public void setMin(){
		for(int i=0; i<num.length-1; i++){
			this.temp=num[i];
			//최소값 구하기
			this.min = temp;
			this.minIdx = i;
			for(int j=i+1; j<num.length; j++){
				if(min>=num[j]){
					this.min=num[j];
					this.minIdx = j;
				}
			}
			if(this.min!=temp){
				num[i] = this.min;
				num[this.minIdx] = this.temp;
			}
		}
	}
	
	public void result(){
		System.out.print("정렬 결과>> ");
		for(int i=0; i<num.length; i++)
			System.out.print(num[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args){
		while(true){
			SelectSorting ss = new SelectSorting();
			ss.setMin();
			ss.result();
		}
	}
	
}
