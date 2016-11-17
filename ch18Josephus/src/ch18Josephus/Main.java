package ch18Josephus;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int c = sc.nextInt(); //test case
		int n = sc.nextInt(); // the number of soldiers
		int k = sc.nextInt(); // count number

		Soldier s = new Soldier();
		for (int i = 0; i < n; i++) { // ����Ǫ���� ������ ������ ���̹Ƿ� �� ���� ���� n+1�̴�.
			s.insert(i);
		}
		
		int kill=0;
		while (n > 3) {
			//ť�� ù ��° ����� ���ͼ� �װ�
			//ť�� �� �տ� �ִ� ����� �� �ڷ� ������ �۾��� k-1�� �ݺ��Ѵ�.
			kill = s.remove();
			System.out.println("kill: "+ (kill+1));
			for(int i=0; i<k-1; i++){
				int num = s.remove();
				s.insert(num);
			}
			n--;
		}
		
		
		s.printQueue();

	}
}

class Soldier {
    
    private class Node{
        // ���� data�� ���� ��带 ������.
        private int  data;
        private Node nextNode;
    
        Node(int data){
            this.data = data;
            this.nextNode = null;
        }
    }
    
    // ť�� front���� rear��带 ������.
    private Node front;
    private Node rear;
    
    public Soldier(){
        this.front = null;
        this.rear = null;
    }
    
    // ť�� ����ִ��� Ȯ��
    public boolean empty(){
        return (front==null);
    }
    
    // item�� ť�� rear�� �ִ´�.
    public void insert(int item){
        
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
    public int remove(){
    	int item = front.data;
        front = front.nextNode;
        if(front == null){
            rear = null;
        }
        return item;
    }
    
	public void printQueue(){
		System.out.println("---- Survivors ----");
		Node temp = front;
		while(true){
			System.out.println(temp.data+1);
			if(temp.nextNode==null)
				break;
			else
				temp = temp.nextNode;
		}
		
	}
    
}