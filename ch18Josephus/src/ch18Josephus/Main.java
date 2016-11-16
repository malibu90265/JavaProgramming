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
		
		for(int i=0; i<=n; i++){	// 조세푸스를 포함한 병사의 수이므로 총 병사 수는 n+1이다.
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
			System.out.println("생존자 : " + (survivors.get(i)+1));
		
	}
}

/*class Survivors{
    private class Node{
        private int  data;	// 노드는 data와 다음 노드를 가진다.
        private Node nextNode;
    
        Node(int data){
            this.data = data;
            this.nextNode = null;
        }
    }
    
    private Node front;			// 큐는 front노드와 rear노드를 가진다.
    private Node rear;
    
    public Survivors(){
        this.front = null;
        this.rear = null;
    }
    
    public boolean empty(){		// 큐가 비어있는지 확인
        return (front==null);
    }
    
    public void insert(int item){	// item을 큐의 rear에 넣는다.
        Node node = new Node(item);
        node.nextNode = null;
        
        if(empty()){
            rear = node;
            front = node;
        }else{
            rear.nextNode = node;
            rear = node;
            rear.nextNode = front;	//원형 큐를 만들어주기 위해 rear의 다음 노드를 front로 지정한다.
        }
        
    }
    
    public void remove(int k){		// front를 큐에서 제거한다.
        
    	if(front.nextNode==null){
    		rear = null;
    	}else{
    		int i=1;
    		Node tmp;
    		while(i<k-1){
    			tmp = tmp.nextNode;
    			i++;
    		}
    		//tmp는 삭제하려는 노드의 이전 노드가 된다.
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