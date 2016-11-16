package ch18Josephus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int c = sc.nextInt(); //test case
		int n = sc.nextInt(); // the number of soldiers
		int k = sc.nextInt(); // count number

		List<Soldier> soldiers = new ArrayList<Soldier>();

		for (int i = 1; i < n; i++) { // 조세푸스를 포함한 병사의 수이므로 총 병사 수는 n+1이다.
			Soldier s = new Soldier(i);
			soldiers.add(s);
		}

		int kill = 1;
		while (n > 3) {
			System.out.println("kill: " + kill);
			soldiers.get(kill-1).setKilled(true);

			kill++;

			if (kill == soldiers.get(soldiers.size() - 1).getId()) {
				kill = soldiers.get(0).getId();
			}

			--n;

			for (int i = 0; i < k - 1; i++) {
				++kill;
				if (kill == soldiers.get(soldiers.size() - 1).getId())
					kill = soldiers.get(0).getId();
			}
			if(n!=3)
				soldiers.get(kill-1).setKilled(true);
		}

		for (int i = 0; i < soldiers.size(); i++)
			if (!soldiers.get(i).isKilled())
				System.out.println("생존자 : " + soldiers.get(i).getId());

	}
}

class Soldier {

	// 노드는 data와 다음 노드를 가진다.
	private int id;
	private boolean isKilled;
	private Soldier nextNode;

	Soldier(int id) {
		this.id = id;
		this.isKilled = false;
		this.nextNode = null;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isKilled() {
		return isKilled;
	}

	public void setKilled(boolean isKilled) {
		this.isKilled = isKilled;
	}

	
}