import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import java.awt.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
public class Catch extends JFrame implements Runnable, KeyListener {

   private BufferedImage bi = null;
   private ArrayList<Hand> handList = null;
   private ArrayList<DownBlock> downBlockList = null;
   private ArrayList<LoadDownBlock> loadDownBlockList = null;
   private ArrayList<Stage> stageList = null;
   private ArrayList<Score> scoreList = null;

   private ArrayList<GameItem> gameItemList = null;
   private ArrayList<Panel> panelList = null;
   private ArrayList<GameItem> GameItem = null;

   private int totalKcal = 0;
   private int totalScore = 0;
   private int heart = 3;
   private int time = 0;
   private int currentStage = 0;

   private int goalKcal;
   int cnt = 0; // 시작하면 타이머 한번만 실행 하려고
   Timer timer;
   Thread timerThread;
   UserXmlOpen uxo;
   private boolean left = false, right = false, extend = false;
   private boolean start = false, end = false;
   private int w = 1000, h = 820, x = 600, y = 650, xw = 20, xh = 20;

   public Catch(XmlOpen xo, ArrayList<Score> scoreList, String xmlName) {

      bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
      handList = new ArrayList<Hand>();
      downBlockList = new ArrayList<DownBlock>();
      this.scoreList = scoreList;

      uxo = new UserXmlOpen(xmlName);

      timer = new Timer();
      timerThread = new Thread(timer);

      loadDownBlockList = uxo.createBlockReader();

      gameItemList = xo.gameItemReader();
      panelList = xo.panelReader();
      stageList = uxo.StageReader();
      timer.setTime(stageList.get(currentStage).time);

      this.addKeyListener(this);
      this.setSize(w, h);
      this.setTitle("Catch Game");
      this.setResizable(false);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
   public void Play(String fileName)
      {
          try
          {
              AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
              Clip clip = AudioSystem.getClip();
              clip.stop();
              clip.open(ais);
              clip.start();
          }
          catch (Exception ex)
          {
          }
      }
   public void run() {
      try {
         int handCount = 0;
         int downBlockCount = 0;

         while (true) {
            Thread.sleep(10);

            if (start) {
               getTime();
               stageClear();

               // 떨어지는 아이템 생성 속도
               if (downBlockCount > 1000) {
                  downBlockCreate();
                  downBlockCount = 0;
               }
               // 미사일 생성할수 있는 속도
               if (handCount > 80) {
                  extendHand();
                  handCount = 0;
               }
               handCount += 10;
               downBlockCount += 10;
               keyControl();
               catchBlock();
               crashUser();

            }

            // 게임 종료시
            if (end) {
               timer.setTime(stageList.get(currentStage).time);

               dispose();
               new MainMenu();
               return;
               // gs.setColor(Color.red);
               // gs.setFont(new Font("고딕체", Font.BOLD, 30));
               // gs.drawString("G A M E  O V E R", 500, 250);
               // gs.drawString("다시 시작하려면 Enter키를 누르세요.", 500, 270);
            } else
               draw();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void extendHand() {
      if (extend) {
         if (handList.size() < 1) {
            Hand m = new Hand(this.x, this.y - 100, 10, 200);
            handList.add(m);
         }
      }
   }

   public void downBlockCreate() {
      Random rd = new Random();
      ArrayList<Integer> randomList = new ArrayList<Integer>();

      int ONE_TIME_PRINT = stageList.get(currentStage).blockNum; // 한번에 출력하는
      // 갯수 설정

      for (int i = 0; i < ONE_TIME_PRINT; i++) {
         double x[] = { 240, 320, 400, 480, 560, 640, 720, 800, 880 };

         while (randomList.size() < ONE_TIME_PRINT) {
            int j = rd.nextInt(x.length);

            if (randomList.contains(j))
               continue;

            else
               randomList.add(j);

         }

         double block_x = x[randomList.get(i)];
         double item_x = x[rd.nextInt(8)];
         int select_db = rd.nextInt(loadDownBlockList.size());
         int select_item = rd.nextInt(3);

         LoadDownBlock load_db = loadDownBlockList.get(select_db);
         GameItem gameItem = gameItemList.get(select_item);

         DownBlock db = new DownBlock((int) block_x, -60, load_db.img,
               load_db.kcal, load_db.blockType); // 랜덤으로 좌표 지정해서 블락 생성

         downBlockList.add(db);

         if (stageList.get(currentStage).item) // 아이템 true면 출력
         {
            DownBlock item = new DownBlock((int) item_x, -60, gameItem.img,
                  gameItem.itemType);
            if ((System.currentTimeMillis() / 2076) % 17 == 0) {
               downBlockList.add(item);
            }
         }
      }
   }

   public void crashUser() {
      Polygon p = null;

      for (int i = 0; i < downBlockList.size(); i++) {
         DownBlock db = (DownBlock) downBlockList.get(i);
         int[] xpoints = { x, (x + xw), (x + xw), x };
         int[] ypoints = { y, y, (y + xh), (y + xh) };
         p = new Polygon(xpoints, ypoints, 4); // 유저 넓이랑 높이 포함해서 다각형

         if (heart == 0) // 목숨 없으면
         {
            if (p.intersects((double) db.x, (double) db.y,
                  (double) db.w + 80, (double) db.h + 80)) // 유저와 아이템이 겹치면
            {
               
               downBlockList.remove(i); // 블락 제거
               totalKcal = 0;
               String name = JOptionPane.showInputDialog(
                     "목숨을 모두 잃으셨습니다.\n이름을 입력해주세요.", "홍길동");
               scoreList
                     .add(new Score(name, currentStage + 1, totalScore));
               new ScoreXmlCreate(scoreList);
               end = true;
               start = false;
            }

         } else // 목숨 있으면
         {
            if (p.intersects((double) db.x, (double) db.y,
                  (double) db.w + 80, (double) db.h + 80)) // 유저와 아이템이 겹치면
            {
               Play("dead.wav");
               downBlockList.remove(i); // 블락 제거
               heart--;
            }

         }

      }
   }

   public void catchBlock() {
      Polygon p = null;

      for (int i = 0; i < handList.size(); i++) {
         Hand h = (Hand) handList.get(i);
         for (int j = 0; j < downBlockList.size(); j++) {
            DownBlock db = (DownBlock) downBlockList.get(j);
            int[] xpoints = { h.x, (h.x + h.w), (h.x + h.w), h.x };
            int[] ypoints = { h.y, h.y, (h.y + h.h), (h.y + h.h) };
            p = new Polygon(xpoints, ypoints, 4); // 미사일 좌표로 다각형 생성해서
            // 그 미사일 좌표와 떨어지는 플락이
            // 겹치면
            if (p.intersects((double) db.x, (double) db.y,
                  (double) db.w + 80, (double) db.h + 80)) {
               handList.remove(i); // 미사일 제거
               downBlockList.remove(j); // 블락 제거

               if ((db.blockType).equals("food")) {
                  Play("eat.wav");
                  totalKcal += db.kcal; // 음식이면 칼로리 추가
                  totalScore += db.kcal;
               } else if ((db.blockType).equals("exercise")) {
                  Play("a.wav");
                  totalKcal -= db.kcal; // 운동 이면 칼로리 감소
                  totalScore += db.kcal;
                  if (totalKcal <= 0)
                     totalKcal = 0;
               } else if ((db.blockType).equals("resetKcal")) {
                  for (int k = 0; k < gameItemList.size(); k++) {
                     GameItem gt = gameItemList.get(k);
                     if (gt.itemType.equals("resetKcal"))
                        totalKcal = gt.resetKcal(totalKcal);
                  }
               } else if ((db.blockType).equals("heart")) {
                  for (int k = 0; k < gameItemList.size(); k++) {
                     GameItem gt = gameItemList.get(k);
                     if (gt.itemType.equals("heart"))
                        heart = gt.heart(heart); // heart
                  }
               }

               else if ((db.blockType).equals("addTime")) {
                  for (int k = 0; k < gameItemList.size(); k++) {
                     GameItem gt = gameItemList.get(k);
                     if (gt.itemType.equals("addTime")) {
                        gt.addTime(timer); // addTime함수로 바꾸기

                     }
                  }

               }
            }
         }
      }

   }

   public void getTime() {
      if (cnt++ == 0)
         timerThread.start();
      time = timer.getTime();
   }

   public void stageClear() {
      if (time == 0) {
         timer.setTime(0);
         if (totalKcal == stageList.get(currentStage).GKcal) {
            // 목표칼로리에 도달했을 때
            if ((currentStage + 1) == stageList.size()) {
               // 스테이지를 끝까지 도달했을 경우
               System.out.println(stageList.size());
               String name = JOptionPane.showInputDialog(
                     "스테이지를 모두 클리어하셨습니다.\n이름을 입력해주세요.", "홍길동");
               scoreList
                     .add(new Score(name, currentStage + 1, totalScore));
               new ScoreXmlCreate(scoreList);
               end = true;
               start = false;
               return;

            } else {
               int result = JOptionPane.showConfirmDialog(null,
                     "스테이지 클리어 ! 다음스테이지로 넘어갑니다 ", "Confirm",
                     JOptionPane.YES_NO_OPTION);
               if (result == JOptionPane.CLOSED_OPTION) {
                  // 예나 아니오 선택 없이 닫을경우
               } else if (result == JOptionPane.YES_OPTION) {
                  currentStage++;
                  timer.setTime(stageList.get(currentStage).time);
                  totalKcal = 0;

                  for (int i = 0; i < downBlockList.size(); i++) {
                     DownBlock db = (DownBlock) downBlockList.get(i);
                     downBlockList.remove(i);
                  }

                  // 예를 눌렀을 경우
               } else
                  ;
               // 아니오 눌렀을 경우

            }

         } // 목표칼로리에 도달하지못하였을때
         else {
            String name = JOptionPane.showInputDialog(
                  "게임이 종료되었습니다.\n목표를 달성하지 못하였습니다.\n이름을 입력해주세요. ", "홍길동");
            scoreList.add(new Score(name, currentStage + 1, totalScore));
            new ScoreXmlCreate(scoreList);
            end = true;
            start = false;
            totalKcal = 0;
         }
      }
   }

   public void draw() {
      
      Graphics gs = bi.getGraphics();
      // Panel
      Panel user = panelList.get(0);
      Panel itemPan = panelList.get(1);
      Panel kcalPan = panelList.get(2);
      Panel missionPan = panelList.get(3);
      Panel bgLeftPan = panelList.get(4);
      Panel timePan = panelList.get(5);
      // 오른쪽 배경
      gs.setColor(Color.white);
      gs.fillRect(200, 0, w, h);

      // Panel
      gs.drawImage(itemPan.img, itemPan.x, itemPan.y, itemPan.w, itemPan.h,
            this);
      gs.drawImage(kcalPan.img, kcalPan.x, kcalPan.y, kcalPan.w, kcalPan.h,
            this);
      gs.drawImage(missionPan.img, missionPan.x, missionPan.y, missionPan.w,
            missionPan.h, this);
      gs.drawImage(bgLeftPan.img, bgLeftPan.x, bgLeftPan.y, bgLeftPan.w,
            bgLeftPan.h, this);
      gs.drawImage(timePan.img, timePan.x, timePan.y, timePan.w, timePan.h,
            this);

      // user Icon 생성
      gs.drawImage(user.img, x, y, user.w, user.h, this);

      // 현재 섭취 칼로리
      gs.setColor(Color.black);
      gs.setFont(new Font("고딕체", Font.BOLD, 20));
      gs.drawString(" " + totalKcal, 50, 550);

      // 현재 스테이지
      gs.setColor(Color.black);
      gs.setFont(new Font("고딕체", Font.BOLD, 15));
      gs.drawString("현재 스테이지 : " + (currentStage + 1), 20, 270);

      // 목표 칼로리
      gs.setColor(Color.black);
      gs.setFont(new Font("고딕체", Font.BOLD, 25));
      gs.drawString(" " + stageList.get(currentStage).GKcal, 50, 320);

      // 제한 시간
      gs.setColor(Color.black);
      gs.setFont(new Font("고딕체", Font.BOLD, 30));
      gs.drawString("00 : " + Integer.toString(time), 50, 160);
      

      // 칼로리 바
      //gs.setColor(Color.white);
      //gs.fillRect(10, 350, 170, 50); 
      if (totalKcal > stageList.get(currentStage).GKcal){
         gs.setColor(Color.RED);
         gs.fillRect(15, 350, 150, 50);
      }
      else{
         gs.setColor(new Color(192,255,0));
         gs.fillRect(15, 350, (totalKcal * 150) / stageList.get(currentStage).GKcal, 50);
      }
      
      // heart
      int hw = 10;
      for (int i = 0; i < heart; i++) {
         gs.drawImage(gameItemList.get(1).img, hw, 20, 50, 50, this);
         hw += 60;

      }
      //발사중이면 좌우 false
      if(handList.size()>0)
      {
         left=false;
         right =false;
      }
      // 미사일
      for (int i = 0; i < handList.size(); i++) {

         Hand h = (Hand) handList.get(i);
         ImageIcon ii = new ImageIcon("longArm.png");
         Image img = ii.getImage();
         gs.drawImage(img,h.x+5,h.y,h.w,h.h,this);
         //gs.setColor(Color.red);
         //gs.fillOval(h.x, h.y, h.w, h.h);
         

         if(h.y<100)
         {
           //while(h.h>10){
           ///    h.downHand();
           //} 
            handList.remove(i);
        } 
         else
            h.moveHand();
 
         
         
         
         
         
         
         
         // if (h.y < 100)
         //    handList.remove(i);
      }
      ArrayList<Integer> dv = new ArrayList<Integer>();
      for (int i = 0; i < downBlockList.size(); i++) {
         DownBlock db = downBlockList.get(i);
         gs.drawImage(db.img, db.x, db.y, 80, 80, this);

         if (!dv.contains(db.x)) {
            dv.add(db.x);
            gs.drawImage(db.img, db.x, db.y, 80, 80, this);
         } else

            continue;

         if (db.y > h)
            downBlockList.remove(i);

         db.moveBlock(stageList.get(currentStage).speed);
      }

      Graphics ge = this.getGraphics();
      ge.drawImage(bi, 0, 0, w, h, this);
   }

   public void keyControl() {
      if (200 < x) {
         if (left)
            x -= 3;
      }
      if (w > x + xw) {
         if (right)
            x += 3;
      }
   }

   public void keyPressed(KeyEvent ke) {
      switch (ke.getKeyCode()) {
      case KeyEvent.VK_LEFT:
         if (handList.size() != 1)
            left = true;
         break;
      case KeyEvent.VK_RIGHT:
         if (handList.size() != 1)
            right = true;
         break;
      case KeyEvent.VK_SPACE:
         extend = true;
         break;
      case KeyEvent.VK_ENTER:
         start = true;
         end = false;
         break;
      }
   }

   public void keyReleased(KeyEvent ke) {
      switch (ke.getKeyCode()) {
      case KeyEvent.VK_LEFT:
         left = false;
         break;
      case KeyEvent.VK_RIGHT:

         right = false;
         break;
      case KeyEvent.VK_SPACE:
         extend = false;
         break;
      }
   }

   public void keyTyped(KeyEvent ke) {
   }

   public static void main(String[] args) {

   }
}