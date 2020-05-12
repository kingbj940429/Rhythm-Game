package dynamic_beat_16;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{//Thread는 프로그램 안에 작은 프로그램
	
	private Player player;//다운받은 라이브러리 중 하나
	private boolean isLoop;//무한반복되는지 아닌지
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop=isLoop;
			file=new File(Main.class.getResource("../music/"+name).toURI());
			fis=new FileInputStream(file);
			bis=new BufferedInputStream(fis);
			player=new Player(bis);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if(player==null)
			return 0;
		return player.getPosition();
	}
	public void close() {//언제든지 음악이 종류될수 있게 해줌.
		isLoop=false;
		player.close();
		this.interrupt();//해당 Thread를 중단시켜줌.
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();//음악을 실행시킴
				fis=new FileInputStream(file);
				bis=new BufferedInputStream(fis);
				player=new Player(bis);
			}while(isLoop);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
