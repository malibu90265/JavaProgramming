package �Ǻ���ġ����;

import java.util.Scanner;

public class Fibo {
	public int fibo(int n, int fib){
		if(n==0)
			fib += 0;
		else if(n==1)
			fib += 1;
		else
			fib = fibo(n-1, fib)+ fibo(n-2,fib);
		
		return fib;
		
	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("�����Է�>>(0���� ����)");
		int num = s.nextInt();
		Fibo f = new Fibo();
		int result = f.fibo(num, 0);
		System.out.println(">>"+result);
		
	}
}
