import java.awt.Font;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GameManager extends JFrame  {
	//Singleton - pattern
	private static GameManager Instance = null;
	public static GameManager Instance()
	{
		if(Instance == null) 
		{
			System.out.println("Null Instance Error");
		}
		
		return Instance;
	}
	
	//PADDINGS
	public static final int LEFT_PADDING = 3;
	public static final int RIGHT_PADDING = 20;
	
	//GAME AREA
	public static final int SCREEN_WIDTH = 80;
	public static final int SCREEN_HEIGHT = 25;

	private JTextArea textArea;
	private char[][] buffer;

	public GameManager() 
	{
		//JFrame 생성
		textArea = new JTextArea();
		
		//창 설정
		setTitle("Let's play Tetris");
		setSize(1300, 850);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // this will center your app textArea.setFont(new Font("Courier New", Font.PLAIN, 30)); add(textArea);
										
		textArea.setEditable(false);
		textArea.setFont(new Font("Courier", Font.PLAIN, 26));

		add(textArea);
		textArea.setEditable(false);
		setVisible(true);
		
		buffer = new char[SCREEN_WIDTH][SCREEN_HEIGHT];
		buffer = new char[SCREEN_WIDTH][SCREEN_HEIGHT];
		initData();
		
		Instance = this;
	}

	public void AttachKeyListener(KeyListener listener)
	{
		textArea.addKeyListener(listener);		
	}
	
	public void initData() {
		clearBuffer();
	}

	private void clearBuffer() {
		for (int y = 0; y < SCREEN_HEIGHT; y++) {
			for (int x = 0; x < SCREEN_WIDTH; x++) {
				if(x <= LEFT_PADDING) 
				{
					buffer[x][y] = '.';
				}
				else if(x > SCREEN_WIDTH - RIGHT_PADDING)
				{
					buffer[x][y] = '.';
				}
				else
				{
					buffer[x][y] = ' ';
				}
			}
		}
		
		DrawScoreBoard(250);
	}
	
	private void DrawScoreBoard(int score)
	{
		for(int i = 63; i < 78; ++i)
		{
			buffer[i][4] = '─';
			buffer[i][5] = ' ';
			buffer[i][6] = '─';
		}
		
		buffer[62][4] = '┌';
		buffer[62][5] = '│';
		buffer[62][6] = '└';
		
		buffer[78][4] = '┐';
		buffer[78][5] = '│';
		buffer[78][6] = '┘';
		
		drawToBuffer(64, 5, "Score: " + score);
	}

	public void drawToBuffer(int px, int py, String c) {
		for (int x = 0; x < c.length(); x++) {
			buffer[px + x][py] = c.charAt(x);
		}
	}

	public void drawToBuffer(int px, int py, char c) {
		buffer[px][py] = c;
	}

	public void drawAll() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < SCREEN_HEIGHT; y++) {
			for (int x = 0; x < SCREEN_WIDTH; x++) {
				sb.append(buffer[x][y]);
			}
			sb.append("\n");
		}
		textArea.setText(sb.toString());
		clearBuffer();
	}
}
