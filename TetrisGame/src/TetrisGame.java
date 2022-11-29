import javax.swing.JFrame;

public class TetrisGame extends JFrame{
	private TetrisEngine controller;
	private TetrisGrid model;
	private TetrisView view;
	private int width;
	private int height;

	TetrisGame(int width, int height) {
		this.width = width;
		this.height = height;
		initMVC();
		initJFrame();
		new Thread(controller).start();
	}

	private void initMVC() {
		view = new TetrisView(width, height, TetrisGrid.GRID_WIDTH, TetrisGrid.GRID_HEIGHT);
		model = new TetrisGrid();
		controller = new TetrisEngine(model, view);
	}

	private void initJFrame() {
		add(view);
		pack();
		setTitle("Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] argv) {
		new TetrisGame(400, 600);
	}
}
