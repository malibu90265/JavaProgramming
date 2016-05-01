package Stack;
import java.util.Scanner;

class Stack{
	private int top;
	private int size;
	private int[] stack;
	
	public Stack(int size){		//stack �ʱ�ȭ
		this.size = size;
		stack = new int[this.size];
		for(int i=0; i<stack.length; i++)
			stack[i] = 0;
		top = -1;
	}
	
	public int getSize(){			//stack�� ũ�⸦ ��ȯ
		return this.size;
	}
	
	public int peek(int num){		//pop�Ϸ��� ���ڸ� ��ȯ
		return stack[num];
	}

	public boolean isEmpty(){	//stack�� ����ִ��� Ȯ��
		if(top==-1)
			return true;
		else
			return false;
	}
	
	public boolean isFull(){			//stack�� ���� ���ִ��� Ȯ��
		if(top==size-1)
			return true;
		else
			return false;
	}
	
	public void push(int num){
		stack[++top] = num;
		
	}
	
	public int pop(){
		int popNum = stack[top];
		stack[top]=0;
		top--;
		return popNum;
	}
	
	
}


public class main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int num=0;
		
		System.out.println("������� �ϴ� Stack�� ũ�⸦ �Է��ϼ���>>");
		int size = s.nextInt();
		Stack stack = new Stack(size);
		System.out.println(">> ũ�Ⱑ "+size+"�� Stack�� ����������ϴ�!");
		
		while(true){
			System.out.print("���� Stack : ");
			for(int i=0; i<stack.getSize();i++)
				System.out.print(stack.peek(i)+" ");
			System.out.println();
			
			System.out.println("1. pop        2. push ");
			System.out.println("���ϴ� ����� ��ȣ�� �Է��ϼ���>>");
			int selected = s.nextInt();
			
			if(selected==1){
				System.out.println("POP�� ���ڸ� �Է����ּ���.>>");
				num = s.nextInt();
				//stack�� �������ִ��� Ȯ��
				if(stack.isFull())
					System.out.println("*******Stack�� ���� ���ֽ��ϴ�.");
				else{
					stack.push(num);
				}
				
				
			}else if(selected==2){
				if(stack.isEmpty())
					System.out.println("*********Stack�� ����ֽ��ϴ�.");
				else{
					int popNum = stack.pop();
					System.out.println(popNum+"�� POP�Ǿ����ϴ�.");
				}
					
					
				
			}else{
				System.out.println(">>�߸� �Է��ϼ̽��ϴ�. ");
			}
			
			
			
		}
		
	}
}
