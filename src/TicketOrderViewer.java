import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TicketOrderViewer {

	public static void main(String[] args) {


		Tickets eventTickets = new Tickets(1,6,75);
		JFrame frame = new TicketOrderFrame(eventTickets);
		
		frame.setSize(325,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
