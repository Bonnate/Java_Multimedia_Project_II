import java.awt.Font;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

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

	public GameManager() {
		// JFrame 생성
		textArea = new JTextArea();

		// 창 설정
		setTitle("SPACE INVADER");
		setSize(1300, 850);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		textArea.setEditable(false);
		textArea.setFont(new Font("Courier", Font.PLAIN, 26));

		add(textArea);
		textArea.setEditable(false);
		setVisible(true);

		buffer = new char[SCREEN_WIDTH][SCREEN_HEIGHT];
		buffer = new char[SCREEN_WIDTH][SCREEN_HEIGHT];
		ClearBuffer();

		// 인스턴스 등록
		Instance = this;

		// 점수 초기화
		mScore = 0;
	}

	// GAME SYSTEM
	/** 점수를 변경시킨다 value값에 따라 점수가 오르거나, 떨어질 수 있다.
    * @param value 추가하거나 뺄 점수, value > 0 이면 점수가 오른다. */
	public void ModifyScore(int value)
	{
		mScore += value;
	}

	// INPUT

	/** 키 리스너를 등록한다 */
	public void AttachKeyListener(KeyListener listener) {
		textArea.addKeyListener(listener);
	}

	// DRAW

	private void ClearBuffer() {
		for (int y = 0; y < SCREEN_HEIGHT; y++) {
			for (int x = 0; x < SCREEN_WIDTH; x++) {
				if (x <= LEFT_PADDING) {
					buffer[x][y] = '.';
				} else if (x > SCREEN_WIDTH - RIGHT_PADDING) {
					buffer[x][y] = '.';
				} else {
					buffer[x][y] = ' ';
				}
			}
		}

		DrawScoreBoard();
	}

	private void DrawScoreBoard() {
		for (int i = 63; i < 78; ++i) {
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

		DrawToBuffer(64, 5, "Score: " + mScore);
	}

	public void DrawToBuffer(int px, int py, String c) {
		for (int x = 0; x < c.length(); x++) {
			buffer[px + x][py] = c.charAt(x);
		}
	}

	public void DrawToBuffer(int px, int py, char c) {
		buffer[px][py] = c;
	}

	public void DrawAll() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < SCREEN_HEIGHT; y++) {
			for (int x = 0; x < SCREEN_WIDTH; x++) {
				sb.append(buffer[x][y]);
			}
			sb.append("\n");
		}
		textArea.setText(sb.toString());
		ClearBuffer();
	}
}
