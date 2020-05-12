package dynamic_beat_16;

public class Track {

	private String titleImage;//제목 부분 이미지
	private String startImage;//게임 선택 창 표지 이미지
	private String gameImage;//해당 곡을 실행했을 때 표지 이미지
	private String startMusic;//게임 선택 창 음악
	private String gameMusic;//해당 곡을 실행했을 때 음악
	private String titleName;
	//오른쪽 source에서 getter setter 있는거 누르면 아래 알아서 생김
	//가장 밑에 Track 부분은 source에서 constructor using field 누르면 됨
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic,String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}
	
	
	
}
