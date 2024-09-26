package helpdesk;

import java.util.PriorityQueue;
import java.util.Queue;

public class DefaultHelpDesk implements HelpDesk {
	
	private Queue<SupportTicket> tickets;
	
	{
		tickets = new PriorityQueue<>(new CustomSupportTicketsComparator());
	}

	@Override
	public void addNewSupportTicket(SupportTicket supportTicket) {
		tickets.offer(supportTicket);		
	}

	@Override
	public SupportTicket getNextSupportTicket() {
		// TODO Auto-generated method stub
		return tickets.poll();
	}

	@Override
	public int getNumberOfTickets() {
		// TODO Auto-generated method stub
		return tickets.size();
	}

}
