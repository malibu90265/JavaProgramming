package ch18Josephus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//int c = sc.nextInt();		//test case
		int n = sc.nextInt();		//the number of soldiers
		int k = sc.nextInt();		//count number
		
		List<Integer> survivors = new ArrayList<Integer>();
		
		for(int i=0; i<=n; i++){	// ����Ǫ���� ������ ������ ���̹Ƿ� �� ���� ���� n+1�̴�.
			survivors.add(i);
		}
		
		int kill = 1;
		while(survivors.size() > 2){
			
			System.out.println("kill: "+ survivors.get(kill-1));
			survivors.remove(kill-1);
			
			if(kill==survivors.get(survivors.size()-1)){
				kill = survivors.get(0);
			}
			
			
			for(int i=0; i<k-1; i++){
				++kill;
				if(kill==survivors.get(survivors.size()-1))
					kill = survivors.get(0);
			}
		}
		
		for(int i=0; i<survivors.size(); i++)
			System.out.println("������ : " + (survivors.get(i)+1));
		
	}
}

/*class Survivors{
    private class Node{
        private int  data;	// ���� data�� ���� ��带 ������.
        private Node nextNode;
    
        Node(int data){
            this.data = data;
            this.nextNode = null;
        }
    }
    
    private Node front;			// ť�� front���� rear��带 ������.
    private Node rear;
    
    public Survivors(){
        this.front = null;
        this.rear = null;
    }
    
    public boolean empty(){		// ť�� ����ִ��� Ȯ��
        return (front==null);
    }
    
    public void insert(int item){	// item�� ť�� rear�� �ִ´�.
        Node node = new Node(item);
        node.nextNode = null;
        
        if(empty()){
            rear = node;
            front = node;
        }else{
            rear.nextNode = node;
            rear = node;
            rear.nextNode = front;	//���� ť�� ������ֱ� ���� rear�� ���� ��带 front�� �����Ѵ�.
        }
        
    }
    
    public void remove(int k){		// front�� ť���� �����Ѵ�.
        
    	if(front.nextNode==null){
    		rear = null;
    	}else{
    		int i=1;
    		Node tmp;
    		while(i<k-1){
    			tmp = tmp.nextNode;
    			i++;
    		}
    		//tmp�� �����Ϸ��� ����� ���� ��尡 �ȴ�.
    		if(tmp.nextNode == rear)
    		
    		int item = tmp.nextNode.data;
    		tmp.nextNode = tmp.nextNode.nextNode;
    		
    		
    	}
    	
    	
    	
    	
    	int item = front.data;
        front = front.nextNode;
        if(front == null)
            rear = null;
        else{
        	rear.nextNode = front;
        	
        	Node before=null;
        	int i=1;
        	Node tmp = front;
        	while(i<k-1){
        		if(i==k-2)
        			before = tmp;
        		tmp = tmp.nextNode;
        		
        		i++;
        		
        	}
        	
			before.nextNode = tmp.nextNode.nextNode;
        }
        
        return item;
    }
    
}*/