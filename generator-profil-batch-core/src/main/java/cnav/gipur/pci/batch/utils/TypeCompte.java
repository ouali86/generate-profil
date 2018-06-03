package cnav.gipur.pci.batch.utils;
/**
 * 
 * @author ZEX9977
 *
 */
public enum TypeCompte {
	FC("fc"), LOCAL("local");
	
	private final String value;
	
	private TypeCompte(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	
}
