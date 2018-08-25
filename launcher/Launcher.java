package launcher;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import core.Game;
import io.MainWindow;

public class Launcher {
	static ScheduledExecutorService executor;
	static MainWindow window;
	static boolean shutdown_activated = false;
	
	public static void main(String[] args) throws InterruptedException {
		Thread shutdownHookTest = new Thread() {
			@Override
			public void run() {
				System.out.println("shutdown hook output");
			}
		};
		Runtime.getRuntime().addShutdownHook(shutdownHookTest);
		
		int ticktime = 100;
		long tStart, tDiff;
		
		Game game = new Game(20, 20, 10, 10);
		window = new MainWindow(game.getGrid(), game.getSnake());		
		
		Runnable render = new Runnable() {
			private long lastFrameTime = System.currentTimeMillis();
			@Override
			public void run() {
				long beginning = System.currentTimeMillis();
				window.update();
				long end = System.currentTimeMillis();
				System.out.println("time since last frame: " + (end - lastFrameTime) + " ms");
				System.out.println("frame rendering time: " + (end - beginning) + " ms");
				lastFrameTime = end;				
			}
		};
		executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(render, 0, 16667, TimeUnit.MICROSECONDS);				
		
		while (game.isRunning() && !shutdown_activated) {
			if (game.isPaused()) Thread.sleep(ticktime);
			else {		
				tStart = System.currentTimeMillis();
				game.tick();			
				tDiff = System.currentTimeMillis() - tStart;
				System.out.println("tick time: " + tDiff + " ms");
				if (tDiff < ticktime) {
					System.out.println("sleep time: " + (ticktime - tDiff) + " ms");
					Thread.sleep(ticktime - tDiff);				
				}
			}
		}			
		terminate();
	}

	public static void terminate() {
		shutdown_activated = true;
		executor.shutdownNow();
		window.dispose();
	};

}
