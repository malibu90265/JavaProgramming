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
		for (int i = 0; i < n; i++) { // 조세푸스를 포함한 병사의 수이므로 총 병사 수는 n+1이다.
			s.insert(i);
		}
		
		int kill=0;
		while (n > 3) {
			//큐의 첫 번째 사람이 나와서 죽고
			//큐의 맨 앞에 있는 사람을 맨 뒤로 보내는 작업을 k-1번 반복한다.
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
        // 노드는 data와 다음 노드를 가진다.
        private int  data;
        private Node nextNode;
    
        Node(int data){
            this.data = data;
            this.nextNode = null;
        }
    }
    
    // 큐는 front노드와 rear노드를 가진다.
    private Node front;
    private Node rear;
    
    public Soldier(){
        this.front = null;
        this.rear = null;
    }
    
    // 큐가 비어있는지 확인
    public boolean empty(){
        return (front==null);
    }
    
    // item을 큐의 rear에 넣는다.
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
    
    // front 의 데이터를 반환한다.
    public void peek(){
        if(!empty())
        	System.out.println(front.data); 
    }
    
    // front 를 큐에서 제거한다.
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