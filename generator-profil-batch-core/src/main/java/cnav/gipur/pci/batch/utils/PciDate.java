package cnav.gipur.pci.batch.utils;

/**
 * 
 * @author ZEX9977
 *
 */
public class PciDate {

	private final String jour;
	private final String mois;
	private final String annee;

	/**
	 * 
	 * @param dateStr
	 */
	public PciDate(String dateStr) {
		this.jour = dateStr.substring(0, 2);
		if ("00".equals(jour)) {
			if ("00".equals(dateStr.substring(3, 5)) || "01".equals(dateStr.substring(3, 5))) {
				this.mois = "02";
			} else {
				this.mois = dateStr.substring(3, 5);
			}
		} else if ("00".equals(dateStr.substring(3, 5)) && !"00".equals(jour)) {
			this.mois = "01";
		} else {
			this.mois = dateStr.substring(3, 5);
		}
		this.annee = dateStr.substring(6);
	}

	/**
	 * @param jour
	 * @param mois
	 * @param annee
	 */
	public PciDate(String jour, String mois, String annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	/**
	 * @return the jour
	 */
	public String getJour() {
		return jour;
	}

	/**
	 * @return the mois
	 */
	public String getMois() {
		return mois;
	}

	/**
	 * @return the annee
	 */
	public String getAnnee() {
		return annee;
	}

	/**
	 * @return Date sous format ddMMyyyy
	 */
	public String toString() {
		return jour + mois + annee;
	}

	/**
	 * @return Date sous format dd/MM/yyyy
	 */
	public String toddmmyyyyString() {
		return jour + "/" + mois + "/" + annee;
	}

	/**
	 * @return Date sous format yyyy-MM-dd
	 */
	public String toyyyyMMddString() {
		return annee + "-" + mois + "-" + jour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annee == null) ? 0 : annee.hashCode());
		result = prime * result + ((jour == null) ? 0 : jour.hashCode());
		result = prime * result + ((mois == null) ? 0 : mois.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PciDate other = (PciDate) obj;
		if (annee == null) {
			if (other.annee != null)
				return false;
		} else if (!annee.equals(other.annee))
			return false;
		if (jour == null) {
			if (other.jour != null)
				return false;
		} else if (!jour.equals(other.jour))
			return false;
		if (mois == null) {
			if (other.mois != null)
				return false;
		} else if (!mois.equals(other.mois))
			return false;
		return true;
	}

}
