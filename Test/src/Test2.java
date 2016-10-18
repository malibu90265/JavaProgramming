import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("** 트리만들기 **");
		System.out.println("Root Node>>");
		
		int data = sc.nextInt();
		Node n = new Node(data);
		Tree t = new Tree(n);
		
		System.out.println("** 트리 초기화 완성!");
		while(t.getTreeDepth(t.getRootNode(), 1) != 0){
			System.out.println("1. Node 추가   2. Node 삭제 0. 종료 >>");
			int num = sc.nextInt();
			if(num==0){
				break;
			}
			if(num==1){
				System.out.println("추가할 Node의 데이터 값>>");
				num = sc.nextInt();
				n = new Node(num);
				t.add(n);
			}
			if(num==2){
				System.out.println("삭제할 Node의 데이터 값>>");
				num = sc.nextInt();
				t.delete(num);
			}
		}
		
		System.out.println("**프로그램이 종료되었습니다");
	
	}
}

class Tree{
	private ArrayList<Node> tree;
	Tree(Node root){
		//root 노드 설정
		tree = new ArrayList<Node>();
		tree.add(root);
	}
	
	public Node getRootNode(){
		return tree.get(0);
	}
	
	public int getTreeDepth(Node rootNode, int cnt){
		ArrayList<Integer> depth = new ArrayList<Integer>();
		
		Node n = rootNode;
		while(true){
			if(n.getLeftChild() == null && n.getRightChild() == null){
				depth.add(cnt);
				break;
			}
			else if(n.getLeftChild() != null && n.getRightChild() == null){
				getTreeDepth(n.getLeftChild(), ++cnt);
			}else if(n.getLeftChild() == null && n.getRightChild() != null){
				getTreeDepth(n.getRightChild(), ++cnt);
			}else{
				getTreeDepth(n.getLeftChild(), cnt+1);
				getTreeDepth(n.getRightChild(), cnt+1);
			}
			
		}
		
		int min = depth.get(0);
		for(int d : depth){
			if(min > d)
				min = d;
		}
		
		return min;
	
	}
	
	//node 추가
	public void add(Node n){
		Node root = tree.get(0);

		while(true){
			//root보다 작고
			if(root.getData() > n.getData()){
				//왼쪽 노드가 비어있으면 left에 추가
				if(root.getLeftChild() == null){
					root.setLeftChild(n);
					break;
				}
				//비어있지 않으면 다시 비교
				else 	root = root.getLeftChild();
			}
			//root보다 크고, 오른쪽 노드가 비어있으면 right에 추가
			else if(root.getData() < n.getData()){
				if(root.getRightChild() == null){
					root.setRightChild(n);
					break;
				}
				//비어있지 않으면 다시 비교
				else root = root.getRightChild();
			}
		}
		
	}
	
	public void delete(int num){
		//1. 삭제할 노드 찾기
		Node root = tree.get(0);
		Node deleteNode = null;

		while(true){
			if(root.getData() == num){
				deleteNode = root;
				System.out.println("Root 노드를 삭제했습니다.");
				break;
			}
			//root보다 작고
			if(root.getData() > num){
				//왼쪽 노드가 비어있으면 left에 추가
				if(root.getLeftChild() == null){
					System.out.println("삭제할 노드를 찾지 못했습니다.");
					break;
				}
				//비어있지 않으면 다시 비교
				else 	root = root.getLeftChild();
			}
			//root보다 크고, 오른쪽 노드가 비어있으면 right에 추가
			else{
				if(root.getRightChild() == null){
					System.out.println("삭제할 노드를 찾지 못했습니다.");
					break;
				}
				//비어있지 않으면 다시 비교
				else root = root.getRightChild();
			}
		}
		
		
		//삭제할 노드를 찾았으면
		if(deleteNode != null){
			//2-1. 삭제할 노드가 단말 노드인 경우(자식이 없는 경우)
			// ----> 바로 삭제해주면 됨.
			if(deleteNode.getLeftChild()==null && deleteNode.getRightChild()==null){
				for(Node t : tree)
					if(t.getData() == deleteNode.getData())
						tree.remove(t);
			}
			// 2-2. 삭제할 노드가 2개의 자식을 가진 경우 ---> 루트노드와 가장 인접한 숫자를 가져옴.
			// ---> 루트노드의 왼쪽 서브트리에서 가장 큰 자식 선택.
			// ---> or 루트노드의 오른쪽 서브트리에서 가장 작은 자식 선택.
			else if(deleteNode.getLeftChild() !=null && deleteNode.getRightChild() !=null){
				Node child = deleteNode.getLeftChild();
				while(true){
					if((child.getLeftChild() != null && child.getRightChild()==null)){
						child.setData(child.getLeftChild().getData());
						child.setLeftChild(child.getLeftChild().getLeftChild());
						break;
					}else if(child.getLeftChild() !=null && child.getRightChild() !=null){
						deleteNode.setData(child.getData());
						break;
					}else{
						child = child.getRightChild();
					}
				}
			}
			//2-3. 삭제할 노드가 하나의 자식을 가진 경우
			// ---> 자기 자리에 자식 노드를 올려주면 됨.
			else if(deleteNode.getLeftChild() !=null && deleteNode.getRightChild() ==null)
				deleteNode = deleteNode.getLeftChild();
			else
				deleteNode = deleteNode.getRightChild();
			
			System.out.println("노드를 삭제했습니다.");
		}		
		
	}
	
	
}

class Node{
	private int data;
	private Node left, right;
	
	Node(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}

	public int getData(){
		return this.data;
	}
	
	public void setLeftChild(Node left){
		this.left = left;
	}
	
	public void setRightChild(Node right){
		this.right = right;
	}
	
	public Node getLeftChild(){
		return this.left;
	}
	
	public Node getRightChild(){
		return this.right;
	}
	
}