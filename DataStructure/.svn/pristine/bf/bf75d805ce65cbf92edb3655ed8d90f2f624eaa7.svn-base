import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class showXml extends JFrame {
		Container c;
		ArrayList<Menu> menuList = null;
		XmlOpen uxo;
		StringTokenizer token;

		showXml(String xmlName) {
			c = getContentPane();

			uxo = new XmlOpen(xmlName + ".xml");
			menuList = uxo.menuReader();

			setTitle("GRAM:: ⓒ 2014.Park Jeong Hyun all rights reserved.");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			c.setLayout(null);
			
			Panel3 sp = new Panel3();
			sp.setSize(600,700);
			sp.setLocation(0,0);
			c.add(sp);
						
			setVisible(true);
			setBounds(400,0,600,700);

		}
		
		class Panel3 extends JPanel{
			JTextField setW;
			JLabel menuName = new JLabel();
			JLabel[] ingrName = new JLabel[10];
			JTextField[] ingrWeight = new JTextField[10];
			JRadioButton[] type = new JRadioButton[10]; // 기준 선택할 라디오버튼
			JLabel[] m = new JLabel[10]; // 단위 출력할 라벨
			
			String name = null, ingrN = null, ingrW = null, mea = null; // 요리명, 재료명
			int ty = 0; // 기준, 용량, 단위			
			int set; // 선택된 기준의 인덱스 넘버
			
			ImageIcon icon = new ImageIcon("bg_gram.png");
			Image img = icon.getImage();
			
			Panel3(){

				menuName.setText(menuList.get(0).name);
				menuName.setFont(new Font("Haan Baekje B",Font.PLAIN,30));
				menuName.setLocation(260, 0);
				menuName.setSize(200, 50);
				c.add(menuName);

				setW = new JTextField();
				setW.setLocation(340, 50);
				setW.setSize(100, 30);
				c.add(setW);

				
				// 기준
				ButtonGroup bg = new ButtonGroup();
				for (int i = 0; i < 10; i++) {
					type[i] = new JRadioButton("q");
					type[i].setLocation(100, 150 + i * 40);
					type[i].setSize(20, 30);
					type[i].setOpaque(false);
					bg.add(type[i]);
					c.add(type[i]);
					if (menuList.get(i).type == 1){
						type[i].setSelected(true);
						set = i;
					}
					else
						type[i].setSelected(false);
				}

				// 재료명
				for (int i = 0; i < 10; i++) {
					ingrName[i] = new JLabel();
					ingrName[i].setLocation(170, 150 + i * 40);
					ingrName[i].setSize(100, 30);
					ingrName[i].setText(menuList.get(i).ingrN);
					c.add(ingrName[i]);
				}

				// 용량
				for (int i = 0; i < 10; i++) {
					ingrWeight[i] = new JTextField(10);
					ingrWeight[i].setLocation(300, 150 + i * 40);
					ingrWeight[i].setSize(70, 30);
					ingrWeight[i].setText(menuList.get(i).ingrW);
					c.add(ingrWeight[i]);
				}

				// 단위
				for (int i = 0; i < 10; i++) {
					m[i] = new JLabel();
					m[i].setText(menuList.get(i).m);
					m[i].setLocation(400, 150 + i * 40);
					m[i].setSize(70, 30);
					c.add(m[i]);
				}

				// 확인 버튼
				JButton f = new JButton(new ImageIcon("bt_commit.png"));
				f.setSize(70, 30);
				f.setLocation(460, 50);
				f.setOpaque(false);
				f.setContentAreaFilled(false);
				f.setBorderPainted(false);
				c.add(f);
				f.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						float gram = Integer.parseInt(setW.getText());
						float weight = Float.parseFloat(menuList.get(set).ingrW);
						weight = gram / weight;
						
						String str;					
						for (int i = 0; i < 10; i++) {
							if (menuList.get(i).ingrW != "") {
								float weightChanged = weight * Float.parseFloat(menuList.get(i).ingrW);
								str = String.format("%.2f", weightChanged);
								ingrWeight[i].setText(str);
							}
						}

					}
				});

				JButton backBtn = new JButton(new ImageIcon("bt_back_small.png"));
				backBtn.setLocation(460, 550);
				backBtn.setSize(70,30);
				backBtn.setOpaque(false);
				backBtn.setContentAreaFilled(false);
				backBtn.setBorderPainted(false);
				backBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						new mainMenu();
					}
				});
				c.add(backBtn);

				
			}
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(img, 0, 0, this);

			}
		}
	}