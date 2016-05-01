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
			setTitle("칼로리를 맞춰줘");
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
					mainBtn[i].setLocation(150, 200 + i * 60); // 위치지정
					mainBtn[i].setSize(120, 50); // 크기지정
					mainBtn[i].setBorderPainted(false);
					mainBtn[i].addActionListener(new MenuActionListener()); // 클릭했을때
					add(mainBtn[i]); // Pane에 추가
				}
			}

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, this);

			}

		}

		class MenuActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Object btn = e.getSource(); // 선택된 버튼

				if (btn == mainBtn[0]) { // 게임시작
					dispose();
					new SelectXml();
				} else if (btn == mainBtn[1]) { // 사용자정의
					dispose();
					new SelectStage();
				} else if (btn == mainBtn[2]) { // 기록
					dispose();
					new ScoreView();
				} else if (btn == mainBtn[3]) { // 게임종료
					System.exit(0);
				}
			}
		}
	}

	class SelectStage extends JFrame {
		SelectStage() {
			setTitle("미운 오리 새끼");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(600, 200, 400, 600);
			setVisible(true);
			// 단계선택
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
					stageBtn[i].setLocation(100, 200 + i * 60); // 위치지정
					stageBtn[i].setSize(100, 50); // 크기지정
					stageBtn[i].setBorderPainted(false);
					stageBtn[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Object btn = e.getSource();
							int maxStage = 1;
							for (int i = 0; i < 5; i++)
								if (btn == stageBtn[i])
									maxStage = i + 1; // 슬라이드의 값 = 단계
							dispose();
							new UserDefined(maxStage, 1); // 1단계 설정
						}
					}); // 클릭했을때
					add(stageBtn[i]); // Pane에 추가
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
		int maxStage; // 게임할 스테이지 수
		boolean item; // 각 단계별 아이템 사용 유무
		JRadioButton[] timeRadio;
		JRadioButton useRadio[];
		JComboBox combo[];
		int minute = 0;
		int targetKcal = 0;
		int itemUse = 0;

		UserDefined(int maxStage, int stage) {
			setTitle("미운 오리 새끼");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(1000, 820);
			setVisible(true);

			this.maxStage = maxStage;

			userBlock = new ArrayList<LoadDownBlock>();
			// 단계선택

			add(new MakeStage(stage));
		}

		class MakeStage extends JPanel {// 제한시간, 블럭속도, 블럭생성갯수,아이템사용유무
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

				text[0] = new JLabel(stage + "단계의 블럭속도를 선택해주세요.");
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

				text[1] = new JLabel(stage + "단계의 블럭 생성 갯수를 선택해주세요.");
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

				text[2] = new JLabel(stage + "단계의 제한시간을 선택해주세요.");
				text[2].setSize(300, 160);
				text[2].setLocation(1, 320);
				myPane.add(text[2]);

				timeRadio = new JRadioButton[12];
				ButtonGroup timeGroup = new ButtonGroup();

				for (int i = 0; i < timeRadio.length; i++) {
					timeRadio[i] = new JRadioButton(
							Integer.toString(10 + 10 * i) + "초");
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

				text[3] = new JLabel(stage + "단계의 목표 칼로리를 선택해주세요.");
				text[3].setSize(300, 160);
				text[3].setLocation(1, 480);
				myPane.add(text[3]);

				combo = new JComboBox[4];
				JLabel kcalText[] = new JLabel[4];

				for (int i = 0; i < combo.length; i++) {
					combo[i] = new JComboBox();
					kcalText[i] = new JLabel(Integer.toString((int) (Math.pow(
							10, combo.length - i - 1))) + "의 자리 : ");

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
				text[4] = new JLabel(stage + "단계의 아이템 사용 / 사용안함");
				text[4].setSize(300, 140);
				text[4].setLocation(1, 640);
				myPane.add(text[4]);

				useRadio = new JRadioButton[2];
				ButtonGroup useGroup = new ButtonGroup();

				useRadio[0] = new JRadioButton("사용", true);
				useRadio[1] = new JRadioButton("사용 안함");

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
						if (stage < maxStage) { // 마지막 단계까지 고르기!
							dispose();
							new UserDefined(maxStage, stage + 1);
						} else { // 모두 골랐으면 블럭선택
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
				setTitle("아이템 설정");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setSize(1000, 820);
				setVisible(true);
				setLayout(null);
				// 단계선택
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
					// 운동과 음식 아이템 40개 불러와서 리스트 생성
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
							xmlName = JOptionPane.showInputDialog("게임 이름 입력 ",
									"김하영");
							xmlName = xmlName + ".xml";
							SaveXml(xmlName);// 입력받은 정보로 xml파일 생성 및 저장
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
			setTitle("기록");
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

				field[0] = new JLabel("이름");
				field[0].setSize(300, 20);
				field[0].setLocation(50, 100);
				field[1] = new JLabel("단계");
				field[1].setSize(300, 20);
				field[1].setLocation(180, 100);
				field[2] = new JLabel("점수");
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
			setTitle("미운 오리 새끼");
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
						selectXmlBtn[i] = new JButton("기본 게임");
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
							if (btn.getText() == "기본 게임") { // block.xml
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