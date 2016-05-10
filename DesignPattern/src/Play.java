/*
  ���� 10�ð� �Ǹ� MP3�� �۵����� ������ �����ϴ� �ڵ带 ������ �Ѵ�. ������ �� �ڵ尡 ����� �۵��ϴ��� �׽�Ʈ�Ϸ��� ���� 10�ñ��� ��ٷ��� �Ѵ�.
 OCP�� ������ �� ������ �ذ��ϴ� �ڵ带 �ۼ��϶�.
  �׸��� ���� MP3�� ����ϱ⿡�� �׽�Ʈ �ð��� ������� ������, �� ���� OCP�� ������ �ڵ带 �ۼ��϶�.
 */
import java.util.Calendar;

interface TimeProvider{
	public void setHours(int hours);
	public int getTime();
}

class FakeTimeProvider implements TimeProvider{
	private Calendar cal;
	public FakeTimeProvider(){
		cal = Calendar.getInstance();
	}
	public FakeTimeProvider(int hours){
		cal = Calendar.getInstance();
		setHours(hours);
	}
	
	public void setHours(int hours){
		cal.set(Calendar.HOUR_OF_DAY, hours);
	}
	
	public int getTime(){
		return cal.get(Calendar.HOUR_OF_DAY);
	}
}

class TimeReminder{
	TimeProvider tProv;
	public void setTimeProvider(TimeProvider tProv){
		this.tProv = tProv;
	}
	
	public void reminder(MusicProvider m){
		int hours = tProv.getTime();
		if(hours >= 22){
			m.playSong();
		}
	}
}

interface MusicProvider{
	public void playSong();
}

class RealMP3Provider implements MusicProvider{
	public void playSong(){
		System.out.println("��¥MP3�÷��̾�");
	}
}

class FakeMP3Provider implements MusicProvider{
	public void playSong(){
		System.out.println("��¥MP3�÷��̾�");
	}
}

class MusicReminder{
	MusicProvider mp;
	public void setMusicProvider(MusicProvider mp){
		this.mp = mp;
	}
}

class MP3 {
	public void playSong(){
		System.out.println("������");
	}
}

public class Play{
	public static void main(String[] args){
		MusicReminder mr = new MusicReminder();
		MusicProvider mp = new FakeMP3Provider();
		mr.setMusicProvider(mp);
		
		
		TimeReminder sut = new TimeReminder();
		TimeProvider tProvStub = new FakeTimeProvider();
		
		
		tProvStub.setHours(23);
		sut.setTimeProvider(tProvStub);
		sut.reminder(mp);
	}
}


