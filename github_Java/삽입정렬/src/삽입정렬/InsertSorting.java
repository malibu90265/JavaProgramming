package 삽입정렬;

import java.util.Scanner;

public class InsertSorting {
	private int[] num;
	private int key;
	
	InsertSorting(){
		Scanner s = new Scanner(System.in);
		System.out.print("숫자 5개 입력>>");
		this.num = new int[5];
		for(int i=0; i<this.num.length; i++)
			this.num[i] = s.nextInt();
	}
	
	public void sorting(){
		int j;
		for(int i=1; i<num.length; i++){
			key = num[i];
			this.key = num[i];
			for(j = i-1; j>=0 && num[j] > key ; j--){ //key 값보다 정렬된 배열에 있는 값이 클 때
				num[j+1] = num[j];
			}
			num[j+1] = key;
		}
	}
	
	public void printArray(){
		for(int i=0; i<num.length;i++)
			System.out.print(num[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args){
		while(true){
			InsertSorting is = new InsertSorting();
			is.sorting();
			is.printArray();
		}
	}
}
