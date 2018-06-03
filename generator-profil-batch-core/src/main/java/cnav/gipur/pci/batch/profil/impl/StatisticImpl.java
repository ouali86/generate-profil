package cnav.gipur.pci.batch.profil.impl;

import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cnav.gipur.pci.batch.exceptions.BuisinessException;
import cnav.gipur.pci.batch.exceptions.TechnicalException;
import cnav.gipur.pci.batch.model.StatDTO;
import cnav.gipur.pci.batch.model.UserDTO;
import cnav.gipur.pci.batch.profil.Statistic;
import cnav.gipur.pci.batch.repository.JdbcRepository;
import cnav.gipur.pci.batch.utils.TypeCompte;
import cnav.gipur.pci.batch.utils.TypeConnexion;

/**
 * 
 * @author ZEX9977
 *
 */
public class StatisticImpl implements Statistic {

	/**
	 * The Default Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(StatisticImpl.class);

	private static final String NIR_PATTERN = "^[1,2]{1}[0-9]{5}[0-9A-B]{1}[0-9]{6}$";

	/**
	 * Global VARs
	 */

	//
	private Date currentDate;
	private Date fromDate;
	private Date toDate;
	private Integer period;
	private Integer nbrAccesComptePeriod;
	private Integer nbrAccesCompteFcPeriod;
	private Integer nbrComptePeriod;
	private Integer nbrCompteLocauxPeriod;
	private Integer nbrCompteFcPeriod;
	private Integer nbrCompteSuppPeriod;
	private Integer nbrCompteHommePeriod;
	private Integer nbrCompteFemmePeriod;
	private Integer nbrCompteMoin45Period;
	private Integer nbrCompteEntre4555Period;
	private Integer nbrComptePlus55Period;
	private Integer nbrTransFcPeriod;
	private Integer nbrCompteGlobal;
	private Integer nbrCompteLocauxGlobal;
	private Integer nbrCompteFcGlobal;
	private Integer nbrCompteSuppGlobal;
	private Integer nbrCompteHommeGlobal;
	private Integer nbrCompteFemmeGlobal;
	private Integer nbrCompteMoin45Global;
	private Integer nbrCompteEntre4555Global;
	private Integer nbrComptePlus55Global;
	private Integer nbrTransFcGlobal;



	/**
	 * JDBC repository
	 */
	private JdbcRepository jdbcRepository;

	public StatisticImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public StatDTO getStatResult() {
		return new StatDTO(currentDate, fromDate, toDate, nbrAccesComptePeriod, nbrAccesCompteFcPeriod, nbrComptePeriod,
				nbrCompteLocauxPeriod, nbrCompteFcPeriod, nbrCompteSuppPeriod, nbrCompteHommePeriod,
				nbrCompteFemmePeriod, nbrCompteMoin45Period, nbrCompteEntre4555Period, nbrComptePlus55Period,
				nbrTransFcPeriod, nbrCompteGlobal, nbrCompteLocauxGlobal, nbrCompteFcGlobal, nbrCompteSuppGlobal,
				nbrCompteHommeGlobal, nbrCompteFemmeGlobal, nbrCompteMoin45Global, nbrCompteEntre4555Global,
		nbrComptePlus55Global, nbrTransFcGlobal);
	}

	@Override
    public void incrementGlobalVarsByUser(final UserDTO userDTO)
			throws BuisinessException, TechnicalException {
	// LOG.info("Statistic : incrementGlobalVarsByUser ");
		if (isUserValid(userDTO)) {
	    incrementStatistic(userDTO);
		}

	}

	private Boolean isUserValid(final UserDTO userDTO) throws BuisinessException {
		Boolean valid = Boolean.TRUE;
		final Pattern nirPattern = Pattern.compile(NIR_PATTERN);
		if (!nirPattern.matcher(userDTO.getNir()).matches()) {
			valid = Boolean.FALSE;
			throw new BuisinessException(
					"StatisticImpl : incrementGlobalVars : isUserValid : Format nir incorret pour le CN : "
							+ userDTO.getCn());
		}
		if (!TypeCompte.LOCAL.getValue().equals(userDTO.getTypeCompte())
				&& !TypeCompte.FC.getValue().equals(userDTO.getTypeCompte())) {
			valid = Boolean.FALSE;
			throw new BuisinessException(
					"StatisticImpl : incrementGlobalVars : isUserValid : Type compte invalid pour le CN: "
							+ userDTO.getCn());
		}
		if (userDTO.getDateNaissance() == null) {
			valid = Boolean.FALSE;
			throw new BuisinessException(
					"StatisticImpl : incrementGlobalVars : isUserValid : Date de naissance invalide pour le CN : "
							+ userDTO.getCn());
		}
		return valid;
	}

    private void incrementStatistic(final UserDTO userDTO)
			throws TechnicalException {
		try {
			incrementTransFcVars(userDTO);
			incrementAcountNumberVars(userDTO);
			
			incrementCivilityVars(userDTO);
			incrementSuppressionVars(userDTO);
			//incrementCompteHommeVars(userDTO);
			incrementAccountTypeVars(userDTO);
			incrementAgeSliceVars(userDTO);
			incrementPciAccessVars(userDTO);
		} catch (Exception exception) {
			LOG.debug(exception.getMessage());
		}
	}

	private void incrementPciAccessVars(UserDTO userDTO) throws TechnicalException {
		final Map<TypeConnexion, Integer> map = jdbcRepository.findPciAccessByNir(userDTO.getNir(), fromDate, toDate);
		nbrAccesComptePeriod = nbrAccesComptePeriod
				+ ((map.get(TypeConnexion.LOCALE) != null) ? map.get(TypeConnexion.LOCALE) : 0)
				+ ((map.get(TypeConnexion.FRANCE_CONNECT) != null) ? map.get(TypeConnexion.FRANCE_CONNECT) : 0);
		nbrAccesCompteFcPeriod = nbrAccesCompteFcPeriod
				+ ((map.get(TypeConnexion.FRANCE_CONNECT) != null) ? map.get(TypeConnexion.FRANCE_CONNECT) : 0);
	}

	private void incrementTransFcVars(final UserDTO userDTO) {
		if (userDTO.getDateTransitionFc() != null) {
			nbrTransFcGlobal++;
	    // Date dateTransition = userDTO.getDateTransitionFc();
	    Boolean inPeriod = isInPeriodOfDate(userDTO.getDateTransitionFc());
	    LOG.debug("Date transf" + userDTO.getDateTransitionFc() + " in period " + inPeriod);
			if (inPeriod) {

				nbrTransFcPeriod++;
			}

		}
	}

	private void incrementAcountNumberVars(final UserDTO userDTO) {
		nbrCompteGlobal++;
	if (isInPeriodOfDate(userDTO.getDateCreation()) || isInPeriodOfDate(userDTO.getDateCreationFed())) {
			nbrComptePeriod++;
		}
	}

	private void incrementCivilityVars(final UserDTO userDTO) throws Exception {
		LOG.debug("incrementCivilityVars nbrCompteHommeGlobal: "+nbrCompteHommeGlobal+" nbrCompteHommePeriod "+nbrCompteHommePeriod);
		
		if (userDTO.getNir() == null || userDTO.getNir().length() == 0)
			throw new Exception("nir nul ou vide.");
		else if (userDTO.getNir().startsWith("1")) {
			nbrCompteHommeGlobal++;
	    if (isInPeriodOfDate(userDTO.getDateCreation()) || isInPeriodOfDate(userDTO.getDateCreationFed())) {
				nbrCompteHommePeriod++;
				 LOG.debug("nbrCompteHommePeriod" + nbrCompteHommePeriod+ " in period entre " + userDTO.getDateCreation() +" et " +userDTO.getDateCreationFed());
			}
		} else if (userDTO.getNir().startsWith("2")) {
			nbrCompteFemmeGlobal++;
	    if (isInPeriodOfDate(userDTO.getDateCreation()) || isInPeriodOfDate(userDTO.getDateCreationFed())) {
				nbrCompteFemmePeriod++;
			}
		} else {
			throw new Exception("nir invalid : " + userDTO.getNir());
		}
	}

	private void incrementSuppressionVars(final UserDTO userDTO) {
		if (userDTO.getDateSuppression() != null) {
			nbrCompteSuppGlobal++;
	    Boolean inPeriod = isInPeriodOfDate(userDTO.getDateSuppression());
	    if (inPeriod) {
				nbrCompteSuppPeriod++;
			}
		}
	}
	
	private void incrementCompteHommeVars(final UserDTO userDTO) {
		if (userDTO.getDateSuppression() != null) {
			nbrCompteHommePeriod++;
	    Boolean inPeriod = isInPeriodOfDate(userDTO.getDateSuppression());
	    if (inPeriod) {
	    	nbrCompteHommePeriod++;
			}
		}
	}

	private void incrementAccountTypeVars(final UserDTO userDTO) throws Exception {
		if (userDTO.getTypeCompte() == null || userDTO.getTypeCompte().length() == 0)
			throw new Exception("Type compte invalid : " + userDTO.getNir());
		else if (TypeCompte.LOCAL.getValue().equals(userDTO.getTypeCompte())) {
			nbrCompteLocauxGlobal++;
			if (isInPeriodOfDate(userDTO.getDateCreation())) {
				nbrCompteLocauxPeriod++;
			}
		} else if (TypeCompte.FC.getValue().equals(userDTO.getTypeCompte())) {
			nbrCompteFcGlobal++;
	    if (null != userDTO.getDateCreationFed()) {
		if (isInPeriodOfDate(userDTO.getDateCreationFed())) {
		    nbrCompteFcPeriod++;
		}

	    } else {
		if (isInPeriodOfDate(userDTO.getDateCreation())) {
		    nbrCompteFcPeriod++;
		}
	    }

		} else {
			throw new Exception("Type compte invalid : " + userDTO.getNir());
		}
	}

	private void incrementAgeSliceVars(final UserDTO userDTO) throws Exception {
		if (userDTO.getDateNaissance() == null)
			throw new Exception("Date de naissance invalid : " + userDTO.getNir());
		else {
			final LocalDate currentDate = new LocalDate();
			final LocalDate localDtBirthday = new LocalDate(userDTO.getDateNaissance());
			final Years age = Years.yearsBetween(localDtBirthday, currentDate);
			if (age.getYears() < 45) {
				nbrCompteMoin45Global++;
		if (isInPeriodOfDate(userDTO.getDateCreation()) || isInPeriodOfDate(userDTO.getDateCreationFed())) {
					nbrCompteMoin45Period++;
				}
			} else if (age.getYears() <= 54) {
				nbrCompteEntre4555Global++;
		if (isInPeriodOfDate(userDTO.getDateCreation()) || isInPeriodOfDate(userDTO.getDateCreationFed())) {
					nbrCompteEntre4555Period++;
				}
			} else {
				nbrComptePlus55Global++;
		if (isInPeriodOfDate(userDTO.getDateCreation()) || isInPeriodOfDate(userDTO.getDateCreationFed())) {
					nbrComptePlus55Period++;
				}
			}
		}
	}

	private Boolean isInPeriodOfDate(Date date) {
		if (date == null) {
			return Boolean.FALSE;
		}

		final Instant fromInstant = new Instant(fromDate);
		final Instant dateInstant = new Instant(date);
		final Instant toInstant = new Instant(toDate);
		if (dateInstant.isAfter(fromInstant) && dateInstant.isBefore(toInstant)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	/**
	 * GETTERS & SETTERS
	 */

	public void setNbrCompteGlobal(Integer nbrCompteGlobal) {
		this.nbrCompteGlobal = nbrCompteGlobal;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Integer getNbrComptePeriod() {
		return nbrComptePeriod;
	}

	public void setNbrComptePeriod(Integer nbrComptePeriod) {
		this.nbrComptePeriod = nbrComptePeriod;
	}

	public Integer getNbrCompteLocauxPeriod() {
		return nbrCompteLocauxPeriod;
	}

	public void setNbrCompteLocauxPeriod(Integer nbrCompteLocauxPeriod) {
		this.nbrCompteLocauxPeriod = nbrCompteLocauxPeriod;
	}

	public Integer getNbrCompteFcPeriod() {
		return nbrCompteFcPeriod;
	}

	public void setNbrCompteFcPeriod(Integer nbrCompteFcPeriod) {
		this.nbrCompteFcPeriod = nbrCompteFcPeriod;
	}

	public Integer getNbrCompteSuppPeriod() {
		return nbrCompteSuppPeriod;
	}

	public void setNbrCompteSuppPeriod(Integer nbrCompteSuppPeriod) {
		this.nbrCompteSuppPeriod = nbrCompteSuppPeriod;
	}

	public Integer getNbrCompteHommePeriod() {
		return nbrCompteHommePeriod;
	}

	public void setNbrCompteHommePeriod(Integer nbrCompteHommePeriod) {
		this.nbrCompteHommePeriod = nbrCompteHommePeriod;
	}

	public Integer getNbrCompteFemmePeriod() {
		return nbrCompteFemmePeriod;
	}

	public void setNbrCompteFemmePeriod(Integer nbrCompteFemmePeriod) {
		this.nbrCompteFemmePeriod = nbrCompteFemmePeriod;
	}

	public Integer getNbrCompteMoin45Period() {
		return nbrCompteMoin45Period;
	}

	public void setNbrCompteMoin45Period(Integer nbrCompteMoin45Period) {
		this.nbrCompteMoin45Period = nbrCompteMoin45Period;
	}

	public Integer getNbrCompteEntre4555Period() {
		return nbrCompteEntre4555Period;
	}

	public void setNbrCompteEntre4555Period(Integer nbrCompteEntre4555Period) {
		this.nbrCompteEntre4555Period = nbrCompteEntre4555Period;
	}

	public Integer getNbrComptePlus55Period() {
		return nbrComptePlus55Period;
	}

	public void setNbrComptePlus55Period(Integer nbrComptePlus55Period) {
		this.nbrComptePlus55Period = nbrComptePlus55Period;
	}

	public Integer getNbrTransFcPeriod() {
		return nbrTransFcPeriod;
	}

	public void setNbrTransFcPeriod(Integer nbrTransFcPeriod) {
		this.nbrTransFcPeriod = nbrTransFcPeriod;
	}

	public Integer getNbrCompteLocauxGlobal() {
		return nbrCompteLocauxGlobal;
	}

	public void setNbrCompteLocauxGlobal(Integer nbrCompteLocauxGlobal) {
		this.nbrCompteLocauxGlobal = nbrCompteLocauxGlobal;
	}

	public Integer getNbrCompteFcGlobal() {
		return nbrCompteFcGlobal;
	}

	public void setNbrCompteFcGlobal(Integer nbrCompteFcGlobal) {
		this.nbrCompteFcGlobal = nbrCompteFcGlobal;
	}

	public Integer getNbrCompteSuppGlobal() {
		return nbrCompteSuppGlobal;
	}

	public void setNbrCompteSuppGlobal(Integer nbrCompteSuppGlobal) {
		this.nbrCompteSuppGlobal = nbrCompteSuppGlobal;
	}

	public Integer getNbrCompteHommeGlobal() {
		return nbrCompteHommeGlobal;
	}

	public void setNbrCompteHommeGlobal(Integer nbrCompteHommeGlobal) {
		this.nbrCompteHommeGlobal = nbrCompteHommeGlobal;
	}

	public Integer getNbrCompteFemmeGlobal() {
		return nbrCompteFemmeGlobal;
	}

	public void setNbrCompteFemmeGlobal(Integer nbrCompteFemmeGlobal) {
		this.nbrCompteFemmeGlobal = nbrCompteFemmeGlobal;
	}

	public Integer getNbrCompteMoin45Global() {
		return nbrCompteMoin45Global;
	}

	public void setNbrCompteMoin45Global(Integer nbrCompteMoin45Global) {
		this.nbrCompteMoin45Global = nbrCompteMoin45Global;
	}

	public Integer getNbrCompteEntre4555Global() {
		return nbrCompteEntre4555Global;
	}

	public void setNbrCompteEntre4555Global(Integer nbrCompteEntre4555Global) {
		this.nbrCompteEntre4555Global = nbrCompteEntre4555Global;
	}

	public Integer getNbrComptePlus55Global() {
		return nbrComptePlus55Global;
	}

	public void setNbrComptePlus55Global(Integer nbrComptePlus55Global) {
		this.nbrComptePlus55Global = nbrComptePlus55Global;
	}

	public Integer getNbrTransFcGlobal() {
		return nbrTransFcGlobal;
	}

	public void setNbrTransFcGlobal(Integer nbrTransFcGlobal) {
		this.nbrTransFcGlobal = nbrTransFcGlobal;
	}

	public Integer getNbrCompteGlobal() {
		return nbrCompteGlobal;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public JdbcRepository getJdbcRepository() {
		return jdbcRepository;
	}

	public void setJdbcRepository(JdbcRepository jdbcRepository) {
		this.jdbcRepository = jdbcRepository;
	}

	public Integer getNbrAccesComptePeriod() {
		return nbrAccesComptePeriod;
	}

	public void setNbrAccesComptePeriod(Integer nbrAccesComptePeriod) {
		this.nbrAccesComptePeriod = nbrAccesComptePeriod;
	}

	public Integer getNbrAccesCompteFcPeriod() {
		return nbrAccesCompteFcPeriod;
	}

	public void setNbrAccesCompteFcPeriod(Integer nbrAccesCompteFcPeriod) {
		this.nbrAccesCompteFcPeriod = nbrAccesCompteFcPeriod;
	}


}
