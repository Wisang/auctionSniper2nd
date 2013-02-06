package production;

import javax.swing.SwingUtilities;

public class SniperStateDisplayer implements SniperListener {

	@Override
	public void sniperBidding() {
		showStatus(MainWindow.STATUS_BIDDING);
	}

	@Override
	public void sniperLost() {
		showStatus(MainWindow.STATUS_LOST);
	}

	public void sniperWinning() {
		showStatus(MainWindow.STATUS_WINNING);
	}

	private void showStatus(final String status) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main.ui.showStatus(status);
			}
		});
	}
}
