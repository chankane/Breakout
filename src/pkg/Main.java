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
	/* ブロックの個数 */
	private static final int BLOCKS_N_X = 10;
	private static final int BLOCKS_N_Y = 10;
	
	private int bar_x = WINDOW_WIDTH / 2;
	private int ball_x = WINDOW_WIDTH / 2;
	private int ball_y = WINDOW_HEIGHT / 2;
	
	private GraphicsContext gc;
	
	/**
	 * 理解する必要はありません
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
	 * 理解する必要はありません
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * メインループ (60fps)
	 */
	private void loop() {
		paint();
	}
	
	/**
	 * 描画専用メソッド
	 */
	private void paint() {
		paintBlocks();
		paintBall();
		paintBar();
	}
	
	private void paintBlocks() {
		final int BLOCK_WIDTH = WINDOW_WIDTH  / BLOCKS_N_X;
		/* ２でわるのは，画面の上半分を使うという意味 */
		final int BLOCK_HEIGHT = WINDOW_HEIGHT / BLOCKS_N_Y / 2;
		/* 画面クリア */
		gc.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		/* 塗りつぶし色を設定 */
		gc.setFill(Color.RED);
		gc.fillRect(0, 0, BLOCK_WIDTH, BLOCK_HEIGHT);
		gc.strokeRect(0, 0, BLOCK_WIDTH, BLOCK_HEIGHT);
	}
	
	private void paintBall() {
		int x0 = ball_x - BALL_RADIUS;
		int y0 = ball_y - BALL_RADIUS;
		/* 塗りつぶし色を設定 */
		gc.setFill(Color.BLACK);
		gc.fillOval(x0, y0,  2 * BALL_RADIUS, 2 * BALL_RADIUS);
	}
	
	private void paintBar() {
		final int BAR_HEIGHT = 10;
		int x0 = ball_x - BAR_SIZE / 2;
		/* 塗りつぶし色を設定 */
		gc.setFill(Color.BLACK);
		gc.fillRect(x0, BAR_Y,  BAR_SIZE, BAR_HEIGHT);
	}
	
	/**
	 * 終了条件
	 * @return True ゲームオーバーなら
	 */
	private boolean isGameOver() {
		/* アプリケーションを終了させたい場合，System.exit(0); とします */
		return false;
	}
	
	/**
	 * クリア条件
	 * @return True クリアなら
	 */
	private boolean isGameClear() {
		return false;
	}
}
