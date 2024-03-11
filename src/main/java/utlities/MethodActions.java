package utlities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;

public class MethodActions {
	public static WebDriver dirver;

	public static void zoomOut() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		Thread.sleep(3000);
		// Press and hold the Control key
		try {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);

			// Release the minus key
			robot.keyRelease(KeyEvent.VK_MINUS);
			// Optionally perform other actions while holding the Control key

			// Release the Control key
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}

	}

}
