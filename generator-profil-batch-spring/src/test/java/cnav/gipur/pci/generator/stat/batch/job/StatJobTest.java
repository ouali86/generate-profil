/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnav.gipur.pci.generator.stat.batch.job;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "/test-context.xml", "/jobs/job.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class StatJobTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	@Test
	@Ignore("")
	public void testExampleJob() throws Exception {
		exit.expectSystemExitWithStatus(51);
		final JobParametersBuilder parametersBuilder = new JobParametersBuilder().addDate("schedule.time", new Date());
		final JobExecution jobExecution = jobLauncherTestUtils.launchJob(parametersBuilder.toJobParameters());
		exit.checkAssertionAfterwards(new Assertion() {
			@Override
			public void checkAssertion() throws Exception {
				assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
				assertEquals("51", jobExecution.getExitStatus().getExitCode());
			}
		});
	}
}
