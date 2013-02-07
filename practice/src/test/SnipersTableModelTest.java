package test;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.hamcrest.Matcher;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import production.Column;
import production.MainWindow;
import production.SniperState;

import production.SnipersTableModel;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

@RunWith(JMock.class)
public class SnipersTableModelTest {
	private final Mockery context = new Mockery();
	private TableModelListener listener = context
			.mock(TableModelListener.class);
	private final SnipersTableModel model = new SnipersTableModel();

	@Before
	public void attachModelListener() {
		model.addTableModelListener(listener);
	}

	@Test
	public void hasEnoughColumns() {
		assertThat(model.getColumnCount(), equalTo(Column.values().length));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void setsSniperValuesInColumns() {
		context.checking(new Expectations() {
			{
				one(listener).tableChanged(with(aRowChangedEvent()));
			}
		});

		model.sniperStatusChanged(new SniperState("item id", 555, 666),
				MainWindow.STATUS_BIDDING);

		assertColumnEquals(Column.ITEM_IDENTIFIER, "item id");
		assertColumnEquals(Column.LAST_PRICE, 555);
		assertColumnEquals(Column.LAST_BID, 666);
		assertColumnEquals(Column.SNIPER_STATUS, MainWindow.STATUS_BIDDING);
	}

	private void assertColumnEquals(Column column, Object expected) {
	    final int rowIndex = 0;
	    final int columnIndex = column.ordinal();
	    assertEquals(expected, model.getValueAt(rowIndex, columnIndex));
	  }

	private Matcher<TableModelEvent> aRowChangedEvent() {
		return samePropertyValuesAs(new TableModelEvent(model, 0));
	}
}
