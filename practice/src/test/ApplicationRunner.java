package test;

import production.Main;

public class ApplicationRunner {
	public static final String SNIPER_ID = "sniper";
	public static final String SNIPER_PASSWORD = "sniper";
	public static String SNIPER_XMPP_ID = "sniper@localhost/Auction";
	private AuctionSniperDriver driver;
	private String XMPP_HOSTNAME = "localhost";
	
	private String itemId;

	public void startBiddingIn(final FakeAuctionServer auction) {
		itemId = auction.getItemId();
		
		Thread thread = new Thread("Test Application") {
			@Override
			public void run() {
				try {
					Main.main(XMPP_HOSTNAME , SNIPER_ID, SNIPER_PASSWORD,
							itemId); //wisang
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
		driver = new AuctionSniperDriver(1000);
		driver.showsSniperStatus(itemId, 1000, 98, Main.STATUS_JOINING); //wisang
	}

	public void showsSniperHasLostAuction() {
		driver.showsSniperStatus(itemId, 1000, 98, Main.STATUS_LOST); //wisang
	}

	public void stop() {
		if (driver != null) {
			driver.dispose();
		}
	}

	public void hasShownSniperIsBidding(int lastPrice, int lastBid) {
		driver.showsSniperStatus(itemId, lastPrice, lastBid, Main.STATUS_BIDDING);
	}

	public void hasShownSniperIsWinning(int winningBid) {
		driver.showsSniperStatus(itemId, winningBid, winningBid, Main.STATUS_WINNING);
	}

	public void showsSniperHasWonAuction(int lastPrice) {
		driver.showsSniperStatus(itemId, lastPrice, lastPrice, Main.STATUS_WON);
	}
}
