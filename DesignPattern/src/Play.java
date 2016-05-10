/*
  오후 10시가 되면 MP3를 작동시켜 음악을 연주하는 코드를 만들어야 한다. 하지만 이 코드가 제대로 작동하는지 테스트하려면 저녁 10시까지 기다려야 한다.
 OCP를 적용해 이 문제를 해결하는 코드를 작성하라.
  그리고 실제 MP3를 사용하기에는 테스트 시간이 길어지기 때문에, 이 또한 OCP를 적용해 코드를 작성하라.
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
		System.out.println("진짜MP3플레이어");
	}
}

class FakeMP3Provider implements MusicProvider{
	public void playSong(){
		System.out.println("가짜MP3플레이어");
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
		System.out.println("랄랄라");
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


