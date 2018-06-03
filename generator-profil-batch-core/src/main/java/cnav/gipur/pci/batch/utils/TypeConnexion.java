package cnav.gipur.pci.batch.utils;

/**
 * 
 * @author ZEX9977
 *
 */
public enum TypeConnexion {

	FRANCE_CONNECT("Connexion FC"), LOCALE("Connexion");

	private final String value;

	private TypeConnexion(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
