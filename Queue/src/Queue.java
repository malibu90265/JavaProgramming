import java.util.Scanner;

public class Queue {
    
    private class Node{
        // ���� data�� ���� ��带 ������.
        private Object  data;
        private Node nextNode;
    
        Node(Object data){
            this.data = data;
            this.nextNode = null;
        }
    }
    
    // ť�� front���� rear��带 ������.
    private Node front;
    private Node rear;
    
    public Queue(){
        this.front = null;
        this.rear = null;
    }
    
    // ť�� ����ִ��� Ȯ��
    public boolean empty(){
        return (front==null);
    }
    
    // item�� ť�� rear�� �ִ´�.
    public void insert(Object item){
        
        Node node = new Node(item);
        node.nextNode = null;
        
        if(empty()){
            rear = node;
            front = node;
        }else{
            rear.nextNode = node;
            rear = node;
        }
    }
    
    // front �� �����͸� ��ȯ�Ѵ�.
    public void peek(){
        if(!empty())
        	System.out.println(front.data); 
    }
    
    // front �� ť���� �����Ѵ�.
    public Object remove(){
        Object item = front.data;
        front = front.nextNode;
        if(front == null){
            rear = null;
        }
        return item;
    }
    
	public void printQueue(){
		System.out.println("---- Queue ----");
		Node temp = front;
		while(true){
			System.out.println(temp.data);
			if(temp.nextNode==null)
				break;
			else
				temp = temp.nextNode;
		}
		
	}
    
    
    public static void main(String[] args){
    	Scanner s = new Scanner(System.in);
    	Queue q = new Queue();
    	
    	int num;
    	
    	while(true){
			System.out.println("1. insert   2. remove  3. peek");
			num = s.nextInt();
			switch(num){
			case 1:
				System.out.println("number: ");
				num = s.nextInt();
				q.insert(num);
				q.printQueue();
				break;
			case 2:
				q.remove();
				q.printQueue();
				break;
			case 3:
				q.peek();
				break;
			}
		}
    }
}