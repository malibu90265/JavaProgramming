import java.awt.Image;
class Hand {
   int x;
   int y;
   int w;
   int h;

   public Hand(int x, int y,int w, int h) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
   }

   public void moveHand() {
      h+=10;
      y-=10;
      
   }
   public void downHand()
   {
      h-=10;
      y+=10;
   }
}

class LoadDownBlock {
   Image img;
   int kcal;
   String blockType;
   String imgName;

   public LoadDownBlock(Image img, int kcal, String blockType, String imgName) {
      this.img = img;
      this.kcal = kcal;
      this.blockType = blockType;
      this.imgName = imgName;
   }

}

class DownBlock {
   int x;
   int y;
   int w = 10;
   int h = 10;
   Image img;
   int kcal;
   String blockType;

   public DownBlock(int x, int y, Image img, String itemType) {
      this.x = x;
      this.y = y;
      this.img = img;
      this.blockType = itemType;

   }

   public DownBlock(int x, int y, Image img, int kcal, String blockType) {
      this.x = x;
      this.y = y;
      this.img = img;
      this.kcal = kcal;
      this.blockType = blockType;
   }

   public void moveBlock(int speed) {
      y = y + speed; // 떨어지는 속도
      // 스테이지별로 속도 조정
   }
}

class Panel {
   int x;
   int y;
   int w;
   int h;
   Image img;

   Panel(int x, int y, int w, int h, Image img) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.img = img;

   }

}

class GameItem {
   Image img;
   String itemType;

   GameItem(Image img, String itemType) {
      this.img = img;
      this.itemType = itemType;
   }

   public int resetKcal(int TotalKcal)// 현재 섭취 칼로리를 0으로
   {
      TotalKcal = 0;
      return TotalKcal;
   }

   public int heart(int heart) {
      if (heart == 3) // 꽉차있으면 3개 그대로
         return heart;
      else
         return ++heart;
   }

   public void addTime(Timer timer) {
      timer.addTime();
   }
}


class Timer extends Thread {
   int time = 30;

   public void run() {
      while (true) {
         try {
            sleep(1000);
            --time;
         } catch (InterruptedException e) {
            return;
         }
      }
   }

   public int getTime() {
      return time;
   }

   public void setTime(int time) {
      this.time = time;
   }

   public void addTime() {
      time += 10;
   }
}