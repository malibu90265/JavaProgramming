import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("** Ʈ������� **");
		System.out.println("Root Node>>");
		
		int data = sc.nextInt();
		Node n = new Node(data);
		Tree t = new Tree(n);
		
		System.out.println("** Ʈ�� �ʱ�ȭ �ϼ�!");
		while(t.getTreeDepth(t.getRootNode(), 1) != 0){
			System.out.println("1. Node �߰�   2. Node ���� 0. ���� >>");
			int num = sc.nextInt();
			if(num==0){
				break;
			}
			if(num==1){
				System.out.println("�߰��� Node�� ������ ��>>");
				num = sc.nextInt();
				n = new Node(num);
				t.add(n);
			}
			if(num==2){
				System.out.println("������ Node�� ������ ��>>");
				num = sc.nextInt();
				t.delete(num);
			}
		}
		
		System.out.println("**���α׷��� ����Ǿ����ϴ�");
	
	}
}

class Tree{
	private ArrayList<Node> tree;
	Tree(Node root){
		//root ��� ����
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
	
	//node �߰�
	public void add(Node n){
		Node root = tree.get(0);

		while(true){
			//root���� �۰�
			if(root.getData() > n.getData()){
				//���� ��尡 ��������� left�� �߰�
				if(root.getLeftChild() == null){
					root.setLeftChild(n);
					break;
				}
				//������� ������ �ٽ� ��
				else 	root = root.getLeftChild();
			}
			//root���� ũ��, ������ ��尡 ��������� right�� �߰�
			else if(root.getData() < n.getData()){
				if(root.getRightChild() == null){
					root.setRightChild(n);
					break;
				}
				//������� ������ �ٽ� ��
				else root = root.getRightChild();
			}
		}
		
	}
	
	public void delete(int num){
		//1. ������ ��� ã��
		Node root = tree.get(0);
		Node deleteNode = null;

		while(true){
			if(root.getData() == num){
				deleteNode = root;
				System.out.println("Root ��带 �����߽��ϴ�.");
				break;
			}
			//root���� �۰�
			if(root.getData() > num){
				//���� ��尡 ��������� left�� �߰�
				if(root.getLeftChild() == null){
					System.out.println("������ ��带 ã�� ���߽��ϴ�.");
					break;
				}
				//������� ������ �ٽ� ��
				else 	root = root.getLeftChild();
			}
			//root���� ũ��, ������ ��尡 ��������� right�� �߰�
			else{
				if(root.getRightChild() == null){
					System.out.println("������ ��带 ã�� ���߽��ϴ�.");
					break;
				}
				//������� ������ �ٽ� ��
				else root = root.getRightChild();
			}
		}
		
		
		//������ ��带 ã������
		if(deleteNode != null){
			//2-1. ������ ��尡 �ܸ� ����� ���(�ڽ��� ���� ���)
			// ----> �ٷ� �������ָ� ��.
			if(deleteNode.getLeftChild()==null && deleteNode.getRightChild()==null){
				for(Node t : tree)
					if(t.getData() == deleteNode.getData())
						tree.remove(t);
			}
			// 2-2. ������ ��尡 2���� �ڽ��� ���� ��� ---> ��Ʈ���� ���� ������ ���ڸ� ������.
			// ---> ��Ʈ����� ���� ����Ʈ������ ���� ū �ڽ� ����.
			// ---> or ��Ʈ����� ������ ����Ʈ������ ���� ���� �ڽ� ����.
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
			//2-3. ������ ��尡 �ϳ��� �ڽ��� ���� ���
			// ---> �ڱ� �ڸ��� �ڽ� ��带 �÷��ָ� ��.
			else if(deleteNode.getLeftChild() !=null && deleteNode.getRightChild() ==null)
				deleteNode = deleteNode.getLeftChild();
			else
				deleteNode = deleteNode.getRightChild();
			
			System.out.println("��带 �����߽��ϴ�.");
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