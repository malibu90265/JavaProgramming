package 설계패턴_과제3;

import javax.swing.JLabel;

public class Horse extends JLabel implements Runnable{
	private Horse h;
	private RunningStrategy rs;
	private JLabel bg = new JLabel();
	private int x, y;

	
	Horse(JLabel bg, int x, int y){
		this.bg = bg;
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public void setRunningStrategy(RunningStrategy rs){
		this.rs = rs;
	}
	@Override
	public void run() {
		rs.run(bg);
	}
		
}
