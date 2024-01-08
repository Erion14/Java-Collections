package helpdesk;

public interface SupportTicket {
	Priority getPriority();
	
	int getSequentialNumber();
	
	RequestType getRequestType();

}
