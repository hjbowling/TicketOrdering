import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketOrderFrame extends JFrame {

	Tickets eventTickets;

	public StatusBar status = new StatusBar();
	private JLabel labelInstruction = new JLabel("Enter how many tickets you'd like to purchase (1-6)");
	private JTextField numOfTickets = new JTextField(10);
	private JButton purchaseTickets = new JButton("Purchase tickets");
	private JLabel labelMsg = new JLabel("");
	private JLabel labelSoldOut = new JLabel("");

	public TicketOrderFrame(Tickets t) {

		eventTickets = t;
        
		ticketsClickListener purchase = new ticketsClickListener();
		purchaseTickets.addActionListener(purchase);
		
		setTitle("Event Tickets");
		status.setPreferredSize(new Dimension(305, 100));
		
        Container mainPanel = getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(labelInstruction, BorderLayout.NORTH);
        p1.add(numOfTickets, BorderLayout.WEST);	
        p1.add(purchaseTickets, BorderLayout.CENTER);
        p1.add(labelMsg, BorderLayout.SOUTH);
 
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        p2.add(status);
        p2.add(labelSoldOut);
 
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(p1, BorderLayout.NORTH);
        mainPanel.add(p2, BorderLayout.CENTER);
 
        pack();    
	}

	class ticketsClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String tickets = numOfTickets.getText();
			if (tickets.equals("")) {
				labelMsg.setText("Please enter number of tickets to purchase.");
				numOfTickets.setText("");
			} else {
				try {
					int ticketNum = Integer.parseInt(tickets);
					String msg = eventTickets.processTickets(ticketNum);
					labelMsg.setText(msg);
					numOfTickets.setText("");
					int ticketsLeft = eventTickets.getAvailableTickets();
					int barLength = status.getLength();
					if (ticketsLeft == 0) {
						status.setFill(barLength);
						status.setNewValues();
						labelSoldOut.setText("   EVENT IS SOLD OUT.   ");
					} else {
						final int TOTAL_TICKETS_AVAIL = eventTickets.getTOTAL_TICKETS();
						int perTicketRatio = barLength / TOTAL_TICKETS_AVAIL;
						int ticketsSold = TOTAL_TICKETS_AVAIL - ticketsLeft;
						int fill = ticketsSold * perTicketRatio;
						status.setFill(fill);
						status.setNewValues();
					}
				} catch (NumberFormatException exception) {
					labelMsg.setText("Please enter a number only");
					numOfTickets.setText("");
				}
			}
		}
	}
}
