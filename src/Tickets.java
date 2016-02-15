import java.awt.Color;

import javax.swing.JLabel;

public class Tickets {

	private int minTickets;
	private int maxTickets;
	private int availableTickets;
	private final int TOTAL_TICKETS;

	public Tickets(int minTickets, int maxTickets, int availableTickets) {
		setMinTickets(minTickets);
		setMaxTickets(maxTickets);
		setAvailableTickets(availableTickets);
		TOTAL_TICKETS = availableTickets;
	}

	public int getAvailableTickets() {
		return availableTickets;
	}

	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}

	public int getMinTickets() {
		return minTickets;
	}

	public void setMinTickets(int minTickets) {
		this.minTickets = minTickets;
	}

	public int getMaxTickets() {
		return maxTickets;
	}

	public void setMaxTickets(int maxTickets) {
		this.maxTickets = maxTickets;
	}

	public int getTOTAL_TICKETS() {
		return TOTAL_TICKETS;
	}
	
	public String processTickets(int ticketNum) {
		int ticketsRemain = 0;
		String message;

		int remaining = getAvailableTickets();
		if (ticketNum < minTickets) {
			message = ("Must purchase at least 1 ticket but no more than 6.");
			return message;
		} else if (ticketNum > maxTickets) {
			message = ("Cannot purchase more than 6 tickets.");
			return message;
		} else if (ticketNum > remaining) {
			message = ("There are only " + remaining + " tickets availabe for purchase.");
			return message;
		} else
			ticketsRemain = remaining - ticketNum;
			setAvailableTickets(ticketsRemain);
			message = (ticketNum + " tickets purchased.  " + ticketsRemain + " tickets remaining.");
		return message;
	}

}
