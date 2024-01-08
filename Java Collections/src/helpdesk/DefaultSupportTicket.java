package helpdesk;

public class DefaultSupportTicket implements SupportTicket{
	private static int counter;
	private RequestType requestType;
	private int sequentialNumber;
	
	{
		sequentialNumber = ++counter;
	}
	
	public DefaultSupportTicket() {
		
	}
	public DefaultSupportTicket(RequestType requesttype) {
		this.requestType = requestType;
	}

	@Override
	public Priority getPriority() {
		if (requestType == null) {
			return null;
		}
		return this.requestType.getPriority();
	}

	@Override
	public int getSequentialNumber() {
		return this.sequentialNumber;
	}

	@Override
	public RequestType getRequestType() {
		return this.requestType;
	}

}
