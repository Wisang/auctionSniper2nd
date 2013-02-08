package production;

import javax.swing.table.AbstractTableModel;

public class SnipersTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static SniperState STARTING_UP = new SniperState("test item", 100, 100); //wisang
	private String statusText = MainWindow.STATUS_JOINING;
	private SniperState sniperState = STARTING_UP;

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public int getColumnCount() {
		return Column.values().length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (Column.at(columnIndex)) {
		case ITEM_IDENTIFIER:
			return sniperState.itemId;
		case LAST_PRICE:
			return sniperState.lastPrice;
		case LAST_BID:
			return sniperState.lastBid;
		case SNIPER_STATUS:
			return statusText;
		default:
			throw new IllegalArgumentException("No column at " + columnIndex);
		}
	}

	public void setStatusText(String newStatusText) {
		System.out.println("set status called"); //wisang
		statusText = newStatusText;
		fireTableRowsUpdated(0, 0);
	}

	public void sniperStatusChanged(SniperState newSniperState, String newStatusText) {
		System.out.println("status change called"); //wisang
		sniperState = newSniperState;
	    statusText = newStatusText;
	    fireTableRowsUpdated(0, 0);
	}
}
