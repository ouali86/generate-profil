package cnav.gipur.pci.generator.stat.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;

import cnav.gipur.pci.batch.exceptions.BuisinessException;
import cnav.gipur.pci.batch.exceptions.TechnicalException;
import cnav.gipur.pci.batch.model.StatDTO;
import cnav.gipur.pci.batch.model.UserDTO;
import cnav.gipur.pci.batch.profil.impl.StatisticImpl;

/**
 * 
 * @author ZEX9977
 *
 */
public class StatProcessor implements ItemProcessor<UserDTO, StatDTO> {

	/**
	 * The Default Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(StatProcessor.class);

	/**
	 * Singleton
	 */
    private StatisticImpl statistic;

	private JobExecution jobExecution;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		jobExecution = stepExecution.getJobExecution();
	}

	@Override
    public StatDTO process(UserDTO userDto) {
	// LOG.info("StatProcessor : process : ");
	// LOG.info("DateCreation : " + userDto.getDateCreation() + " NIR : " +
	// userDto.getNir());
			try {
			statistic.incrementGlobalVarsByUser(userDto);
			} catch (BuisinessException | TechnicalException exception) {
				if (exception instanceof TechnicalException) {
					LOG.error("StatProcessor : Exception technique : ", exception);
					throw new RuntimeException(exception);
				} else if (exception instanceof BuisinessException) {
					LOG.error(
							"StatProcessor : Exception metier : " + ((BuisinessException) exception).getErrorMessage());
					jobExecution.addFailureException(exception);
				}
			}

		return null;
	}

    public StatisticImpl getStatistic() {
		return statistic;
	}

    public void setStatistic(StatisticImpl statistic) {
		this.statistic = statistic;
	}

}
