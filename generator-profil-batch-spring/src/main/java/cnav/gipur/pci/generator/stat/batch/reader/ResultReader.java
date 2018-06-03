package cnav.gipur.pci.generator.stat.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import cnav.gipur.pci.batch.model.StatDTO;
import cnav.gipur.pci.batch.profil.Statistic;

/**
 * 
 * @author ZEX9977
 *
 */
public class ResultReader implements ItemReader<StatDTO> {

	private Statistic statistic;

	private Integer executionIndex = 0;

	@Override
	public StatDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		executionIndex++;
		if (executionIndex > 1)
			return null;
		return statistic.getStatResult();
	}

	public Statistic getStatistic() {
		return statistic;
	}

	public void setStatistic(Statistic statistic) {
		this.statistic = statistic;
	}

	public Integer getExecutionIndex() {
		return executionIndex;
	}

	public void setExecutionIndex(Integer executionIndex) {
		this.executionIndex = executionIndex;
	}

}
