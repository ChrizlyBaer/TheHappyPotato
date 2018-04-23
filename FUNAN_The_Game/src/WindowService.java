import java.awt.Dimension;
import java.awt.Toolkit;

public abstract class WindowService {
	
	public static double[] getWindowSize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		return new double[]{width, height};
	}
	
	public static double getWindowHeight()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return 1000;
		//return screenSize.getHeight();
	}
	
	public static double getWindowWidth()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize.getWidth();
	}
}
