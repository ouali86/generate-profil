package cnav.gipur.pci.batch.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import cnav.gipur.pci.batch.exceptions.TechnicalException;
import cnav.gipur.pci.batch.repository.JdbcRepository;
import cnav.gipur.pci.batch.utils.TypeConnexion;

/**
 * 
 * @author ZEX9977
 *
 */
public class JdbcRepositoryImpl implements JdbcRepository {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String FC_TRANSITION_QUERY;

	private final String PCI_ACCESS_QUERY;

	public JdbcRepositoryImpl(String queryFcTransition, String pciAccessQuery) {
		this.FC_TRANSITION_QUERY = queryFcTransition;
		this.PCI_ACCESS_QUERY = pciAccessQuery;
	}

	@Override
	public Date findFcTransitionByNir(String nir) throws TechnicalException {
		try {
			final Date dateTransitionFc = jdbcTemplate.queryForObject(FC_TRANSITION_QUERY, Date.class,
					new Object[] { nir, "Transformation compte PCI / FC niv 2", "OK" });
			return dateTransitionFc;
		} catch (DataAccessException dataAccessException) {
			throw new TechnicalException(dataAccessException.getMessage());
		}

	}

	@Override
	public Map<TypeConnexion, Integer> findPciAccessByNir(String nir, Date fromDate, Date toDate)
			throws TechnicalException {
		try {
			final Map<TypeConnexion, Integer> nbrAccesPciMap = jdbcTemplate.query(PCI_ACCESS_QUERY,
					new ResultSetMapper(), new Object[] { nir, fromDate, toDate });
			return nbrAccesPciMap;
		} catch (DataAccessException dataAccessException) {
			throw new TechnicalException(dataAccessException.getMessage());
		}
	}

	/**
	 * 
	 * @author ZEX9977
	 *
	 */
	private class ResultSetMapper implements ResultSetExtractor<Map<TypeConnexion, Integer>> {

		@Override
		public Map<TypeConnexion, Integer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			final Map<TypeConnexion, Integer> resultMap = new HashMap<TypeConnexion, Integer>();
			while (resultSet.next()) {
				resultMap.put((TypeConnexion.LOCALE.getValue().equals(resultSet.getString("key")))
						? TypeConnexion.LOCALE : TypeConnexion.FRANCE_CONNECT, resultSet.getInt("value"));
			}
			return resultMap;
		}
	}

}
