
public class RecordMaker {
	private int count;
	private int[] id;
	private int[] score;
	
	//Initialization
	RecordMaker(int count){
		this.count = count;
		id = new int[count];
		score = new int[count];
	}
	
	//�����ȣ �� ���� ����
	public void makeRandomNum(){
		for(int i=0; i<this.count; i++){
			this.id[i] = (int)(Math.random()*99999)+1;
			this.score[i] = (int)(Math.random()*99)+0;
			
			//�����ȣ �ߺ� ����
			for(int j=0; j<i ; j++){
				if(this.id[i] == this.id[j]){
					i--;
					break;
				}
			}
		}
	}
	
	//���
	public void print(){
		for(int i=0; i<this.count; i++){
			System.out.format("NT"+"%05d",this.id[i]);
			System.out.println();
			System.out.println(this.score[i]);
		}
	}
	
	public static void main(String[] args){
		
	    if (args.length == 0) {
	      System.err.println("Count Error");
	      System.exit(1);
	    }
		
		int count = Integer.parseInt(args[0]);
		
		RecordMaker rm = new RecordMaker(count);
		rm.makeRandomNum();
		rm.print();
		
		
	}
}
