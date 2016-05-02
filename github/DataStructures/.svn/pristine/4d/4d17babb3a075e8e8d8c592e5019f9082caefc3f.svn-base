
package 설계패턴_과제3;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
	Container c;
	Main(){
		super("경주마 대회");
		c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Horse h[] = new Horse[4];
		JLabel bg[] = new JLabel[4];
		
		//시작 버튼
		JButton btnStart = new JButton(new ImageIcon("src/start.png"));
		btnStart.setSize(100,40);
		btnStart.setLocation(300,450);
		btnStart.setOpaque(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setBorderPainted(false);
		btnStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread[] th = new Thread[h.length];
				for(int j=0; j<th.length; j++){
					th[j] = new Thread(h[j]);
					th[j].start();
					try{
						Thread.sleep(30);
					}catch(Exception e){}
				}
			}
		});
		c.add(btnStart);
		
		//배경 이미지 설정
		ImageIcon icon = new ImageIcon("src/background.png");
		JLabel img = new JLabel(icon);
		img.setSize(700,500);
		img.setLocation(0,0);
		
		//가로로 한줄씩 라벨에 말을 생성	
		for(int i=0; i<4; i++){
			bg[i] = new JLabel();
			bg[i].setSize(700,90);
			bg[i].setLocation(0,90*i);
			h[i] = new Horse(bg[i], 0, 100*i);
		}
		
		h[0].setRunningStrategy(new StandardRunning());
		h[1].setRunningStrategy(new FastRunning());
		h[2].setRunningStrategy(new SlowRunning());
		h[3].setRunningStrategy(new BackRunning());

		//지정된 위치에 말을 놓는다
		for(int i=0; i<h.length; i++){
			add(h[i]);
			setLocation(h[i].getX(), h[i].getY());
			c.add(bg[i]);
		}

		c.setLocation(10,50);
		setSize(700, 600);
		setVisible(true);
		c.add(img);
		
	}
	public static void main(String[] args) {
		
		new Main();
		
	}
}

