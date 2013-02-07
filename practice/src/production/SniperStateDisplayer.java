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
				// Main.ui.showStatus(status); //wisang
				Main.ui.showStatusText(status);
			}
		});
	}

	@Override
	public void sniperWon() {
		showStatus(MainWindow.STATUS_WON);
	}

	@Override
	public void sniperBidding(final SniperState state) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main.ui.sniperStatusChanged(state, MainWindow.STATUS_BIDDING);
			}
		});
	}
}
