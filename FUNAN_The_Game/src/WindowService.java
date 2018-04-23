import java.awt.Dimension;
import java.awt.Toolkit;

public class WindowService {

	private int windowHeight;
	private int windowWidth;
	private final int numberOfSquares;

	public WindowService(int numberOfSquares) {
		this.numberOfSquares = numberOfSquares;
		getWindowSize();
	}

	public void getWindowSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.windowWidth = (int) screenSize.getWidth();
		this.windowHeight = 1000; // TODO: Have to change the return value dynamically on screen height.
		//this.windowHeight = (int) screenSize.getHeight(); 	
	}

	public int getSquareSize(){
		int squareSize = (this.windowHeight / numberOfSquares);
		return squareSize;
	}
	
	public int getWindowHeight() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return 1000;
		// return (int) screenSize.getHeight();
	}

	public int getWindowWidth() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) screenSize.getWidth();
	}
}
