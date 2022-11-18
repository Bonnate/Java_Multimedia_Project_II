package Framework;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class GameManager extends JFrame {
	// Singleton - pattern
	private static GameManager Instance = null;

	public static GameManager Instance() {
		if (Instance == null) {
			System.out.println("Null Instance Error");
		}

		return Instance;
	}

	// PADDINGS
	public static final int LEFT_PADDING = 3;
	public static final int RIGHT_PADDING = 20;

	// GAME AREA
	public static final int SCREEN_WIDTH = 80;
	public static final int SCREEN_HEIGHT = 25;
	private JTextArea textArea;
	private char[][] buffer;

	// GAME DATA
	private int mScore;
	private String mEndingMessage;
	
	private JPanel contentPane;

	public GameManager() {
		
		setTitle("CardLayout 사용하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);

//		contentPane.add(new JLabel("오른쪽 입니다"));
		
		setVisible(true);
		
		
//		// JFrame 생성
//		textArea = new JTextArea();
//
//		// 창 설정
//		setTitle("SPACE INVADER");
//		setSize(1300, 850);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);

//		textArea.setEditable(false);
		
 		//textArea.setFont(new Font("Courier", Font.PLAIN, 26)); //Mac OS
//		textArea.setFont(new Font("Courier New", Font.PLAIN, 26)); //윈도우 OS

//		add(textArea);
//		textArea.setEditable(false);
//		setVisible(true);

//		buffer = new char[SCREEN_WIDTH][SCREEN_HEIGHT];
//		buffer = new char[SCREEN_WIDTH][SCREEN_HEIGHT];
//		ClearBuffer();

		// 인스턴스 등록
		Instance = this;

		// 점수 초기화
		mScore = 0;
	}

	// GAME SYSTEM
	/**
	 * 점수를 변경시킨다 value값에 따라 점수가 오르거나, 떨어질 수 있다.
	 * 
	 * @param value 추가하거나 뺄 점수, value > 0 이면 점수가 오른다.
	 */
	public void ModifyScore(int value) {
		mScore += value;

		if (mScore >= 80) {
			StopGame(true);
		}
	}

	public void SetScore(int value) {
		mScore = value;
	}
	
	public void AddSprite(JLabel label)
	{
		contentPane.add(label);  
	}

	// INPUT

	/** 키 리스너를 등록한다 */
	public void AttachKeyListener(KeyListener listener) {
		contentPane.addKeyListener(listener);
	}

	public void StopGame(boolean isWin) {
		mEndingMessage = isWin ? "You Win!!!" : "You Lose!!";
		Time.Scale = 0;
	}

//	// DRAW
//	private void ClearBuffer() {
//		for (int y = 0; y < SCREEN_HEIGHT; y++) {
//			for (int x = 0; x < SCREEN_WIDTH; x++) {
//				if (x <= LEFT_PADDING) {
//					buffer[x][y] = '.';
//				} else if (x > SCREEN_WIDTH - RIGHT_PADDING) {
//					buffer[x][y] = '.';
//				} else {
//					buffer[x][y] = ' ';
//				}
//			}
//		}
//
//		DrawScoreBoard();
//	}
//
//	private void DrawScoreBoard() {
//		for (int i = 63; i < 78; ++i) {
//			buffer[i][4] = '─';
//			buffer[i][5] = ' ';
//			buffer[i][6] = '─';
//		}
//
//		buffer[62][4] = '┌';
//		buffer[62][5] = '│';
//		buffer[62][6] = '└';
//
//		buffer[78][4] = '┐';
//		buffer[78][5] = '│';
//		buffer[78][6] = '┘';
//
//		DrawToBuffer(64, 5, "Score: " + mScore);
//	}
//
//	public void DrawMenu() {
//		for (int i = 20; i < 42; ++i) {
//			buffer[i][10] = '─';
//			buffer[i][11] = ' ';
//			buffer[i][12] = ' ';
//			buffer[i][13] = ' ';
//			buffer[i][14] = ' ';
//			buffer[i][15] = '─';
//		}
//
//		for (int i = 11; i < 15; ++i) {
//			buffer[20][i] = '│';
//			buffer[42][i] = '│';
//		}
//
//		buffer[20][10] = '┌';
//		buffer[20][15] = '└';
//
//		buffer[42][10] = '┐';
//		buffer[42][15] = '┘';
//
//		DrawToBuffer(27, 11, mEndingMessage);
//		DrawToBuffer(21, 14, "Play Again? ( Y / N )");
//	}
//
//	public void DrawToBuffer(int px, int py, String c) {
//		for (int x = 0; x < c.length(); x++) {
//			buffer[px + x][py] = c.charAt(x);
//		}
//	}
//
//	public void DrawToBuffer(int px, int py, char c) {
//		buffer[px][py] = c;
//	}
//
//	public void DrawToBuffer(int px, int py, int length, char c) {
//		for (int i = 0; i < length; ++i) {
//			buffer[px + i][py] = c;
//		}
//	}
//
//	public void Render() {
//		if (Time.Scale == 0) {
//			DrawMenu();
//		}
//
//		StringBuilder sb = new StringBuilder();
//		for (int y = 0; y < SCREEN_HEIGHT; y++) {
//			for (int x = 0; x < SCREEN_WIDTH; x++) {
//				sb.append(buffer[x][y]);
//			}
//			sb.append("\n");
//		}
//		textArea.setText(sb.toString());
//		ClearBuffer();
//	}
}
