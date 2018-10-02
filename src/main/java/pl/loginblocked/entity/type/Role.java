package pl.loginblocked.entity.type;

public enum Role {
	ADMIN("Administrator"),
	USER("Koordynator"),
	SUPER("Super Administrator");
	
	private String name;

	
	private Role(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public static Role fromString(String name) {
		for(Role r : Role.values()) {
			if(r.name.equalsIgnoreCase(name)) {
				return r;
			}
		}
		return null;
	}
}
