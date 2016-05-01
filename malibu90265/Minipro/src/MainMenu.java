import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.event.*;

public class MainMenu {
	JButton mainBtn[] = new JButton[4];
	ArrayList<Stage> stageList;
	ArrayList<Score> scoreList;
	ArrayList<UserMakeXml> userMakeXmlList;
	ArrayList<LoadDownBlock> userBlock = null;
	UserXmlListOpen uxlo;
	XmlOpen xo;
	String xmlName;

	public void Play(String fileName) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(
					fileName));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
			clip.loop(-1);
		} catch (Exception ex) {
		}
	}

	MainMenu() {
		// Play("main.wav");
		xo = new XmlOpen();
		uxlo = new UserXmlListOpen();
		scoreList = xo.scoreReader();

		userMakeXmlList = uxlo.userMakeXmlReader();
		stageList = new ArrayList<Stage>();
		new MenuList();
	}

	class MenuList extends JFrame {
		MenuList() {
			setTitle("Į�θ��� ������");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container ct = getContentPane();
			MyPanel panel = new MyPanel();
			ct.add(panel);

			setBounds(600, 200, 416, 640);
			setVisible(true);
			setLayout(null);

		}

		class MyPanel extends JPanel {
			ImageIcon icon = new ImageIcon("main.jpg");
			Image img = icon.getImage();
			ArrayList<ImageIcon> imageIcon;
			ArrayList<Image> image;
			ArrayList<ImageIcon> btnImage;

			MyPanel() {
				imageIcon = new ArrayList<ImageIcon>();
				image = new ArrayList<Image>();
				btnImage = new ArrayList<ImageIcon>();

				imageIcon.add(new ImageIcon("startGame.png"));
				imageIcon.add(new ImageIcon("makeGame.png"));
				imageIcon.add(new ImageIcon("score.png"));
				imageIcon.add(new ImageIcon("exit.png"));

				for (int i = 0; i < imageIcon.size(); i++) {
					Image img = imageIcon.get(i).getImage();
					image.add(img.getScaledInstance(130, 50,
							java.awt.Image.SCALE_SMOOTH));
					btnImage.add(new ImageIcon(image.get(i)));
				}
				setLayout(null);
				mainBtn[0] = new JButton(btnImage.get(0));
				mainBtn[1] = new JButton(btnImage.get(1));
				mainBtn[2] = new JButton(btnImage.get(2));
				mainBtn[3] = new JButton(btnImage.get(3));

				for (int i = 0; i < mainBtn.length; i++) {
					mainBtn[i].setLocation(150, 200 + i * 60); // ��ġ����
					mainBtn[i].setSize(120, 50); // ũ������
					mainBtn[i].setBorderPainted(false);
					mainBtn[i].addActionListener(new MenuActionListener()); // Ŭ��������
					add(mainBtn[i]); // Pane�� �߰�
				}
			}

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, this);

			}

		}

		class MenuActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Object btn = e.getSource(); // ���õ� ��ư

				if (btn == mainBtn[0]) { // ���ӽ���
					dispose();
					new SelectXml();
				} else if (btn == mainBtn[1]) { // ���������
					dispose();
					new SelectStage();
				} else if (btn == mainBtn[2]) { // ���
					dispose();
					new ScoreView();
				} else if (btn == mainBtn[3]) { // ��������
					System.exit(0);
				}
			}
		}
	}

	class SelectStage extends JFrame {
		SelectStage() {
			setTitle("�̿� ���� ����");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(600, 200, 400, 600);
			setVisible(true);
			// �ܰ輱��
			add(new myPanel());
		}

		class myPanel extends JPanel {
			ImageIcon icon = new ImageIcon("makeXml1.png");
			Image bgImg = icon.getImage();
			ArrayList<ImageIcon> imageIcon;
			ArrayList<Image> image;
			ArrayList<ImageIcon> btnImage;
			JButton stageBtn[] = new JButton[5];

			myPanel() {
				imageIcon = new ArrayList<ImageIcon>();
				image = new ArrayList<Image>();
				btnImage = new ArrayList<ImageIcon>();

				for (int i = 1; i < 6; i++)
					imageIcon.add(new ImageIcon("step" + i + ".png"));

				for (int i = 0; i < imageIcon.size(); i++) {
					Image img = imageIcon.get(i).getImage();
					image.add(img.getScaledInstance(100, 50,
							java.awt.Image.SCALE_SMOOTH));
					btnImage.add(new ImageIcon(image.get(i)));
				}
				setLayout(null);

				for (int i = 0; i < stageBtn.length; i++) {
					stageBtn[i] = new JButton(btnImage.get(i));
					stageBtn[i].setLocation(100, 200 + i * 60); // ��ġ����
					stageBtn[i].setSize(100, 50); // ũ������
					stageBtn[i].setBorderPainted(false);
					stageBtn[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Object btn = e.getSource();
							int maxStage = 1;
							for (int i = 0; i < 5; i++)
								if (btn == stageBtn[i])
									maxStage = i + 1; // �����̵��� �� = �ܰ�
							dispose();
							new UserDefined(maxStage, 1); // 1�ܰ� ����
						}
					}); // Ŭ��������
					add(stageBtn[i]); // Pane�� �߰�
				}
				setVisible(true);
			}

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImg, 0, 0, this);
			}
		}
	}

	class UserDefined extends JFrame {
		int maxStage; // ������ �������� ��
		boolean item; // �� �ܰ躰 ������ ��� ����
		JRadioButton[] timeRadio;
		JRadioButton useRadio[];
		JComboBox combo[];
		int minute = 0;
		int targetKcal = 0;
		int itemUse = 0;

		UserDefined(int maxStage, int stage) {
			setTitle("�̿� ���� ����");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(1000, 820);
			setVisible(true);

			this.maxStage = maxStage;

			userBlock = new ArrayList<LoadDownBlock>();
			// �ܰ輱��

			add(new MakeStage(stage));
		}

		class MakeStage extends JPanel {// ���ѽð�, ���ӵ�, ����������,�����ۻ������
			ImageIcon icon = new ImageIcon("makeXml2.png");
			Image bgImg = icon.getImage();
			ImageIcon btnImage = new ImageIcon("next.png");
			ImageIcon imageIcon;
			Image image = btnImage.getImage();

			MakeStage(final int stage) {
				setSize(1000, 820);
				Container myPane = getContentPane();
				myPane.removeAll();
				myPane.setLayout(null);
				setVisible(true);

				final JSlider slide[] = new JSlider[2];
				JLabel text[] = new JLabel[5];

				text[0] = new JLabel(stage + "�ܰ��� ���ӵ��� �������ּ���.");
				text[0].setSize(300, 160);
				text[0].setLocation(1, 0);
				myPane.add(text[0]);

				slide[0] = new JSlider(JSlider.HORIZONTAL, 1, 7, 2);
				slide[0].setBounds(getX(), getY(), 500, 100);
				slide[0].setPaintLabels(true);
				slide[0].setPaintTrack(true);
				slide[0].setPaintTicks(true);
				slide[0].setMajorTickSpacing(1);
				slide[0].setSize(600, 160);
				slide[0].setLocation(300, 0);
				slide[0].setOpaque(false);
				myPane.add(slide[0]);

				text[1] = new JLabel(stage + "�ܰ��� �� ���� ������ �������ּ���.");
				text[1].setSize(300, 160);
				text[1].setLocation(1, 160);
				myPane.add(text[1]);

				slide[1] = new JSlider(JSlider.HORIZONTAL, 1, 7, 4);
				slide[1].setPaintLabels(true);
				slide[1].setPaintTrack(true);
				slide[1].setPaintTicks(true);
				slide[1].setMajorTickSpacing(1);
				slide[1].setSize(600, 160);
				slide[1].setLocation(300, 160);
				slide[1].setOpaque(false);
				myPane.add(slide[1]);

				text[2] = new JLabel(stage + "�ܰ��� ���ѽð��� �������ּ���.");
				text[2].setSize(300, 160);
				text[2].setLocation(1, 320);
				myPane.add(text[2]);

				timeRadio = new JRadioButton[12];
				ButtonGroup timeGroup = new ButtonGroup();

				for (int i = 0; i < timeRadio.length; i++) {
					timeRadio[i] = new JRadioButton(
							Integer.toString(10 + 10 * i) + "��");
					timeGroup.add(timeRadio[i]);
					timeRadio[i].setSize(110, 80);
					timeRadio[i].setOpaque(false);
					if (i < timeRadio.length / 2)
						timeRadio[i].setLocation(300 + 110 * i, 320);
					else
						timeRadio[i].setLocation(
								300 + 110 * (i - timeRadio.length / 2), 400);

					timeRadio[i].addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							for (int i = 0; i < timeRadio.length; i++) {
								if (timeRadio[i].isSelected())
									minute = 10 + 10 * i;
							}

						}

					});
					myPane.add(timeRadio[i]);
				}
				timeRadio[0].setSelected(true);

				text[3] = new JLabel(stage + "�ܰ��� ��ǥ Į�θ��� �������ּ���.");
				text[3].setSize(300, 160);
				text[3].setLocation(1, 480);
				myPane.add(text[3]);

				combo = new JComboBox[4];
				JLabel kcalText[] = new JLabel[4];

				for (int i = 0; i < combo.length; i++) {
					combo[i] = new JComboBox();
					kcalText[i] = new JLabel(Integer.toString((int) (Math.pow(
							10, combo.length - i - 1))) + "�� �ڸ� : ");

					kcalText[i].setSize(80, 160);
					kcalText[i].setLocation(300 + (140 - i) * i, 480);

					if (i != 3) {
						for (int j = 0; j < 10; j++)
							combo[i].addItem(Integer.toString(j));
					} else
						combo[i].addItem("0");

					combo[i].setSize(50, 50);
					combo[i].setOpaque(false);
					combo[i].setName(Integer.toString(i));
					combo[i].setLocation(390 + (130 * i), 530);
					combo[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							targetKcal = 0;
							for (int i = 0; i < combo.length; i++) {
								targetKcal += combo[i].getSelectedIndex()
										* Math.pow(10, combo.length - i - 1);
							}
						}
					});
					myPane.add(combo[i]);
					myPane.add(kcalText[i]);

				}
				targetKcal = 0;
				text[4] = new JLabel(stage + "�ܰ��� ������ ��� / ������");
				text[4].setSize(300, 140);
				text[4].setLocation(1, 640);
				myPane.add(text[4]);

				useRadio = new JRadioButton[2];
				ButtonGroup useGroup = new ButtonGroup();

				useRadio[0] = new JRadioButton("���", true);
				useRadio[1] = new JRadioButton("��� ����");

				for (int i = 0; i < 2; i++) {

					useGroup.add(useRadio[i]);
					useRadio[i].setSize(110, 140);
					useRadio[i].setOpaque(false);
					useRadio[i].setLocation(300 + 110 * i, 640);
					myPane.add(useRadio[i]);
					useRadio[i].addItemListener(new ItemListener() {
						int j = 0;

						public void itemStateChanged(ItemEvent e) {
							if (useRadio[j].isSelected())
								item = true;
							else
								item = false;
							++j;
						}
					});
				}
				JButton nextBtn = new JButton(btnImage);
				myPane.add(nextBtn);
				nextBtn.setSize(80, 80);
				nextBtn.setLocation(850, 700);
				nextBtn.setBorderPainted(false);

				nextBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Stage s = new Stage(minute, slide[0].getValue(),
								slide[1].getValue(), targetKcal, item);
						stageList.add(s);
						if (stage < maxStage) { // ������ �ܰ���� ����!
							dispose();
							new UserDefined(maxStage, stage + 1);
						} else { // ��� ������� ������
							dispose();
							new SelectBlock();
						}
					}
				});
				setVisible(true);
			}

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImg, 0, 0, this);
			}
		}

		class SelectBlock extends JFrame {
			SelectBlock() {
				setTitle("������ ����");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setSize(1000, 820);
				setVisible(true);
				setLayout(null);
				// �ܰ輱��
				add(new myPanel());
			}

			class myPanel extends JPanel {
				ImageIcon icon = new ImageIcon("makeXml3.png");
				Image bgImg = icon.getImage();
				ImageIcon btnImage = new ImageIcon("commit.png");
				Image image = btnImage.getImage();

				myPanel() {
					Container myPane = getContentPane();

					XmlOpen xo = new XmlOpen();
					// ��� ���� ������ 40�� �ҷ��ͼ� ����Ʈ ����
					final ArrayList<LoadDownBlock> loadDownBlockList = xo
							.blockReader();
					ImageIcon itemIcon[] = new ImageIcon[loadDownBlockList
							.size()];
					JCheckBox itemBox[] = new JCheckBox[loadDownBlockList
							.size()];

					for (int i = 0; i < loadDownBlockList.size(); i++) {
						final int num = i;
						LoadDownBlock block = loadDownBlockList.get(i);
						itemIcon[i] = new ImageIcon(block.img);
						itemBox[i] = new JCheckBox(itemIcon[i]);

						itemBox[i].setBorderPainted(true);
						itemBox[i].addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED)
									userBlock.add(loadDownBlockList.get(num));
								else
									userBlock.remove(loadDownBlockList.get(num));
							}
						});
						itemBox[i].setSize(100, 100);
						itemBox[i].setOpaque(false);
						itemBox[i].setLocation(30 + 120 * (i % 8),
								80 + 110 * (i / 8));
						myPane.add(itemBox[i]);
					}

					JButton commitBtn = new JButton(btnImage);
					commitBtn.addActionListener(new ActionListener() {
						String xmlName;

						public void actionPerformed(ActionEvent e) {
							xmlName = JOptionPane.showInputDialog("���� �̸� �Է� ",
									"���Ͽ�");
							xmlName = xmlName + ".xml";
							SaveXml(xmlName);// �Է¹��� ������ xml���� ���� �� ����
							userMakeXmlList.add(new UserMakeXml(xmlName));
							new UserXmlList(userMakeXmlList);
							dispose();
							new MenuList();
						}
					});
					commitBtn.setSize(100, 50);
					commitBtn.setLocation(850, 670);
					myPane.add(commitBtn);
					setSize(1000, 820);
					setVisible(true);
				}

				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(bgImg, 0, 0, this);
				}
			}
		}

		void SaveXml(String xmlName) {
			new UserXmlCreate(stageList, userBlock, xmlName);
			for (int i = 0; i < stageList.size(); i++)
				stageList.remove(i);
		}

	}

	class ScoreView extends JFrame {
		ScoreView() {
			setTitle("���");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(600, 200, 400, 600);
			setVisible(true);
			add(new MakePane());
		}

		class MakePane extends JPanel {
			ImageIcon icon = new ImageIcon("viewScore.png");
			Image bgImg = icon.getImage();
			ImageIcon btnImage = new ImageIcon("back.png");
			Image image = btnImage.getImage();

			MakePane() {
				setLayout(null);
				JLabel field[] = new JLabel[3];
				JLabel name[] = new JLabel[scoreList.size()];
				JLabel stage[] = new JLabel[scoreList.size()];
				JLabel score[] = new JLabel[scoreList.size()];

				field[0] = new JLabel("�̸�");
				field[0].setSize(300, 20);
				field[0].setLocation(50, 100);
				field[1] = new JLabel("�ܰ�");
				field[1].setSize(300, 20);
				field[1].setLocation(180, 100);
				field[2] = new JLabel("����");
				field[2].setSize(300, 20);
				field[2].setLocation(300, 100);
				add(field[0]);
				add(field[1]);
				add(field[2]);

				class scoreListComparator implements Comparator {
					public int compare(Object o1, Object o2) {
						int by1 = ((Score) o1).totalScore;
						int by2 = ((Score) o2).totalScore;
						return by1 > by2 ? -1 : (by1 == by2 ? 0 : 1);
					}
				}

				Collections.sort(scoreList, new scoreListComparator());

				for (int i = 0; i < 10 && i < scoreList.size(); i++) {
					name[i] = new JLabel(scoreList.get(i).name);
					name[i].setSize(300, 40);
					name[i].setLocation(50, 120 + 40 * i);

					stage[i] = new JLabel(
							Integer.toString(scoreList.get(i).stage));
					stage[i].setSize(300, 40);
					stage[i].setLocation(180, 120 + 40 * i);

					score[i] = new JLabel(
							Integer.toString(scoreList.get(i).totalScore));
					score[i].setSize(300, 40);
					score[i].setLocation(300, 120 + 40 * i);

					add(name[i]);
					add(stage[i]);
					add(score[i]);
				}

				JButton backBtn = new JButton(btnImage);
				backBtn.setLayout(null);
				backBtn.setLocation(280, 520);
				backBtn.setSize(100, 50);
				backBtn.setOpaque(false);
				backBtn.setBorderPainted(false);
				backBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						new MenuList();
					}
				});
				add(backBtn);
				setSize(400, 600);
				setVisible(true);
			}

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImg, 0, 0, this);
			}
		}

	}

	class SelectXml extends JFrame {
		JButton[] selectXmlBtn;
		StringTokenizer btnName;

		SelectXml() {
			setTitle("�̿� ���� ����");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(1000, 820);
			setLayout(null);
			setVisible(true);
			JScrollPane sp = new JScrollPane(new MakePane());
			sp.setLocation(0, 0);
			sp.setSize(1000, 820);
			sp.setOpaque(false);

			add(sp);
		}

		class MakePane extends JPanel {
			ImageIcon icon = new ImageIcon("selectGame.png");
			Image bgImg = icon.getImage();
			ImageIcon btnImage = new ImageIcon("back.png");
			Image image = btnImage.getImage();

			MakePane() {
				setLayout(null);

				selectXmlBtn = new JButton[userMakeXmlList.size() + 1];

				StringTokenizer token;

				for (int i = 0; i <= userMakeXmlList.size(); i++) {

					if (i == 0)
						selectXmlBtn[i] = new JButton("�⺻ ����");
					else {
						token = new StringTokenizer(
								userMakeXmlList.get(i - 1).xmlName, ".");
						selectXmlBtn[i] = new JButton(
								(String) token.nextElement());
					}
					selectXmlBtn[i].setLocation(100 + 300 * (i % 2),
							150 + (i / 2) * 100);
					selectXmlBtn[i].setSize(200, 50);
					selectXmlBtn[i].setBackground(Color.orange);
					selectXmlBtn[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton btn = (JButton) (e.getSource());
							dispose();
							if (btn.getText() == "�⺻ ����") { // block.xml
								Thread t = new Thread(new Catch(xo, scoreList,
										"basic.xml"));
								t.start();
							} else {
								Thread t = new Thread(new Catch(xo, scoreList,
										btn.getText() + ".xml"));
								t.start();
							}
						}
					});

					add(selectXmlBtn[i]);
				}
				JButton backBtn = new JButton(btnImage);
				backBtn.setLocation(850, 700);
				backBtn.setSize(100, 50);
				backBtn.setOpaque(false);
				backBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						new MenuList();
					}
				});
				add(backBtn);
			}

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImg, 0, 0, this);
			}
		}
	}

	public static void main(String[] args) {
		new MainMenu();
	}
}