package pkg;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;


public class Main extends Application {
	
	private static final int WINDOW_WIDTH = 640;
	private static final int WINDOW_HEIGHT = 480;
	private static final int BAR_Y = WINDOW_HEIGHT  - 50;
	private static final int BALL_RADIUS = 10;
	private static final int BAR_SIZE = 150;
	/* �u���b�N�̌� */
	private static final int BLOCKS_N_X = 10;
	private static final int BLOCKS_N_Y = 10;
	
	private int bar_x = WINDOW_WIDTH / 2;
	private int ball_x = WINDOW_WIDTH / 2;
	private int ball_y = WINDOW_HEIGHT / 2;
	
	private GraphicsContext gc;
	
	/**
	 * ��������K�v�͂���܂���
	 */
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("BREAKOUT");
		Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.gc = canvas.getGraphicsContext2D();
		primaryStage.setScene(new Scene(new Pane(canvas), WINDOW_WIDTH, WINDOW_HEIGHT));
		primaryStage.show();
		new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				loop();
			}
		}.start();
	}
	
	/**
	 * ��������K�v�͂���܂���
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * ���C�����[�v (60fps)
	 */
	private void loop() {
		paint();
	}
	
	/**
	 * �`���p���\�b�h
	 */
	private void paint() {
		paintBlocks();
		paintBall();
		paintBar();
	}
	
	private void paintBlocks() {
		final int BLOCK_WIDTH = WINDOW_WIDTH  / BLOCKS_N_X;
		/* �Q�ł��̂́C��ʂ̏㔼�����g���Ƃ����Ӗ� */
		final int BLOCK_HEIGHT = WINDOW_HEIGHT / BLOCKS_N_Y / 2;
		/* ��ʃN���A */
		gc.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		/* �h��Ԃ��F��ݒ� */
		gc.setFill(Color.RED);
		gc.fillRect(0, 0, BLOCK_WIDTH, BLOCK_HEIGHT);
		gc.strokeRect(0, 0, BLOCK_WIDTH, BLOCK_HEIGHT);
	}
	
	private void paintBall() {
		int x0 = ball_x - BALL_RADIUS;
		int y0 = ball_y - BALL_RADIUS;
		/* �h��Ԃ��F��ݒ� */
		gc.setFill(Color.BLACK);
		gc.fillOval(x0, y0,  2 * BALL_RADIUS, 2 * BALL_RADIUS);
	}
	
	private void paintBar() {
		final int BAR_HEIGHT = 10;
		int x0 = ball_x - BAR_SIZE / 2;
		/* �h��Ԃ��F��ݒ� */
		gc.setFill(Color.BLACK);
		gc.fillRect(x0, BAR_Y,  BAR_SIZE, BAR_HEIGHT);
	}
	
	/**
	 * �I������
	 * @return True �Q�[���I�[�o�[�Ȃ�
	 */
	private boolean isGameOver() {
		/* �A�v���P�[�V�������I�����������ꍇ�CSystem.exit(0); �Ƃ��܂� */
		return false;
	}
	
	/**
	 * �N���A����
	 * @return True �N���A�Ȃ�
	 */
	private boolean isGameClear() {
		return false;
	}
}
