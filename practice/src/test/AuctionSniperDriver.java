package test;

import production.Main;
import production.MainWindow;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import static org.hamcrest.Matchers.equalTo;

public class AuctionSniperDriver extends JFrameDriver{
	@SuppressWarnings("unchecked")
	public AuctionSniperDriver(int timeoutMills) {
		super(new GesturePerformer(), JFrameDriver.topLevelFrame(named(MainWindow.MAIN_WINDOW_NAME),
				showingOnScreen()),
				new AWTEventQueueProber(timeoutMills, 100));
	}
	
	@SuppressWarnings("unchecked")
	public void showsSniperStatus(String stutusText) {
		new JLabelDriver(
				this, named(Main.SNIPER_STATUS_NAME)).hasText(equalTo(stutusText));
	}
}
