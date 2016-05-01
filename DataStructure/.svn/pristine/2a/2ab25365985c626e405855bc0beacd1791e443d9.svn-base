import java.awt.*;

import javax.swing.*;

import org.w3c.dom.NodeList;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class mainMenu extends JFrame {
	
	ArrayList<Menu> menuList;
	ArrayList<UserMakeXml> userMakeXmlList;
	UserXmlListOpen uxlo;

	mainMenu() {
		Container c = getContentPane();
		c.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GRAM:: ¨Ï 2014.Park Jeong Hyun all rights reserved.");
		
		Panel1 p = new Panel1();
		p.setSize(600,500);
		p.setLocation(0,0);
		c.add(p);

		setBounds(400,0,600,500);
		setVisible(true);
	}
	
	class Panel1 extends JPanel{
		ImageIcon icon = new ImageIcon("bg_main.png");
		Image img = icon.getImage();
		JButton[] mainBtn = new JButton[4];
		
		Panel1(){
			menuList = new ArrayList<Menu>();
			uxlo = new UserXmlListOpen();
			userMakeXmlList = uxlo.userMakeXmlReader();
			setLayout(null);
			
			
			mainBtn[0] = new JButton(new ImageIcon("bt1_main.png"));
			mainBtn[1] = new JButton(new ImageIcon("bt2_main.png"));
			mainBtn[2] = new JButton(new ImageIcon("bt4_main.png"));
			
			for (int i = 0; i < 3; i++) {
				mainBtn[i].setLocation(190, 150 + i * 60);
				mainBtn[i].setSize(200, 50);
				mainBtn[i].setOpaque(false);
				mainBtn[i].setContentAreaFilled(false);
				mainBtn[i].setBorderPainted(false);
				add(mainBtn[i]);
				mainBtn[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						Object btn = e.getSource();

						if (btn == mainBtn[0]) {
							dispose();
							new selectXml();
						} else if (btn == mainBtn[1]) {
							dispose();
							new makeXml();
						} else if (btn == mainBtn[2]) {
							System.exit(0);
						}
					}
				});
			}
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);

		}
	}
	

	public static void main(String[] args) {
		new mainMenu();
	}

}
