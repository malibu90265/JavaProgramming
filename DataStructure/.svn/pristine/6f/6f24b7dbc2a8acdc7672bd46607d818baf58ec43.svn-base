import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class selectXml extends JFrame {
	ArrayList<Menu> menuList;
	ArrayList<UserMakeXml> userMakeXmlList;
	UserXmlListOpen uxlo;

	Container c;
	JButton[] selectXmlBtn;

	selectXml() {
		menuList = new ArrayList<Menu>();
		uxlo = new UserXmlListOpen();
		userMakeXmlList = uxlo.userMakeXmlReader();

		c = getContentPane();
		setTitle("GRAM:: ¨Ï 2014.Park Jeong Hyun all rights reserved.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		Panel2 mp = new Panel2();
		mp.setSize(600, 600);
		mp.setLocation(0, 0);
		c.add(mp);

		setVisible(true);
		setBounds(400, 0, 600, 600);
	}

	class Panel2 extends JPanel {
		StringTokenizer token;
		String xmlName;
		ImageIcon icon = new ImageIcon("bg_selXml.png");
		Image img = icon.getImage();

		Panel2() {
			setLayout(null);
			selectXmlBtn = new JButton[userMakeXmlList.size() + 1];

			for (int i = 1; i <= userMakeXmlList.size(); i++) {
				token = new StringTokenizer(userMakeXmlList.get(i - 1).xmlName,".");
				xmlName = (String) token.nextElement();
				selectXmlBtn[i] = new JButton(xmlName);
				selectXmlBtn[i].setLocation(50 + 300 * (i % 2),
						100 + (i / 2) * 70);
				selectXmlBtn[i].setSize(200, 50);

				selectXmlBtn[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton) (e.getSource());
						dispose();
						new showXml(xmlName);
					}
				});

				add(selectXmlBtn[i]);
			}
			
			JButton backBtn = new JButton(new ImageIcon("bt_back.png"));
			backBtn.setOpaque(false);
			backBtn.setContentAreaFilled(false);
			backBtn.setBorderPainted(false);
			backBtn.setLocation(850, 700);
			backBtn.setSize(100, 50);
			backBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new mainMenu();
				}
			});
			add(backBtn);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);

		}
	}

}