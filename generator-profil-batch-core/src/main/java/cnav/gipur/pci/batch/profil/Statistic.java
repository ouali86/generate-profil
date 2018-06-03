package cnav.gipur.pci.batch.profil;

import cnav.gipur.pci.batch.exceptions.BuisinessException;
import cnav.gipur.pci.batch.exceptions.TechnicalException;
import cnav.gipur.pci.batch.model.StatDTO;
import cnav.gipur.pci.batch.model.UserDTO;

/**
 * 
 * @author ZEX9977
 *
 */
public interface Statistic {

	StatDTO getStatResult();

    void incrementGlobalVarsByUser(final UserDTO userDTO)
			throws BuisinessException, TechnicalException;

}
