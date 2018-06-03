package cnav.gipur.pci.batch.statistic;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cnav.gipur.pci.batch.exceptions.BuisinessException;
import cnav.gipur.pci.batch.exceptions.TechnicalException;
import cnav.gipur.pci.batch.model.StatDTO;
import cnav.gipur.pci.batch.model.UserDTO;
import cnav.gipur.pci.batch.profil.Statistic;
import cnav.gipur.pci.batch.repository.JdbcRepository;

/**
 * 
 * @author ZEX9977
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/statistic.xml" })
public class StatisticTest {

	@Autowired
	@InjectMocks
	private Statistic statistic;

	@Mock
	private JdbcRepository jdbcRepository;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void incrementGlobalVarsByUserTest() throws TechnicalException {
		/**
		 * user non valid
		 */
	UserDTO userDTO = new UserDTO("cn", "nir", new Date(), null, new Date(), new Date(), "local", new Date());
		try {
	    statistic.incrementGlobalVarsByUser(userDTO);
		} catch (BuisinessException | TechnicalException e) {
			// format nir
			Assert.assertTrue(e instanceof BuisinessException);
		}
	userDTO = new UserDTO("cn", "1234567891234", null, null, new Date(), new Date(), "local", new Date());
		try {
	    statistic.incrementGlobalVarsByUser(userDTO);
		} catch (BuisinessException | TechnicalException e) {
			// date naissance null
			Assert.assertTrue(e instanceof BuisinessException);
		}
	userDTO = new UserDTO("cn", "1234567891234", new Date(), null, new Date(), new Date(), "format_type_compte", new Date());
		try {
	    statistic.incrementGlobalVarsByUser(userDTO);
		} catch (BuisinessException | TechnicalException e) {
			// type compte format
			Assert.assertTrue(e instanceof BuisinessException);
		}
		/**
		 * OK local
		 */
	userDTO = new UserDTO("cn", "1234567891235", new Date(), null, new Date(), new Date(), "local", new Date());
		Mockito.when(jdbcRepository.findFcTransitionByNir("1234567891235")).thenReturn(null);
		try {
	    statistic.incrementGlobalVarsByUser(userDTO);
			final StatDTO statDTO = statistic.getStatResult();
			Assert.assertNotNull(statDTO);
			Assert.assertSame(0, statDTO.getNbrCompteFcGlobal());
			Assert.assertSame(0, statDTO.getNbrCompteFcPeriod());
			Assert.assertSame(1, statDTO.getNbrCompteGlobal());
			Assert.assertSame(1, statDTO.getNbrCompteLocauxGlobal());
			Assert.assertSame(0, statDTO.getNbrCompteLocauxPeriod());
			Assert.assertSame(0, statDTO.getNbrComptePeriod());
			Assert.assertSame(0, statDTO.getNbrCompteSuppGlobal());
			Assert.assertSame(0, statDTO.getNbrCompteSuppPeriod());
			Assert.assertSame(0, statDTO.getNbrCompteHommePeriod().intValue());
			Assert.assertSame(0, statDTO.getNbrCompteFemmePeriod().intValue());
			
			Assert.assertSame(1, statDTO.getNbrCompteHommeGlobal().intValue());
			Assert.assertSame(0, statDTO.getNbrCompteFemmeGlobal().intValue());
			
			Assert.assertSame(1, statDTO.getNbrCompteMoin45Global().intValue());
			
	    Assert.assertSame(1, statDTO.getNbrTransFcGlobal());
			Assert.assertSame(0, statDTO.getNbrTransFcPeriod());
			Assert.assertEquals(0, statDTO.getRatioCompteEntre4555Global(), 0);
			Assert.assertEquals(0, statDTO.getNbrCompteEntre4555Global(), 0);
			
			Assert.assertEquals(0, statDTO.getRatioCompteEntre4555Period(), 0);
			Assert.assertEquals(0, statDTO.getRatioCompteFcGlobal(), 0);
			Assert.assertEquals(0, statDTO.getRatioCompteFcPeriod(), 0);
			Assert.assertEquals(0, statDTO.getRatioCompteFemmeGlobal(), 0);
			Assert.assertEquals(0, statDTO.getRatioCompteFemmePeriod(), 0);
			Assert.assertEquals(100, statDTO.getRatioCompteHommeGlobal(), 0);
			Assert.assertEquals(0, statDTO.getRatioCompteHommePeriod(), 0);
			Assert.assertEquals(100, statDTO.getRatioCompteMoin45Global(), 0);
			Assert.assertEquals(0, statDTO.getRatioCompteMoin45Period(), 0);
			Assert.assertEquals(0, statDTO.getNbrCompteMoin45Period(), 0);
			
			Assert.assertEquals(0, statDTO.getRatioComptePlus55Global(), 0);
			Assert.assertEquals(0, statDTO.getRatioComptePlus55Period(), 0);
			Assert.assertEquals(0, statDTO.getNbrComptePlus55Global(), 0);
		} catch (BuisinessException | TechnicalException e) {
			
		}
	}

}
