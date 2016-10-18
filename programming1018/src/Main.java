import java.util.ArrayList;
import java.util.Scanner;

//균형잡힌 이진 검색 트리
//AVL, 블랙체리 알고리즘이 있지만, 프로그래밍 대회에서 쉽게 사용할 수 있는 '트립' 알고리즘을 구현함.

class Node {
	private int key;// 노드에 저장된 원소
	private int priority;// 이 노드의 우선순위
	private int size;// 이 노드를 루트로 하는 서브트리의 크기
	private Node left, right; // 자식 노드

	Node(int key) {
		this.key = key;
		priority = (int) (Math.random() * 100) + 1; // 1~100까지 난수 생성
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
		System.out.print("생성할 노드의 개수 입력해주세요>>");
		int numNode = s.nextInt();

		int num;
		ArrayList<Node> tree = new ArrayList<Node>();
		for (int i = 0; i < numNode; i++) {
			System.out.print("노드의 Key 값을 입력해주세요>>");
			num = s.nextInt();
			Node n = new Node(num);
			tree.add(n);
		}

		System.out.println("트리가 생성되었습니다.");

		while (true) {
			System.out.println("1. 노드 추가  2. 노드 삭제  3. 중위순회");
			System.out.print("원하는 기능을 선택하세요>>");
			num = s.nextInt();

			switch (num) {
			case 1:
				System.out.println("*노드 추가* 추가하려는 노드의 KEY값을 입력하세요>>");
				num = s.nextInt();
				Node newNode = new Node(num);
				tree.add(newNode);
				System.out.println("노드가 추가되었습니다.");
				break;
			case 2:
				System.out.println("*노드 삭제* 삭제하려는 노드의 KEY값을 입력하세요>>");
				num = s.nextInt();

				break;
			case 3:

				break;
			}
		}

		// 중위 순회 코드

	}

}
