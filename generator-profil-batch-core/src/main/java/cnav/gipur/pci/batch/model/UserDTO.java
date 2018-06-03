package cnav.gipur.pci.batch.model;

import java.util.Date;

/**
 * 
 * @author ZEX9977
 *
 */
public class UserDTO {


	private final String cn;
	private final String nir;
	private final Date dateNaissance;
	private final Date dateSuppression;
	private final Date dateCreation;
    private final Date dateCreationFed;
	private final String typeCompte;
	private Date dateTransitionFc;

    public UserDTO(String cn, String nir, Date dateNaissance, Date dateSuppression, Date dateCreation, Date dateCreationFed,
	    String typeCompte, Date dateTransitionFc) {
		this.cn = cn;
		this.nir = nir;
		this.dateNaissance = dateNaissance;
		this.dateSuppression = dateSuppression;
		this.dateCreation = dateCreation;
	this.dateCreationFed = dateCreationFed;
		this.typeCompte = typeCompte;
	this.dateTransitionFc = dateTransitionFc;
	}

	public String getCn() {
		return cn;
	}

	public String getNir() {
		return nir;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public Date getDateSuppression() {
		return dateSuppression;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public String getTypeCompte() {
		return typeCompte;
	}
	
	public Date getDateTransitionFc() {
		return dateTransitionFc;
	}
	public void setDateTransitionFc(Date dateTransitionFc) {
		this.dateTransitionFc = dateTransitionFc;
	}
    public Date getDateCreationFed() {
	return dateCreationFed;
	}

	    @Override
	    public String toString() {
		return "UserDTO [cn=" + cn + ", nir=" + nir + ", dateNaissance=" + dateNaissance + ", dateSuppression=" + dateSuppression + ", dateCreation="
		+ dateCreation + ", dateCreationFed=" + dateCreationFed + ", typeCompte=" + typeCompte + ", dateTransitionFc=" + dateTransitionFc + "]";
	    }

}
