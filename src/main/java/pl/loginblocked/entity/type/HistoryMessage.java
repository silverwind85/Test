package pl.loginblocked.entity.type;

public enum HistoryMessage {
	DODAWANIE("Dodano publikację "),
	EDYCJA("Zmieniono publikację "),
	USUWANIE("Usunięto publikację ");
	
	
	private String message;

	private HistoryMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	
}
