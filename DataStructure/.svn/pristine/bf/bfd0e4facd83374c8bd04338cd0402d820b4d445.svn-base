package 설계패턴_과제3;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class BackRunning implements RunningStrategy{

	@Override
	public void run(JLabel lbl) {

		lbl.setIcon(new ImageIcon("./src/back1.png"));
		while (true) {
			String[] path = getImages();
			for (int i = 0; i < path.length; i++) {
				lbl.setIcon(new ImageIcon("./src/" + path[i]));
				int x = lbl.getX();
				int y = lbl.getY();
				
				lbl.setLocation(x+5,y);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
				if(lbl.getLocation().x > 600){
					lbl.setLocation(610,y);
					stop();
					
					break;
				}
				
			}
		}
		
		
	}
	public void stop(){
		Thread.interrupted();
	}
	public String[] getImages() {
		return ImageService.BackRunningImage;
	}
}
