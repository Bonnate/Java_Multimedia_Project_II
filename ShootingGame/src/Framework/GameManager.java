package Framework;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Object.Background;
import Object.EnemyObject;
import Object.PlayerObject;
import Object.Wall;
import Utility.Vector2;

public class GameManager extends JFrame {

	// Data file path
	public static String _DATAFILEPATH = "./Data/Score.txt";

	// Singleton - pattern
	private static GameManager Instance = null;

	public static GameManager Instance() {
		if (Instance == null) {
			System.out.println("Null Instance Error");
		}

		return Instance;
	}

	// GAME MANAGER
	private JLayeredPane mContentPane;
	private JLabel mCurrentScore, mTopScore;

	// FRAME AREA
	public static final int SCREEN_WIDTH = 900;
	public static final int SCREEN_HEIGHT = 720;

	// GAME AREA
	public static final int AREA_WIDTH = 720;
	public static final int AREA_HEIGHT = 720;

	// GAME DATA
	private int mScore, mTScore;

	public GameManager() {
		setTitle("Space Invader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
		setResizable(false);

		mContentPane = new JLayeredPane();
		mContentPane.setFocusable(true);
		mContentPane.requestFocusInWindow();
		setContentPane(mContentPane);

		setVisible(true);

		// 인스턴스 등록
		Instance = this;

		// 점수 초기화
		mScore = 0;

		mCurrentScore = new JLabel("0", SwingConstants.CENTER);
		mCurrentScore.setBounds(AREA_WIDTH + 10, 70, 140, 20);
		mContentPane.add(mCurrentScore);

		mTopScore = new JLabel("0", SwingConstants.CENTER);
		mTopScore.setBounds(AREA_WIDTH + 10, 120, 140, 20);
		mContentPane.add(mTopScore);

		JLabel mCurrentScoreLabel = new JLabel("Current Score", SwingConstants.CENTER);
		mCurrentScoreLabel.setBounds(AREA_WIDTH + 10, 30, 140, 50);
		mCurrentScoreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		mCurrentScoreLabel.setForeground(Color.BLUE);
		mCurrentScoreLabel.setOpaque(true);
		mContentPane.add(mCurrentScoreLabel);

		JLabel mTopScoreLabel = new JLabel("Top Score", SwingConstants.CENTER);
		mTopScoreLabel.setBounds(AREA_WIDTH + 10, 80, 140, 50);
		mTopScoreLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		mTopScoreLabel.setForeground(Color.BLUE);
		mTopScoreLabel.setOpaque(true);
		mContentPane.add(mTopScoreLabel);

		LoadTextData();

		DisplayStartMenu();
	}

	public void DisplayStartMenu() {
		
		Time.Scale = 0f;
		
		JPanel startMenuPanel = new JPanel();
		startMenuPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		startMenuPanel.setLayout(new BorderLayout(0, 0));
		startMenuPanel.setVisible(true);

		JLabel label = new JLabel("Title");
		label.setIcon(new ImageIcon("./Assets/Backgrounds/titleBackground.png"));
		startMenuPanel.add(label, BorderLayout.CENTER);

		JButton btn = new JButton("GAME START");
		btn.setBounds(SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT / 2 - 80, 200, 80);
		btn.setFont(new Font("Serif", Font.PLAIN, 20));
		btn.setForeground(Color.BLACK);
		btn.setBackground(Color.WHITE);

		// 익명 클래스로 단순작업을 효율적으로 등록
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mContentPane.remove(btn);
				mContentPane.remove(startMenuPanel);
				mContentPane.remove(label);

				ResetGame();

				mContentPane.invalidate();
				mContentPane.validate();
				mContentPane.repaint();
			}
		});

		mContentPane.add(btn, new Integer(11));
		mContentPane.add(startMenuPanel, new Integer(10));
	}

	public void DisplayEndingMenu(boolean isWin) {
		
		Time.Scale = 0f;
		InputManager.Instance().ResetKeyState();
		
		String[] buttons = { "Yes", "No" };   
		int rc = JOptionPane.showOptionDialog(mContentPane, "Play Again ?", isWin ? "You Win!" : "You Lose!",
		        JOptionPane.WARNING_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[1]);
		
		//0 : YES, 1 : NO
		if(rc == 0)
		{
			ResetGame();
		}
		else
		{
			System.exit(0);
		}
	}

	// GAME SYSTEM
	/**
	 * 점수를 변경시킨다 value값에 따라 점수가 오르거나, 떨어질 수 있다.
	 * 
	 * @param value 추가하거나 뺄 점수, value > 0 이면 점수가 오른다.
	 */
	public void ModifyScore(int value) {
		mScore += value;
		mCurrentScore.setText(String.valueOf(mScore));

		if (mScore > mTScore) {
			mTScore = mScore;
			InputData();
			mTopScore.setText(String.valueOf(mScore));
		}
		
		if(EnemyObject.EnemyCount == 0)
		{
			DisplayEndingMenu(true);
		}
	}

	public void SetScore(int value) {
		mScore = value;
		mCurrentScore.setText(String.valueOf(mScore));
	}

	public JLayeredPane GetPane() {
		return mContentPane;
	}

	/** 키 리스너를 등록한다 */
	public void AttachKeyListener(KeyListener listener) {
		mContentPane.addKeyListener(listener);
	}

	// FILESTREAM
	public void LoadTextData() {
		BufferedReader in = null;
		StringBuilder str = new StringBuilder();
		try {
			in = new BufferedReader(new FileReader(_DATAFILEPATH));
			String line;
			while (true) {
				line = in.readLine();
				if (line == null)
					break;
				str.append(line);
			}
			// TODO
			this.mTScore = Integer.parseInt(str.toString());
			this.mTopScore.setText(String.valueOf(mTScore));

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void InputData() {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(_DATAFILEPATH));
			out.write(String.valueOf(mTScore));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void ResetGame() {
		
		ObjectManager.Instance().ClearAll();
		
		Time.InitDeltaTime();
		Time.Scale = 1.0;
		EnemyObject.EnemyCount = 0;

		SetScore(0);

		ObjectManager.Instance().Instantiate(new Background(new Vector2(0, -GameManager.SCREEN_HEIGHT)));
		ObjectManager.Instance().Instantiate(new Background(new Vector2(0, 0)));
		ObjectManager.Instance().Instantiate(new Wall(new Vector2(0, 0), new Vector2(1, GameManager.AREA_HEIGHT)));
		ObjectManager.Instance()
				.Instantiate(new Wall(new Vector2(GameManager.AREA_WIDTH, 0), new Vector2(1, GameManager.AREA_HEIGHT)));

		ObjectManager.Instance().Instantiate(new PlayerObject(new Vector2(GameManager.AREA_WIDTH / 2 - 30, GameManager.AREA_HEIGHT - 100), "Player1"));
		((PlayerObject) ObjectManager.Instance().FindGameObjectFromName("Player1")).ModifyCtrlPanel(true);
//		ObjectManager.Instance().Instantiate(new PlayerObject(new Vector2(24, 20), "Player2"));

		ObjectManager.Instance().Instantiate(new EnemyObject(new Vector2(45, -100)));
		ObjectManager.Instance().Instantiate(new EnemyObject(new Vector2(135, -150)));

		ObjectManager.Instance().Instantiate(new EnemyObject(new Vector2(225, -100)));
		ObjectManager.Instance().Instantiate(new EnemyObject(new Vector2(315, -150)));

		ObjectManager.Instance().Instantiate(new EnemyObject(new Vector2(405, -100)));
		ObjectManager.Instance().Instantiate(new EnemyObject(new Vector2(495, -150)));

		ObjectManager.Instance().Instantiate(new EnemyObject(new Vector2(585, -100)));
		ObjectManager.Instance().Instantiate(new EnemyObject(new Vector2(675, -150)));
	}
}
