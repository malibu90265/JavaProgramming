import java.util.ArrayList;
import java.util.Scanner;

//�������� ���� �˻� Ʈ��
//AVL, ��ü�� �˰����� ������, ���α׷��� ��ȸ���� ���� ����� �� �ִ� 'Ʈ��' �˰����� ������.

class Node {
	private int key;// ��忡 ����� ����
	private int priority;// �� ����� �켱����
	private int size;// �� ��带 ��Ʈ�� �ϴ� ����Ʈ���� ũ��
	private Node left, right; // �ڽ� ���

	Node(int key) {
		this.key = key;
		priority = (int) (Math.random() * 100) + 1; // 1~100���� ���� ����
		this.left = null;
		this.right = null;
		this.size = 1;
	}

	public void setLeft(Node newLeft) {
		this.left = newLeft;
		this.size += newLeft.size;
	}

	public void setRight(Node newRight) {
		this.right = newRight;
		this.size += newRight.size;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public int getPriority() {
		return priority;
	}

}

class Tree {
	private ArrayList<Node> tree;
	private Node root;

	Tree(){
		tree = new ArrayList<Node>();
	}
	
	public Node getRootNode(){
		return root;
	}
	
	public void split(Node root, int key) {

	}

	public void addNode(Node newNode) {
		if(root.getPriority() > newNode.getPriority()){
			
		}else{
			
		}
		
		
	}

	public void rmNode() {

	}

}

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("������ ����� ���� �Է����ּ���>>");
		int numNode = s.nextInt();

		int num;
		ArrayList<Node> tree = new ArrayList<Node>();
		for (int i = 0; i < numNode; i++) {
			System.out.print("����� Key ���� �Է����ּ���>>");
			num = s.nextInt();
			Node n = new Node(num);
			tree.add(n);
		}

		System.out.println("Ʈ���� �����Ǿ����ϴ�.");

		while (true) {
			System.out.println("1. ��� �߰�  2. ��� ����  3. ������ȸ");
			System.out.print("���ϴ� ����� �����ϼ���>>");
			num = s.nextInt();

			switch (num) {
			case 1:
				System.out.println("*��� �߰�* �߰��Ϸ��� ����� KEY���� �Է��ϼ���>>");
				num = s.nextInt();
				Node newNode = new Node(num);
				tree.add(newNode);
				System.out.println("��尡 �߰��Ǿ����ϴ�.");
				break;
			case 2:
				System.out.println("*��� ����* �����Ϸ��� ����� KEY���� �Է��ϼ���>>");
				num = s.nextInt();

				break;
			case 3:

				break;
			}
		}

		// ���� ��ȸ �ڵ�

	}

}
