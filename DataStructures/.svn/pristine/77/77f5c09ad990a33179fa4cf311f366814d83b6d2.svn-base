import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class makeXml extends JFrame {
	ArrayList<Menu> menuList;
	ArrayList<UserMakeXml> userMakeXmlList;
	UserXmlListOpen uxlo;

	Container c = getContentPane();
	JTextField n = new JTextField(10); // 요리명 쓸 텍스트필드
	
	JRadioButton[] type = new JRadioButton[10]; // 기준 선택할 라디오버튼
	JComboBox[] mm = new JComboBox[10]; // 단위 선택할 콤보박스
	
	String name = null, ingrN = null, ingrW = null, mea[] = new String[10]; // 요리명,
	String[] measure = { " ", "g", "ml", "t", "T" }; // 단위 종류																	// 재료명
	int ty = 0; //선택된 기준의 인덱스를 저장

	makeXml() {
		menuList = new ArrayList<Menu>();
		uxlo = new UserXmlListOpen();
		userMakeXmlList = uxlo.userMakeXmlReader();
		
		setTitle("GRAM:: ⓒ 2014.Park Jeong Hyun all rights reserved.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(null);

		Panel4 mp = new Panel4();
		mp.setSize(600, 700);
		mp.setLocation(0, 0);
		c.add(mp);

		setVisible(true);
		setBounds(400, 0, 600, 700);

	}

	class Panel4 extends JPanel {
		ImageIcon icon = new ImageIcon("bg_makeXml.png");
		Image img = icon.getImage();

		Panel4() {
			setLayout(null);
			n.setLocation(200, 70);
			n.setSize(200, 30);
			c.add(n);

		
			// 기준
			ButtonGroup bg = new ButtonGroup();
			for (int i = 0; i < 10; i++) {
				type[i] = new JRadioButton("q");
				type[i].setLocation(100, 150 + i * 40);
				type[i].setSize(20, 30);
				type[i].setOpaque(false);
				bg.add(type[i]);
				c.add(type[i]);
			}
			type[0].setSelected(true);

			// 재료명
			final JTextField[] ingrName = new JTextField[10];
			for (int i = 0; i < 10; i++) {
				ingrName[i] = new JTextField(10);
				ingrName[i].setLocation(170, 150 + i * 40);
				ingrName[i].setSize(100, 30);
				c.add(ingrName[i]);
			}

			// 용량
			final JTextField[] ingrWeight = new JTextField[10];
			for (int i = 0; i < 10; i++) {
				ingrWeight[i] = new JTextField(10);
				ingrWeight[i].setLocation(300, 150 + i * 40);
				ingrWeight[i].setSize(70, 30);
				c.add(ingrWeight[i]);
			}

			// 단위
			for (int i = 0; i < 10; i++) {
				mm[i] = new JComboBox(measure);
				mm[i].setLocation(400, 150 + i * 40);
				mm[i].setSize(70, 30);
				mm[i].setOpaque(false);
				c.add(mm[i]);
			}

			// 확인 버튼
			JButton f = new JButton(new ImageIcon("bt_save.png"));
			f.setOpaque(false);
			f.setContentAreaFilled(false);
			f.setBorderPainted(false);
			f.setSize(100, 50);
			f.setLocation(180, 580);
			c.add(f);

			JButton backBtn = new JButton(new ImageIcon("bt_back.png"));
			backBtn.setOpaque(false);
			backBtn.setContentAreaFilled(false);
			backBtn.setBorderPainted(false);
			backBtn.setLocation(300, 580);
			backBtn.setSize(100, 50);
			backBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new mainMenu();
				}
			});
			c.add(backBtn);

			f.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Menu[] m = new Menu[10];
					int index=0;
					name = n.getText();
					for (int i = 0; i < 10; i++) {
						ingrN = ingrName[i].getText();
						ingrW = ingrWeight[i].getText();
						if (type[i].isSelected()) {
							ty = 1;
						} else
							ty = 0;
						index = mm[i].getSelectedIndex();
						mea[i] = measure[index];
						m[i] = new Menu(name, ty, ingrN, ingrW, mea[i]);
						menuList.add(m[i]);

					}
					String xmlName;
					xmlName = name;
					SaveXml(xmlName + ".xml");// 입력한 메뉴 명으로 xml파일 생성 및 저장

					userMakeXmlList.add(new UserMakeXml(xmlName));
					new UserXmlList(userMakeXmlList);
					dispose();
					new mainMenu();
				}
			});

		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);

		}
	}

	void SaveXml(String xmlName) {
		new makeUserXml(menuList, xmlName);
		for (int i = 0; i < menuList.size(); i++)
			menuList.remove(i);
	}

}