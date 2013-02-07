package production;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String MAIN_WINDOW_NAME = "Main Window";

	protected static final String STATUS_LOST = "Lost";
	public static String STATUS_BIDDING = "Bidding";
	public static String STATUS_WINNING = "Winning";
	public static String STATUS_WON = "Won";
	public static String STATUS_JOINING = "Joining";
	
	private final SnipersTableModel snipers = new SnipersTableModel();

	private String SNIPERS_TABLE_NAME = "Sniper Table";

	public MainWindow() {
		super("Auction Sniper");
		setName(MAIN_WINDOW_NAME);
		fillContentPane(makeSnipersTable());
		pack();
		// this.setSize(200, 300); //added by wisang

		// add(sniperStatus);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void fillContentPane(JTable snipersTable) {
		final Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(new JScrollPane(snipersTable), BorderLayout.CENTER);
	}

	private JTable makeSnipersTable() {
		final JTable snipersTable = new JTable(snipers);
		snipersTable.setName(SNIPERS_TABLE_NAME);
		return snipersTable;
	}

	public void showStatusText(String statusText) {
		snipers.setStatusText(statusText);
	}

//	public void showStatus(String status) {
//		sniperStatus.setText(status);
//	}

	public void sniperStatusChanged(SniperState sniperState, String statusText) {
		snipers.sniperStatusChanged(sniperState, statusText);
	}
}
