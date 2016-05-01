package 크로스컨트리;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProblemB {

	public static void deleteRunner(ArrayList<Integer> runner, int n){
		for(int i=0; i<runner.size(); i++){
			if(runner.get(i)==n)
				runner.remove(i);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner s = new Scanner(new FileInputStream("input.txt"));
		
		int test = s.nextInt();
		
		for(int t=0; t<test; t++){
			int n = s.nextInt();
			if(n<6 || n>1000)
				return;
			
			//팀 수 구하기
			int max = 0; //팀 수
			ArrayList<Integer> runner= new ArrayList<Integer>();
			for(int i=0; i<n; i++){
				runner.add(s.nextInt());
				if(max<runner.get(i))
					max = runner.get(i);
			}

			//팀 인원수 구하기
			int[] numRunner = new int[max];
			int[] runner5 = new int[max]; //5번째 선수
			for(int i=0; i<runner.size(); i++){
				numRunner[runner.get(i)-1]++;
				if(numRunner[runner.get(i)-1]==5)
					runner5[runner.get(i)-1] = i;
			}
			
			for(int i=0; i<max; i++){
				if(numRunner[i]<6){
					deleteRunner(runner, i);
				}
			}
			
			//점수 매기기
			int[] score = new int[runner.size()];
			int[] finalScore = new int[max];
			for(int i=0; i<score.length; i++){
				score[i] = i+1;
				finalScore[runner.get(i)-1] += score[i];
			}
			
			int min = finalScore[0];
			int tm_id = 0;
			int idx = runner5[0];
			for(int i=1; i<finalScore.length; i++){
				if(runner5[i]!=0 && min>finalScore[i]){
					min = finalScore[i];
					tm_id = i;
					idx = runner5[i];
				}
				
				else if(runner5[i]!=0 && min == finalScore[i] && idx > runner5[i]){
					min = finalScore[i];
					tm_id = i;
					idx = runner5[i];
				}
			}
			
			System.out.println(tm_id+1);
			
			
			
			
			
		}
		
		
		
	}
	
}
