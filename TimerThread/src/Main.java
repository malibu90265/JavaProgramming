
public class Main {
	public static void main(String[] args){
		
		TimerThread tt = new TimerThread();
		tt.start();
		tt.finish();
		
		/*Thread th = new Thread(new Timer());
		th.start();*/
		
		/*long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("name : "+ name);
		System.out.println("ID : " + id);
		System.out.println("Pritority : " + priority);
		System.out.println("Status : "+ s);*/
		
	}
}

class TimerThread extends Thread{
	int n=0;
	boolean flag = false;
	
	public void finish(){
		flag = true;
	}
	
	public void run(){
		while(true){
			System.out.println(n);
			n++;
			try{
				sleep(1000);
				if(flag==true)
					return;
			}catch(InterruptedException e){
				return;
			}
		}
	}
	
}

class Timer implements Runnable{
	int n=0;
	public void run(){
		while(true){
			System.out.println("++" + n);
			n++;
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				return;
			}
		}
	}
}