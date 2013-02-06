package production;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String MAIN_WINDOW_NAME = "Main Window";
	
	protected static final String STATUS_LOST = "Lost";
	protected static String STATUS_BIDDING = "Bidding";
	public static String STATUS_WINNING = "Winning";
	public static String STATUS_WON = "Won";
	
	private final JLabel sniperStatus = createLabel(Main.STATUS_JOINING);

	public MainWindow() {
	    super("Auction Sniper");
	    setName(MAIN_WINDOW_NAME);
	    
	    this.setSize(200, 300); //added by wisang
	    
	    add(sniperStatus);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	  }
	
	private static JLabel createLabel(String initialText) {
	    JLabel result = new JLabel(initialText);
	    result.setName(Main.SNIPER_STATUS_NAME);
	    result.setBorder(new LineBorder(Color.BLACK));
	    return result;
	  }

	public void showStatus(String status) {
		sniperStatus.setText(status);
	}
}
