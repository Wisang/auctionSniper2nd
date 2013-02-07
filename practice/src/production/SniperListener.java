package production;

public interface SniperListener {

	void sniperLost();

	void sniperBidding(SniperState sniperState);

	void sniperWinning();

	void sniperWon();

	void sniperBidding();

}
