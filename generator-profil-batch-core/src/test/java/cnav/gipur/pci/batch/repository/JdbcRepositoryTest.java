package cnav.gipur.pci.batch.repository;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cnav.gipur.pci.batch.exceptions.TechnicalException;
import cnav.gipur.pci.batch.utils.TypeConnexion;

/**
 * 
 * @author ZEX9977
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/jdbc_datasource.xml" })
public class JdbcRepositoryTest {

	private static final String NIR = "1234567891234";
	private static final String DATA_FILE_PATH = "./src/test/resources/trace_dataset.xml";
	private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss.SSS";

	@Autowired
	private JdbcRepository jdbcRepository;

	@Autowired
	private DataSource dataSource;

	@Before
	public void setUp() throws Exception {
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File(DATA_FILE_PATH));
		ReplacementDataSet replacementDataSet = new ReplacementDataSet(dataSet);
		replacementDataSet.addReplacementObject("[NULL]", null);
		IDatabaseConnection databaseConnection = new DatabaseDataSourceConnection(dataSource);
		DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, dataSet);
	}

	@Test
	public void findFcTransitionByNirTest() throws Exception {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

		final Date dateTransitionFc = jdbcRepository.findFcTransitionByNir(NIR);
		Assert.assertNotNull(dateTransitionFc);
		Assert.assertEquals(simpleDateFormat.parse("2016-06-15 14:02:00.013"), dateTransitionFc);
	}

	/**
	 * SELECT evenement AS key , count(*) AS value FROM tpcittrace WHERE
	 * datecreation BETWEEN '2017-02-18 00:00:00' AND '2017-03-20 00:00:00' AND
	 * evenement IN ('Connexion','Connexion FC') AND decision = 'OK' GROUP BY
	 * evenement
	 * 
	 * @throws ParseException
	 * @throws TechnicalException
	 */
	@Test
	public void findPciAccessByNirTest() throws ParseException {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
			final Map<TypeConnexion, Integer> map = jdbcRepository.findPciAccessByNir(NIR, simpleDateFormat.parse("2017-03-01 00:00:00.000"),
					simpleDateFormat.parse("2017-03-03 00:00:00.000"));
			Assert.assertNotNull(map);
			Assert.assertEquals(2, map.size());
			Assert.assertSame(2, map.get(TypeConnexion.LOCALE));
			Assert.assertSame(1, map.get(TypeConnexion.FRANCE_CONNECT));
		} catch (TechnicalException e) {
			e.printStackTrace();
		}
	}

}
