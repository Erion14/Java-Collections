package helpdesk;

import helpdesk.SupportTicket;

public interface HelpDesk {

	void addNewSupportTicket(SupportTicket supportTicket);
	
	SupportTicket getNextSupportTicket();
	
	int getNumberOfTickets();

}
