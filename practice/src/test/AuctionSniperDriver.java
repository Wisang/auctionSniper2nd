package test;

import production.MainWindow;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JTableDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import static com.objogate.wl.swing.matcher.JLabelTextMatcher.withLabelText;
import static com.objogate.wl.swing.matcher.IterableComponentsMatcher.matching;

public class AuctionSniperDriver extends JFrameDriver{
	@SuppressWarnings("unchecked")
	public AuctionSniperDriver(int timeoutMills) {
		super(new GesturePerformer(), JFrameDriver.topLevelFrame(named(MainWindow.MAIN_WINDOW_NAME),
				showingOnScreen()),
				new AWTEventQueueProber(timeoutMills, 100));
	}
	
	@SuppressWarnings("unchecked")
	public void showsSniperStatus(String itemId, int lastPrice, int lastBid, String statusText) {
//		new JLabelDriver(
//				this, named(Main.SNIPER_STATUS_NAME)).hasText(equalTo(stutusText));
		//new JTableDriver(this).hasCell(withLabelText(equalTo(statusText)));
		JTableDriver table = new JTableDriver(this);
	    table.hasRow(
	      matching(withLabelText(itemId), withLabelText(String.valueOf(lastPrice)),
	               withLabelText(String.valueOf(lastBid)), withLabelText(statusText)));
	}
}
