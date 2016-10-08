package zzz;
/*두 사람 A와 B는 1부터 10까지의 숫자가 하나씩 적힌 열 장의 카드로 ‘게임’을 한다. 게임은 총 열 번의 ‘라운드’로 구성되고, 각 라운드 마다 자신이 가지고 있는 카드 중 하나를 제시하고, 한 번 제시한 카드는 버린다. 게임 승패는 다음과 같이 결정된다.
각 라운드는 더 높은 숫자를 제시한 사람이 승리하고, 제시한 숫자가 같은 경우는 비긴다.
열 번의 라운드에서 더 많은 라운드를 승리한 사람이 게임을 승리하고, 승리한 라운드 횟수가 동일한 경우 비긴다.
다음은 게임의 한 예로, 각 라운드마다 A와 B가 제시한 카드의 숫자와 각 라운드의 승자를 보여준다. (비긴 라운드는 D로 표시함)
라운드	1	2	3	4	5	6	7	8	9	10
A의카드	6	7	5	1	4	10	2	3	8	9
B의카드	1	10	2	9	4	8	3	7	5	6
라운드승자	A	B	A	B	D	A	B	B	A	A
A는 5번의 라운드에서 승리하고 B는 4번의 라운드에서 승리하였으므로, 이 게임은 A가 승리한다.
라운드 순서대로 A와 B가 제시한 카드의 숫자가 주어졌을 때, 게임의 승자를 판단하는 프로그램을 작성하시오.

수행시간은 1초를 넘을 수 없다. 사용하는 메모리는 128MB를 넘을 수 없다.

입력

첫 번째 줄에는 A가 제시한 카드의 숫자 10개가 라운드 순서대로 주어지고,
두 번째 줄에는 B가 제시한 카 드의 숫자 10개가 라운드 순서대로 주어진다.
출력

게임의 승패가 결정되는 경우 승리한 사람을 출력하고, 비기는 경우에는 D를 출력한다.
입출력 예

입력

6 7 5 1 4 10 2 3 8 9
1 10 2 9 4 8 3 7 5 6

출력

A

입력

1 2 3 4 5 6 7 8 9 10
5 4 3 2 1 10 9 8 7 6

출력

D
출처:koi 32 회 중등 지역본선 1/4*/
import java.util.Scanner;
public class test {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int[] cardA = new int[10];
		int[] cardB = new int[10];
		int winA = 0;	// A가 이긴 횟수
		int winB = 0;
		
		for(int i=0; i<cardA.length; i++)
			cardA[i] = s.nextInt();
		for(int i=0; i<cardB.length; i++){
			cardB[i] = s.nextInt();
			if(cardA[i] > cardB[i])
				winA++;
			if(cardA[i] < cardB[i])
				winB++;
		}
		
		System.out.println(winA<winB? "B" : winA>winB? "A" : "D");
		/*
		아래 소스코드처럼 쓸 수 있지만 너무 길다. 
		삼항 연산자를 사용해 한 줄로 줄이자.
		
		if(winA<winB)
			System.out.println("B");
		else if(winA>winB)
			System.out.println("A");
		else
			System.out.println("D");*/
		
	}
	
}
