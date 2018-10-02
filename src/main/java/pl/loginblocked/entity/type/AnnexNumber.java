package pl.loginblocked.entity.type;

public enum AnnexNumber {
	I("I"), II("II"), III("III"), IANDII("I/II"), IANDIII("I/III"), IIANDIII("II/III"),IIANDIIIAND("I/II/III");
	private String name;

	private AnnexNumber(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
