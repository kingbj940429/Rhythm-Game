package dynamic_beat_16;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{//Thread�� ���α׷� �ȿ� ���� ���α׷�
	
	private Player player;//�ٿ���� ���̺귯�� �� �ϳ�
	private boolean isLoop;//���ѹݺ��Ǵ��� �ƴ���
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
	public void close() {//�������� ������ �����ɼ� �ְ� ����.
		isLoop=false;
		player.close();
		this.interrupt();//�ش� Thread�� �ߴܽ�����.
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();//������ �����Ŵ
				fis=new FileInputStream(file);
				bis=new BufferedInputStream(fis);
				player=new Player(bis);
			}while(isLoop);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
