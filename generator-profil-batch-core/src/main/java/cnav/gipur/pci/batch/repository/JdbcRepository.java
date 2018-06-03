package cnav.gipur.pci.batch.repository;

import java.util.Date;
import java.util.Map;

import cnav.gipur.pci.batch.exceptions.TechnicalException;
import cnav.gipur.pci.batch.utils.TypeConnexion;

/**
 * 
 * @author ZEX9977
 *
 */
public interface JdbcRepository {

	Date findFcTransitionByNir(String nir) throws TechnicalException;

	Map<TypeConnexion, Integer> findPciAccessByNir(String nir, Date fromDate, Date toDate) throws TechnicalException;

}
