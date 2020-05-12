package dynamic_beat_16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import dynamic_beat_17.Beat;
import dynamic_beat_17.Main;

public class Game extends Thread {// 쓰레드는 작은 게임속 단위

	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	private Image keyPadSImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private int score=0;
	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage=new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if (!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
			note.screenDraw(g);
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(""+score, 565, 702);
//		g.drawImage(blueFlareImage,320,430,null);
		g.drawImage(judgeImage,600,300,null);
//		g.drawImage(keyPadSImage,228,580,null);
//		g.drawImage(keyPadDImage,332,580,null);
//		g.drawImage(keyPadFImage,436,580,null);
//		g.drawImage(keyPadSpace1Image,440,580,null);
//		g.drawImage(keyPadSpace2Image,640,580,null);
//		g.drawImage(keyPadJImage,774,580,null);
//		g.drawImage(keyPadKImage,848,580,null);
//		g.drawImage(keyPadLImage,952,580,null);
		
	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	//	keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig3.mp3", false).start();// false로 인해 반복하지 않음
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	//	keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	//	keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig2.mp3", false).start();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	//	keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	//	keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig2.mp3", false).start();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	//	keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	//	keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	//	keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		//keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		//keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	//	keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig2.mp3", false).start();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	//	keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	//	keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig2.mp3", false).start();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
//		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
//		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig3.mp3", false).start();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
//		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if (titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 300;// 박자 때문에
			beats = new Beat[] { new Beat(startTime, "S"),
					new Beat(startTime + gap * 3, "S"), new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "S"), new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"), new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 16, "S"), new Beat(startTime + gap * 18, "D"),
					new Beat(startTime + gap * 20, "S"), new Beat(startTime + gap * 22, "D"),
					new Beat(startTime + gap * 24, "Space"), new Beat(startTime + gap * 24, "Space"),
					new Beat(startTime + gap * 28, "K"), new Beat(startTime + gap * 30, "L"),
					new Beat(startTime + gap * 32, "K"), new Beat(startTime + gap * 34, "L"),
					new Beat(startTime + gap * 36, "K"), new Beat(startTime + gap * 38, "L"),
					new Beat(startTime + gap * 40, "K"), new Beat(startTime + gap * 42, "L"),
					new Beat(startTime + gap * 44, "S"), new Beat(startTime + gap * 46, "D"),
					new Beat(startTime + gap * 48, "F"), new Beat(startTime + gap * 50, "Space"),
					new Beat(startTime + gap * 52, "J"), new Beat(startTime + gap * 54, "K"),
					new Beat(startTime + gap * 56, "L"), new Beat(startTime + gap * 58, "K"),
					new Beat(startTime + gap * 60, "J"), new Beat(startTime + gap * 62, "Space"),
					new Beat(startTime + gap * 64, "F"), new Beat(startTime + gap * 66, "D"),
					new Beat(startTime + gap * 68, "S"), new Beat(startTime + gap * 70, "D"),
					new Beat(startTime + gap * 72, "S"), new Beat(startTime + gap * 74, "D"),
					new Beat(startTime + gap * 76, "S"), new Beat(startTime + gap * 78, "D"),
					new Beat(startTime + gap * 80, "S"), new Beat(startTime + gap * 82, "D"),
					new Beat(startTime + gap * 84, "S"), new Beat(startTime + gap * 86, "D"),
					new Beat(startTime + gap * 88, "S"), new Beat(startTime + gap * 90, "D"),
					new Beat(startTime + gap * 92, "Space"), new Beat(startTime + gap * 94, "Space"),
					new Beat(startTime + gap * 96, "K"), new Beat(startTime + gap * 98, "L"),
					new Beat(startTime + gap * 100, "K"), new Beat(startTime + gap * 102, "L"),
					new Beat(startTime + gap * 104, "K"), new Beat(startTime + gap * 106, "L"),
					new Beat(startTime + gap * 108, "K"), new Beat(startTime + gap * 110, "L"),
					new Beat(startTime + gap * 112, "S"), new Beat(startTime + gap * 114, "D"),
					new Beat(startTime + gap * 116, "F"), new Beat(startTime + gap * 118, "Space"),
					new Beat(startTime + gap * 120, "J"), new Beat(startTime + gap * 122, "K"),
					new Beat(startTime + gap * 124, "L"), new Beat(startTime + gap * 126, "K"),
					new Beat(startTime + gap * 128, "J"), new Beat(startTime + gap * 130, "Space"),
					new Beat(startTime + gap * 132, "F"), new Beat(startTime + gap * 134, "D"),
					new Beat(startTime + gap * 136, "S"), new Beat(startTime + gap * 138, "D"),
					new Beat(startTime + gap * 140, "S"), new Beat(startTime + gap * 142, "D"),
					new Beat(startTime + gap * 144, "S"), new Beat(startTime + gap * 146, "D"),
					new Beat(startTime + gap * 148, "S"), new Beat(startTime + gap * 150, "D"),
					new Beat(startTime + gap * 152, "S"), new Beat(startTime + gap * 154, "D"),
					new Beat(startTime + gap * 156, "S"), new Beat(startTime + gap * 158, "D"),
					new Beat(startTime + gap * 160, "Space"), new Beat(startTime + gap * 162, "Space"),
					new Beat(startTime + gap * 164, "K"), new Beat(startTime + gap * 166, "L"),
					new Beat(startTime + gap * 168, "K"), new Beat(startTime + gap * 170, "L"),
					new Beat(startTime + gap * 172, "K"), new Beat(startTime + gap * 174, "L"),
					new Beat(startTime + gap * 176, "K"), new Beat(startTime + gap * 178, "L"),
					new Beat(startTime + gap * 180, "S"), new Beat(startTime + gap * 182, "D"),
					new Beat(startTime + gap * 184, "F"), new Beat(startTime + gap * 186, "Space"),
					new Beat(startTime + gap * 188, "J"), new Beat(startTime + gap * 190, "K"),
					new Beat(startTime + gap * 192, "L"), new Beat(startTime + gap * 194, "K"),
					new Beat(startTime + gap * 196, "J"), new Beat(startTime + gap * 198, "Space"),
					new Beat(startTime + gap * 200, "F"), new Beat(startTime + gap * 202, "D"),
					new Beat(startTime + gap * 204, "S"), new Beat(startTime + gap * 206, "D"),
					new Beat(startTime + gap * 208, "S"), new Beat(startTime + gap * 210, "D"),
					new Beat(startTime + gap * 212, "S"), new Beat(startTime + gap * 214, "D"),
					new Beat(startTime + gap * 216, "S"), new Beat(startTime + gap * 218, "D"),
					new Beat(startTime + gap * 220, "S"), new Beat(startTime + gap * 222, "D"),
					new Beat(startTime + gap * 224, "S"), new Beat(startTime + gap * 226, "D"),
					new Beat(startTime + gap * 228, "Space"), new Beat(startTime + gap * 230, "Space"),
					new Beat(startTime + gap * 232, "K"), new Beat(startTime + gap * 234, "L"),
					new Beat(startTime + gap * 236, "K"), new Beat(startTime + gap * 238, "L"),
					new Beat(startTime + gap * 240, "K"), new Beat(startTime + gap * 242, "L"),
					new Beat(startTime + gap * 244, "K"), new Beat(startTime + gap * 246, "L"),
					new Beat(startTime + gap * 248, "S"), new Beat(startTime + gap * 250, "D"),
					new Beat(startTime + gap * 252, "F"), new Beat(startTime + gap * 254, "Space"),
					new Beat(startTime + gap * 256, "J"), new Beat(startTime + gap * 258, "K"),
					new Beat(startTime + gap * 260, "L"), new Beat(startTime + gap * 262, "K"),
					new Beat(startTime + gap * 264, "J"), new Beat(startTime + gap * 266, "Space"),
					new Beat(startTime + gap * 268, "F"), new Beat(startTime + gap * 270, "D"),
					new Beat(startTime + gap * 272, "S"), new Beat(startTime + gap * 274, "D"),
					
			};
		} else if (titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Hard")) {
			int startTime = 1000;
			int gap=100;
			beats = new Beat[] { new Beat(startTime, "Space"),
					new Beat(startTime + gap * 3, "S"), new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "S"), new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"), new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 16, "S"), new Beat(startTime + gap * 18, "D"),
					new Beat(startTime + gap * 20, "S"), new Beat(startTime + gap * 22, "D"),
					new Beat(startTime + gap * 24, "Space"), new Beat(startTime + gap * 24, "Space"),
					new Beat(startTime + gap * 28, "K"), new Beat(startTime + gap * 30, "L"),
					new Beat(startTime + gap * 32, "K"), new Beat(startTime + gap * 34, "L"),
					new Beat(startTime + gap * 36, "K"), new Beat(startTime + gap * 38, "L"),
					new Beat(startTime + gap * 40, "K"), new Beat(startTime + gap * 42, "L"),
					new Beat(startTime + gap * 44, "S"), new Beat(startTime + gap * 46, "D"),
					new Beat(startTime + gap * 48, "F"), new Beat(startTime + gap * 50, "Space"),
					new Beat(startTime + gap * 52, "J"), new Beat(startTime + gap * 54, "K"),
					new Beat(startTime + gap * 56, "L"), new Beat(startTime + gap * 58, "K"),
					new Beat(startTime + gap * 60, "J"), new Beat(startTime + gap * 62, "Space"),
					new Beat(startTime + gap * 64, "F"), new Beat(startTime + gap * 66, "D"),
					new Beat(startTime + gap * 68, "S"), new Beat(startTime + gap * 70, "D"),
					new Beat(startTime + gap * 72, "S"), new Beat(startTime + gap * 74, "D"),
					new Beat(startTime + gap * 76, "S"), new Beat(startTime + gap * 78, "D"),
					new Beat(startTime + gap * 80, "S"), new Beat(startTime + gap * 82, "D"),
					new Beat(startTime + gap * 84, "S"), new Beat(startTime + gap * 86, "D"),
					new Beat(startTime + gap * 88, "S"), new Beat(startTime + gap * 90, "D"),
					new Beat(startTime + gap * 92, "Space"), new Beat(startTime + gap * 94, "Space"),
					new Beat(startTime + gap * 96, "K"), new Beat(startTime + gap * 98, "L"),
					new Beat(startTime + gap * 100, "K"), new Beat(startTime + gap * 102, "L"),
					new Beat(startTime + gap * 104, "K"), new Beat(startTime + gap * 106, "L"),
					new Beat(startTime + gap * 108, "K"), new Beat(startTime + gap * 110, "L"),
					new Beat(startTime + gap * 112, "S"), new Beat(startTime + gap * 114, "D"),
					new Beat(startTime + gap * 116, "F"), new Beat(startTime + gap * 118, "Space"),
					new Beat(startTime + gap * 120, "J"), new Beat(startTime + gap * 122, "K"),
					new Beat(startTime + gap * 124, "L"), new Beat(startTime + gap * 126, "K"),
					new Beat(startTime + gap * 128, "J"), new Beat(startTime + gap * 130, "Space"),
					new Beat(startTime + gap * 132, "F"), new Beat(startTime + gap * 134, "D"),
					new Beat(startTime + gap * 136, "S"), new Beat(startTime + gap * 138, "D"),
					new Beat(startTime + gap * 140, "S"), new Beat(startTime + gap * 142, "D"),
					new Beat(startTime + gap * 144, "S"), new Beat(startTime + gap * 146, "D"),
					new Beat(startTime + gap * 148, "S"), new Beat(startTime + gap * 150, "D"),
					new Beat(startTime + gap * 152, "S"), new Beat(startTime + gap * 154, "D"),
					new Beat(startTime + gap * 156, "S"), new Beat(startTime + gap * 158, "D"),
					new Beat(startTime + gap * 160, "Space"), new Beat(startTime + gap * 162, "Space"),
					new Beat(startTime + gap * 164, "K"), new Beat(startTime + gap * 166, "L"),
					new Beat(startTime + gap * 168, "K"), new Beat(startTime + gap * 170, "L"),
					new Beat(startTime + gap * 172, "K"), new Beat(startTime + gap * 174, "L"),
					new Beat(startTime + gap * 176, "K"), new Beat(startTime + gap * 178, "L"),
					new Beat(startTime + gap * 180, "S"), new Beat(startTime + gap * 182, "D"),
					new Beat(startTime + gap * 184, "F"), new Beat(startTime + gap * 186, "Space"),
					new Beat(startTime + gap * 188, "J"), new Beat(startTime + gap * 190, "K"),
					new Beat(startTime + gap * 192, "L"), new Beat(startTime + gap * 194, "K"),
					new Beat(startTime + gap * 196, "J"), new Beat(startTime + gap * 198, "Space"),
					new Beat(startTime + gap * 200, "F"), new Beat(startTime + gap * 202, "D"),
					new Beat(startTime + gap * 204, "S"), new Beat(startTime + gap * 206, "D"),
					new Beat(startTime + gap * 208, "S"), new Beat(startTime + gap * 210, "D"),
					new Beat(startTime + gap * 212, "S"), new Beat(startTime + gap * 214, "D"),
					new Beat(startTime + gap * 216, "S"), new Beat(startTime + gap * 218, "D"),
					new Beat(startTime + gap * 220, "S"), new Beat(startTime + gap * 222, "D"),
					new Beat(startTime + gap * 224, "S"), new Beat(startTime + gap * 226, "D"),
					new Beat(startTime + gap * 228, "Space"), new Beat(startTime + gap * 230, "Space"),
					new Beat(startTime + gap * 232, "K"), new Beat(startTime + gap * 234, "L"),
					new Beat(startTime + gap * 236, "K"), new Beat(startTime + gap * 238, "L"),
					new Beat(startTime + gap * 240, "K"), new Beat(startTime + gap * 242, "L"),
					new Beat(startTime + gap * 244, "K"), new Beat(startTime + gap * 246, "L"),
					new Beat(startTime + gap * 248, "S"), new Beat(startTime + gap * 250, "D"),
					new Beat(startTime + gap * 252, "F"), new Beat(startTime + gap * 254, "Space"),
					new Beat(startTime + gap * 256, "J"), new Beat(startTime + gap * 258, "K"),
					new Beat(startTime + gap * 260, "L"), new Beat(startTime + gap * 262, "K"),
					new Beat(startTime + gap * 264, "J"), new Beat(startTime + gap * 266, "Space"),
					new Beat(startTime + gap * 268, "F"), new Beat(startTime + gap * 270, "D"),
					new Beat(startTime + gap * 272, "S"), new Beat(startTime + gap * 274, "D"),
					};
		} else if (titleName.equals("Bendsound - Energy") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"), };
		} else if (titleName.equals("Bendsound - Energy") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"), };
		} else if (titleName.equals("Joakim Karud - Wild Flower") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"), };
		} else if (titleName.equals("Joakim Karud - Wild Flower") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"), };
		}
		int i = 0;
		gameMusic.start();
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
 
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage=new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
			score=score+0;
		}
		if(judge.equals("Miss")) {
			judgeImage=new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			score=score+0;
		}
		else if(judge.equals("Late")) {
			judgeImage=new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
			score=score+10;
		}
		else if(judge.equals("Good")) {
			judgeImage=new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
			score=score+30;
		}
		else if(judge.equals("Great")) {
			judgeImage=new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
			score=score+80;
		}
		else if(judge.equals("Perfect")) {
			judgeImage=new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
			
			score=score+150;
		}
		else if(judge.equals("Early")) {
			judgeImage=new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
			score=score+10;
		}
		
	}
}
