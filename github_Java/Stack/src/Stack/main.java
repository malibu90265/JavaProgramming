package Stack;
import java.util.Scanner;

class Stack{
	private int top;
	private int size;
	private int[] stack;
	
	public Stack(int size){		//stack 초기화
		this.size = size;
		stack = new int[this.size];
		for(int i=0; i<stack.length; i++)
			stack[i] = 0;
		top = -1;
	}
	
	public int getSize(){			//stack의 크기를 반환
		return this.size;
	}
	
	public int peek(int num){		//pop하려는 숫자를 반환
		return stack[num];
	}

	public boolean isEmpty(){	//stack이 비어있는지 확인
		if(top==-1)
			return true;
		else
			return false;
	}
	
	public boolean isFull(){			//stack이 가득 차있는지 확인
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
		
		System.out.println("만들고자 하는 Stack의 크기를 입력하세요>>");
		int size = s.nextInt();
		Stack stack = new Stack(size);
		System.out.println(">> 크기가 "+size+"인 Stack이 만들어졌습니다!");
		
		while(true){
			System.out.print("현재 Stack : ");
			for(int i=0; i<stack.getSize();i++)
				System.out.print(stack.peek(i)+" ");
			System.out.println();
			
			System.out.println("1. pop        2. push ");
			System.out.println("원하는 기능의 번호를 입력하세요>>");
			int selected = s.nextInt();
			
			if(selected==1){
				System.out.println("POP할 숫자를 입력해주세요.>>");
				num = s.nextInt();
				//stack이 가득차있는지 확인
				if(stack.isFull())
					System.out.println("*******Stack이 가득 차있습니다.");
				else{
					stack.push(num);
				}
				
				
			}else if(selected==2){
				if(stack.isEmpty())
					System.out.println("*********Stack이 비어있습니다.");
				else{
					int popNum = stack.pop();
					System.out.println(popNum+"이 POP되었습니다.");
				}
					
					
				
			}else{
				System.out.println(">>잘못 입력하셨습니다. ");
			}
			
			
			
		}
		
	}
}
