package CoinEat;
//AWT란 자바내의 그래픽 프로그램을 만들기위한 라이브러리 추상 윈도우 개발도구
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CoinEat extends JFrame{ // JFrame을 상속해야 사용가능
	private Image backgroundImage = new ImageIcon("src/Images/mainScreen.png").getImage();
	private Image player = new ImageIcon("src/Images/player.png").getImage();
	private Image coin = new ImageIcon("src/Images/coin.png").getImage(); //사진추가
	
	private int playerX, playerY; //플레이어의 좌표로 사용할 playerX, playerY 선언
	private int playerWidth = player.getWidth(null); //나중에 플레이어와 코인 충돌여부를 판단하기 위해 각이미지의 크기도 변수에
	private int playerHeight = player.getHeight(null);
	
	private int coinX, coinY; //코인의 좌표로 사용할 coinX, coinY 선언
	private int coinWidth = player.getWidth(null); //나중에 플레이어와 코인 충돌여부를 판단하기 위해 각이미지의 크기도 변수에
	private int coinHeight = player.getHeight(null);
	
	
	private int score; //점수를 담을 변수
	
	public CoinEat() { //기본생성자
		setTitle("동전먹기게임"); //제목
		setVisible(true); //보이기 여부
		setSize(500, 500); //창크기
		setLocationRelativeTo(null); //실행시 창이 화면 가운데에 뜨게됩니다
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을 닫을시 프로세스도 종료
		Init();
	}
	 public void Init() { //게임을 시작할때 초기화해줄 메소드
		 score = 0; //점수 0
		 playerX = (500 - playerWidth)/2; //플레이어를 정중앙
		 playerY = (500-playerHeight)/2;
		 
		 coinX = (int)(Math.random()*(501-playerWidth)); //코인의 위치는 랜덤, 창의크기를 +1 해주고 이미지의 길이를 뺴준다
		 coinY = (int)(Math.random()*(501-playerHeight+30)-30); //프레임 틀의길이를 생각하여 30을 빼준다
		 
	 }
	public void paint(Graphics g) { //이미지를 출력해줄 paint 메소드 //참조형매개변수
		g.drawImage(backgroundImage, 0, 0, null); //이미지, 그릴 X좌표, Y좌표, null(
		g.drawImage(coin, coinX, coinY, null);
		g.drawImage(player, playerX, playerY, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("SCORE : "+score, 30, 80); //(출력 문자, x좌표, y좌표 coinY 와 마찬가지로 프레임틀 길이를 생각해 Y좌표를크게
		
	}
	public static void main(String[] args) {
		new CoinEat(); //객체를 생성함으로써 생성자 호출
		
	}

}
