package cnav.gipur.pci.batch.model;

import java.util.Date;

/**
 * 
 * @author ZEX9977
 *
 */
public class StatDTO {

	private final Date currentDate;
	private final Date fromDate;
	private final Date toDate;
	private final Integer nbrAccesComptePeriod;
	private final Float ratioAccesCompteFcPeriod;
	private final Integer nbrComptePeriod;
	private final Integer nbrCompteLocauxPeriod;
	private final Integer nbrCompteFcPeriod;
	private final Float ratioCompteFcPeriod;
	private final Integer nbrCompteSuppPeriod;
	private final Float ratioCompteHommePeriod;
	private final Integer nbrCompteHommePeriod;
	private final Integer nbrCompteFemmePeriod;
	private final Integer nbrCompteHommeGlobal;
	private final Integer nbrCompteFemmeGlobal;
	private final Float ratioCompteFemmePeriod;
	private final Float ratioCompteMoin45Period;
	private final Integer nbrCompteMoin45Period;
	
	private final Float ratioCompteEntre4555Period;
	private final Float ratioComptePlus55Period;
	private final Integer nbrComptePlus55Period;
	private final Integer nbrCompteEntre4555Period;

	private final Integer nbrTransFcPeriod;
	private final Integer nbrCompteGlobal;
	private final Integer nbrCompteLocauxGlobal;
	private final Integer nbrCompteFcGlobal;
	private final Float ratioCompteFcGlobal;
	private final Integer nbrCompteSuppGlobal;
	private final Float ratioCompteHommeGlobal;
	private final Float ratioCompteFemmeGlobal;
	private final Float ratioCompteMoin45Global;
	private final Integer nbrCompteMoin45Global;
	private final Float ratioCompteEntre4555Global;
	private final Integer nbrCompteEntre4555Global;
	
	private final Float ratioComptePlus55Global;
	private final Integer nbrComptePlus55Global;

	private final Integer nbrTransFcGlobal;

	/**
	 * 
	 * @param currentDate
	 * @param fromDate
	 * @param toDate
	 * @param nbrComptePeriod
	 * @param nbrCompteLocauxPeriod
	 * @param nbrCompteFcPeriod
	 * @param nbrCompteSuppPeriod
	 * @param nbrCompteHommePeriod
	 * @param nbrCompteFemmePeriod
	 * @param nbrCompteMoin45Period
	 * @param nbrCompteEntre4555Period
	 * @param nbrComptePlus55Period
	 * @param nbrTransFcPeriod
	 * @param nbrCompteGlobal
	 * @param nbrCompteLocauxGlobal
	 * @param nbrCompteFcGlobal
	 * @param nbrCompteSuppGlobal
	 * @param nbrCompteHommeGlobal
	 * @param nbrCompteFemmeGlobal
	 * @param nbrCompteMoin45Global
	 * @param nbrCompteEntre4555Global
	 * @param nbrComptePlus55Global
	 * @param nbrTransFcGlobal
	 */
	public StatDTO(Date currentDate, Date fromDate, Date toDate, Integer nbrAccesComptePeriod,
			Integer nbrAccesCompteFcPeriod, Integer nbrComptePeriod, Integer nbrCompteLocauxPeriod,
			Integer nbrCompteFcPeriod, Integer nbrCompteSuppPeriod,Integer nbrCompteHommePeriod,
			Integer nbrCompteFemmePeriod, Integer nbrCompteMoin45Period, Integer nbrCompteEntre4555Period,
			Integer nbrComptePlus55Period, Integer nbrTransFcPeriod, Integer nbrCompteGlobal,
			Integer nbrCompteLocauxGlobal, Integer nbrCompteFcGlobal, Integer nbrCompteSuppGlobal,
			Integer nbrCompteHommeGlobal, Integer nbrCompteFemmeGlobal, Integer nbrCompteMoin45Global,
	    Integer nbrCompteEntre4555Global, Integer nbrComptePlus55Global, Integer nbrTransFcGlobal) {
		this.currentDate = currentDate;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.nbrAccesComptePeriod = nbrAccesComptePeriod;
		this.ratioAccesCompteFcPeriod = calculRatioAccesCompteFcPeriod(nbrAccesCompteFcPeriod);
		this.nbrComptePeriod = nbrComptePeriod;
		this.nbrCompteLocauxPeriod = nbrCompteLocauxPeriod;
		this.nbrCompteFcPeriod = nbrCompteFcPeriod;
		this.ratioCompteFcPeriod = calculRatioCompteFcPeriod();
		this.nbrCompteSuppPeriod = nbrCompteSuppPeriod;
		this.nbrCompteHommePeriod= nbrCompteHommePeriod;
		this.nbrCompteFemmePeriod=nbrCompteFemmePeriod;		
		this.ratioCompteHommePeriod = calculRatioCompteHommePeriod(nbrCompteHommePeriod);
		this.ratioCompteFemmePeriod = calculRatioCompteFemmePeriod(nbrCompteFemmePeriod);
		this.ratioCompteMoin45Period = calculRatioCompteMoin45Period(nbrCompteMoin45Period);
		this.ratioCompteEntre4555Period = calculRatioCompteEntre4555Period(nbrCompteEntre4555Period);
		this.ratioComptePlus55Period = calculRatioComptePlus55Period(nbrComptePlus55Period);
		this.nbrTransFcPeriod = nbrTransFcPeriod;
		this.nbrCompteGlobal = nbrCompteGlobal;
		this.nbrCompteLocauxGlobal = nbrCompteLocauxGlobal;
		this.nbrCompteFcGlobal = nbrCompteFcGlobal;
		this.ratioCompteFcGlobal = calculRatioCompteFcGlobal(nbrCompteFcGlobal);
		this.nbrCompteSuppGlobal = nbrCompteSuppGlobal;
		this.ratioCompteHommeGlobal = calculRatioCompteHommeGlobal(nbrCompteHommeGlobal);
		this.ratioCompteFemmeGlobal = calculRatioCompteFemmeGlobal(nbrCompteFemmeGlobal);
		this.nbrCompteHommeGlobal =  nbrCompteHommeGlobal;
		this.nbrCompteFemmeGlobal =  nbrCompteFemmeGlobal;
		
		this.nbrCompteMoin45Global = nbrCompteMoin45Global;
		this.ratioCompteMoin45Global =calculRatioCompteMoin45Global(nbrCompteMoin45Global);
		this.ratioCompteEntre4555Global = calculRatioCompteEntre4555Global(nbrCompteEntre4555Global);
		this.nbrCompteEntre4555Global = nbrCompteEntre4555Global;
		
		this.ratioComptePlus55Global = calculRatioComptePlus55Global(nbrComptePlus55Global);
		this.nbrComptePlus55Global =  nbrComptePlus55Global;
		this.nbrCompteMoin45Period = nbrCompteMoin45Period;
		this.nbrComptePlus55Period = nbrComptePlus55Period;
		this.nbrCompteEntre4555Period = nbrCompteEntre4555Period;
		this.nbrTransFcGlobal = nbrTransFcGlobal;

	}

	private Float calculRatioAccesCompteFcPeriod(Integer nbrAccesCompteFcPeriod) {
		if (nbrAccesComptePeriod == 0 || nbrAccesCompteFcPeriod == 0)
			return 0f;
		else
			return (nbrAccesCompteFcPeriod * 100.0f) / nbrAccesComptePeriod;
	}

	/**
	 * CALCULATIONS
	 */
	private Float calculRatioCompteFcPeriod() {
		if (nbrComptePeriod == 0 || nbrCompteFcPeriod == 0)
			return 0f;
		else
			return (nbrCompteFcPeriod * 100.0f) / nbrComptePeriod;
	}

	private Float calculRatioCompteHommePeriod(Integer nbrCompteHommePeriod) {
		if (nbrComptePeriod == 0 || nbrCompteHommePeriod == 0)
			return 0f;
		else
			return (nbrCompteHommePeriod * 100.0f) / nbrComptePeriod;
	}

	private Float calculRatioCompteFemmePeriod(Integer nbrCompteFemmePeriod) {
		if (nbrComptePeriod == 0 || nbrCompteFemmePeriod == 0)
			return 0f;
		else
			return (nbrCompteFemmePeriod * 100.0f) / nbrComptePeriod;
	}

	private Float calculRatioCompteMoin45Period(Integer nbrCompteMoin45Period) {
		if (nbrComptePeriod == 0 || nbrCompteMoin45Period == 0)
			return 0f;
		else
			return (nbrCompteMoin45Period * 100.0f) / nbrComptePeriod;
	}

	private Float calculRatioCompteEntre4555Period(Integer nbrCompteEntre4555Period) {
		if (nbrComptePeriod == 0 || nbrCompteEntre4555Period == 0)
			return 0f;
		else
			return (nbrCompteEntre4555Period * 100.0f) / nbrComptePeriod;
	}

	private Float calculRatioComptePlus55Period(Integer nbrComptePlus55Period) {
		if (nbrComptePeriod == 0 || nbrComptePlus55Period == 0)
			return 0f;
		else
			return (nbrComptePlus55Period * 100.0f) / nbrComptePeriod;
	}

	private Float calculRatioCompteFcGlobal(Integer nbrCompteFcGlobal) {
		if (nbrCompteGlobal == 0 || nbrCompteFcGlobal == 0)
			return 0f;
		else
			return (nbrCompteFcGlobal * 100.0f) / nbrCompteGlobal;
	}

	private Float calculRatioCompteHommeGlobal(Integer nbrCompteHommeGlobal) {
		if (nbrCompteGlobal == 0 || nbrCompteHommeGlobal == 0)
			return 0f;
		else
			return (nbrCompteHommeGlobal * 100.0f) / nbrCompteGlobal;
	}

	private Float calculRatioCompteFemmeGlobal(Integer nbrCompteFemmeGlobal) {
		if (nbrCompteGlobal == 0 || nbrCompteFemmeGlobal == 0)
			return 0f;
		else
			return (nbrCompteFemmeGlobal * 100.0f) / nbrCompteGlobal;
	}

	private Float calculRatioCompteMoin45Global(Integer nbrCompteMoin45Global) {
		if (nbrCompteGlobal == 0 || nbrCompteMoin45Global == 0)
			return 0f;
		else
			return (nbrCompteMoin45Global * 100.0f) / nbrCompteGlobal;
	}

	private Float calculRatioCompteEntre4555Global(Integer nbrCompteEntre4555Global) {
		if (nbrCompteGlobal == 0 || nbrCompteEntre4555Global == 0)
			return 0f;
		else
			return (nbrCompteEntre4555Global * 100.0f) / nbrCompteGlobal;
	}

	private Float calculRatioComptePlus55Global(Integer nbrComptePlus55Global) {
		if (nbrCompteGlobal == 0 || nbrComptePlus55Global == 0)
			return 0f;
		else
			return (nbrComptePlus55Global * 100.0f) / nbrCompteGlobal;
	}

	/**
	 * GETTERS
	 * 
	 * @return
	 */

	public Integer getNbrCompteFemmePeriod() {
		return nbrCompteFemmePeriod;
	}
	public Integer getNbrCompteGlobal() {
		return nbrCompteGlobal;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public Integer getNbrComptePeriod() {
		return nbrComptePeriod;
	}

	public Integer getNbrCompteLocauxPeriod() {
		return nbrCompteLocauxPeriod;
	}

	public Integer getNbrCompteFcPeriod() {
		return nbrCompteFcPeriod;
	}

	public Float getRatioCompteFcPeriod() {
		return ratioCompteFcPeriod;
	}

	public Integer getNbrCompteSuppPeriod() {
		return nbrCompteSuppPeriod;
	}

	public Integer getNbrCompteMoin45Global() {
		return nbrCompteMoin45Global;
	}
	public Integer getNbrCompteHommePeriod() {
		return nbrCompteHommePeriod;
	}
	public Float getRatioCompteHommePeriod() {
		return ratioCompteHommePeriod;
	}

	public Float getRatioCompteFemmePeriod() {
		return ratioCompteFemmePeriod;
	}

	public Float getRatioCompteMoin45Period() {
		return ratioCompteMoin45Period;
	}

	public Float getRatioCompteEntre4555Period() {
		return ratioCompteEntre4555Period;
	}

	public Float getRatioComptePlus55Period() {
		return ratioComptePlus55Period;
	}

	public Integer getNbrTransFcPeriod() {
		return nbrTransFcPeriod;
	}

	public Integer getNbrCompteLocauxGlobal() {
		return nbrCompteLocauxGlobal;
	}

	public Integer getNbrCompteFcGlobal() {
		return nbrCompteFcGlobal;
	}

	public Float getRatioCompteFcGlobal() {
		return ratioCompteFcGlobal;
	}

	public Integer getNbrCompteSuppGlobal() {
		return nbrCompteSuppGlobal;
	}

	public Float getRatioCompteHommeGlobal() {
		return ratioCompteHommeGlobal;
	}

	public Float getRatioCompteFemmeGlobal() {
		return ratioCompteFemmeGlobal;
	}

	public Float getRatioCompteMoin45Global() {
		return ratioCompteMoin45Global;
	}

	public Float getRatioCompteEntre4555Global() {
		return ratioCompteEntre4555Global;
	}

	public Float getRatioComptePlus55Global() {
		return ratioComptePlus55Global;
	}

	public Integer getNbrTransFcGlobal() {
		return nbrTransFcGlobal;
	}

	public Integer getNbrAccesComptePeriod() {
		return nbrAccesComptePeriod;
	}

	public Float getRatioAccesCompteFcPeriod() {
		return ratioAccesCompteFcPeriod;
	}
	public Integer getNbrComptePlus55Global() {
		return nbrComptePlus55Global;
	}
	public Integer getNbrCompteHommeGlobal() {
		return nbrCompteHommeGlobal;
	}
	public Integer getNbrCompteFemmeGlobal() {
		return nbrCompteFemmeGlobal;
	}
	public Integer getNbrCompteMoin45Period() {
		return nbrCompteMoin45Period;
	}
	public Integer getNbrComptePlus55Period() {
		return nbrComptePlus55Period;
	}
	public Integer getNbrCompteEntre4555Period() {
		return nbrCompteEntre4555Period;
	}

	public Integer getNbrCompteEntre4555Global() {
		return nbrCompteEntre4555Global;
	}

}
