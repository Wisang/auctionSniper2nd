package production;

public class SniperState {
	public final String itemId;
	public final int lastPrice;
	public final int lastBid;

	public SniperState(String itemId, int lastPrice, int lastBid) {
		this.itemId = itemId;
		this.lastPrice = lastPrice;
		this.lastBid = lastBid;
	}
	
	@Override
	public boolean equals(Object other) {
		if(null == other)
			return false;
		
		SniperState that = (SniperState)other;
		return this.itemId == that.itemId &&
				this.lastPrice == that.lastPrice &&
				this.lastBid == that.lastBid;
	}
}
