
public class ThreadTest{
	public static void main(String[] args){
		Test t = new Test();
		
		Thread th1 = new worker("pjh", t);
		Thread th2 = new worker("eric", t);
		
		th1.start();
		th2.start();
	}
}

class Test{
	int sum=0;
	synchronized void add(){
		int n= sum;
		Thread.currentThread().yield();
		n+=10;
		sum = n;
		System.out.println(Thread.currentThread().getName()+" : " + sum);
	}
	int getSum(){
		return sum;
	}
}

class worker extends Thread{
	Test t;
	worker(String name, Test t){
		super(name);
		this.t = t;
	}
	
	public void run(){
		int i=0;
		while(i<10){
			t.add();
			i++;
		}
	}
}

