
package Ä«À×´Þ·Â;

import java.util.Scanner;

public class main {
	public static void main(String[] args){
		while(true){
			Scanner s = new Scanner(System.in);
			
			int m = s.nextInt();
			int n = s.nextInt();
			int x = s.nextInt(); 
			int y = s.nextInt();
			
			if(m<1 || m>40000 || n<1 || n>40000)
				return;
			if(x<1 || x>m || y<1 || y>n)
				return;
			
			int a=0, b=0;
			int cnt=1;
			while(true){
				if(a+1>m)
					a=1;
				else if(a<=m)
					a++;
				
				if(b+1>n)
					b=1;
				else if(b<=n)
					b++;
				
				if(a==x && b==y){
					System.out.println(cnt++);
					break;
				}
				
				if(a==m && b== n){
					System.out.println("-1");
					break;
				}
				cnt++;
			}
		}
		
		
		
	}
}
