package ������;

import java.util.Scanner;

public class QuickSorting {
	public static void quick_sorting(int[] arr, int left, int right){
		if(left<right){
			int pivot = partition(arr, left, right);
			quick_sorting(arr, left, pivot-1);
			quick_sorting(arr, pivot+1, right);
		}
	}
	
	public static int partition(int[] arr, int left, int right){
		int pivot = arr[left];
		int low = left;
		int high = right+1;
		
		do{
			//low�� pivot�� ���ϸ� ���������� ��ĭ�� ����
			do
				low++;
			while(low<=right && arr[low] < pivot);
			//high�� pivot�� ���ϸ� �������� ��ĭ�� ����
			do
				high--;
			while(high>=left && arr[high] > pivot);
			//low�� high�� ����ġ�� �ʾ��� �� ���� swap
			if(low<high){
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}while(low<high);//low�� high�� ���� ������ �ݺ�
		
		//pivot ���� low��high�� ���� ������ ���� Swap
		int temp = arr[left];
		arr[left] = arr[high];
		arr[high] = temp;
		
		return high;
		
	}
	public static void main(String[] args) {

		while (true) {
			Scanner s = new Scanner(System.in);
			System.out.println("���� ���� �Է�>>");
			int num = s.nextInt();
			System.out.println("������ �迭 �Է�>>");
			 int[] arr = new int[num];
			for (int i = 0; i < arr.length; i++)
				arr[i] = s.nextInt();
			
			int left = 0;
			int right = arr.length-1;
			 
			quick_sorting(arr, left, right);
			
			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();

		}

	}
}


/*package ������;

import java.util.Scanner;

public class QuickSorting {
	public static void main(String[] args) {

		while (true) {
			Scanner s = new Scanner(System.in);
			System.out.println("���� ���� �Է�>>");
			int num = s.nextInt();
			System.out.println("������ �迭 �Է�>>");
			 int[] arr = new int[num];
			for (int i = 0; i < arr.length; i++)
				arr[i] = s.nextInt();
			
			int pivot = arr[0];
			int low = 1;
			int high = arr.length - 1;
			
			while (low != high) {
				if (arr[low] < pivot)
					low++;
				else {
					if (arr[high] > pivot)
						high--;
					else {
						int temp = arr[high];
						arr[high] = arr[low];
						arr[low] = temp;
						low++;
					}
				}
			}

			if (pivot < arr[low]) {
				int temp = arr[low - 1];
				arr[low - 1] = pivot;
				arr[0] = temp;
				//this.pivot = arr[low + 1];
			} else {
				int temp = arr[low + 1];
				arr[low + 1] = pivot;
				arr[0] = temp;
				//this.pivot = arr[low + 1];
			}
			 
			
			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();

		}

	}
}


---------------------

public static void quick_sort(int arr[], int left, int right){
		if(left<right){
			int q = partiton(arr, left, right);
			quick_sort(arr, left, q-1);
			quick_sort(arr, q+1, right);
		}
	}
	
	public static int partiton(int[] arr, int left, int right){
		int low = left;
		int high = right+1;
		int pivot = arr[left];
		
		do{
			do
				low++;
			while(low <= right && arr[low]<pivot);
			do
				high--;
			while(high >= left && arr[high]>pivot);
			if(low<high){
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}while(low<high);
		
		int temp = arr[left];
		arr[left] = arr[high];
		arr[high] = temp;
		
		return high;
	}
	public static void main(String[] args) {

		while (true) {
			Scanner s = new Scanner(System.in);
			System.out.println("���� ���� �Է�>>");
			int num = s.nextInt();
			System.out.println("������ �迭 �Է�>>");
			 int[] arr = new int[num];
			for (int i = 0; i < arr.length; i++)
				arr[i] = s.nextInt();
			int left = 0;
			int right = arr.length-1;
			
			quick_sort(arr, left, right);
			
			
			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();

		}

	}
*/