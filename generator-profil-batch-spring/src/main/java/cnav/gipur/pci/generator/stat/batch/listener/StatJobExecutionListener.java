package cnav.gipur.pci.generator.stat.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

public class StatJobExecutionListener implements JobExecutionListener {

	/**
	 * Default logger
	 */
	private static final Logger log = LoggerFactory.getLogger(StatJobExecutionListener.class);

	private ExitStatus error;
	private ExitStatus report;
	private ExitStatus success;

	@BeforeJob
	public void beforeJob(JobExecution jobExecution) {
		log.info("beforeJob - JobName : {}", jobExecution.getJobInstance().getJobName());
		log.info("beforeJob - StartTime : {}", jobExecution.getStartTime());
	}

	@AfterJob
	public void afterJob(JobExecution jobExecution) {
		log.info("afterJob - JobName : {}", jobExecution.getJobInstance().getJobName());
		log.info("afterJob - EndTime : {}", jobExecution.getEndTime());
		if (BatchStatus.FAILED.equals(jobExecution.getStatus())) {
			jobExecution.setExitStatus(error);
		} else if (jobExecution.getAllFailureExceptions().size() != 0) {
			jobExecution.setExitStatus(report);
		} else {
			jobExecution.setExitStatus(success);
		}
		log.info("afterJob - Status  : {}", jobExecution.getStatus());
		log.info("afterJob - CODE RETOUR  : {}", jobExecution.getExitStatus());
		System.exit(Integer.valueOf(jobExecution.getExitStatus().getExitCode()));
	}

	public void setError(ExitStatus error) {
		this.error = error;
	}

	public void setReport(ExitStatus report) {
		this.report = report;
	}

	public void setSuccess(ExitStatus success) {
		this.success = success;
	}
}
