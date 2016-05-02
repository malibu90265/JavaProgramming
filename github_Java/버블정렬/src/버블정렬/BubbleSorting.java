package 버블정렬;

import java.util.Scanner;

public class BubbleSorting {
	private int[] num;
	private int temp;
	
	BubbleSorting(){
		Scanner s = new Scanner(System.in);
		System.out.print("숫자 5개 입력>>");
		num = new int[5];
		for(int i=0; i<this.num.length; i++)
			this.num[i] = s.nextInt();		
	}
	
	int getLength(){
		return this.num.length;
	}
	
	void sorting(){
		for(int j=getLength()-1; j>=0; j--){
			for(int i=0; i<=j-1; i++){
				int temp = num[i];
				if(num[i]>num[i+1]){
					num[i] = num[i+1];
					num[i+1] = temp;
				}
			}
		}
	}
	
	void printArray(){
		for(int i=0; i<num.length; i++){
			System.out.print(num[i]+ " ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		while(true){
			BubbleSorting bs = new BubbleSorting();
			bs.sorting();
			bs.printArray();
		}
		
	}
}
