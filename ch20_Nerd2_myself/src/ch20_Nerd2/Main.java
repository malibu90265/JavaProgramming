package ch20_Nerd2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Nerd2 My Solution
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\JEONGHYUN\\Desktop\\input.txt")); //경로 \가 2개임.
		
		int testcase = Integer.parseInt(reader.readLine());
		
		for(int x=0; x<testcase; x++){
			int num = Integer.parseInt(reader.readLine());
			List<participants> tmp = new ArrayList<participants>();
			
			String[] s = reader.readLine().split(" ") ;
			int p = Integer.parseInt(s[0]);
			int q = Integer.parseInt(s[1]);
			participants part = new participants(p, q);
			tmp.add(part);
			
			int sum = 0;
			sum += tmp.size();
			
			for(int i=1; i<num; i++){
		        s = reader.readLine().split(" ") ;
				p = Integer.parseInt(s[0]);
				q = Integer.parseInt(s[1]);
				
				for(int j=0; j<tmp.size(); j++){
					if(p > tmp.get(j).getP() && q > tmp.get(j).getQ()){
						tmp.remove(j);
						break;
					}
				}
				
				part = new participants(p, q);
				tmp.add(part);
				sum += tmp.size();
				
			}
			
			System.out.println(sum);
		}
		
		reader.close();	// 파일 입출력 끝나고 반드시 close해줄것!
	}
	
	
}

class participants{
	private int p;
	private int q;
	
	participants(int p, int q){
		this.p = p;
		this.q = q;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q = q;
	}
	
}
