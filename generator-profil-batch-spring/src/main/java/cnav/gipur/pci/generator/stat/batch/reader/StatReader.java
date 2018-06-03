package cnav.gipur.pci.generator.stat.batch.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import cnav.gipur.pci.batch.model.UserDTO;

/**
 * 
 * @author ZEX9977
 *
 */
public class StatReader implements ItemReader<List<UserDTO>> {

	/**
	 * The Default Logger
	 */
    // private static final Logger LOG =
    // LoggerFactory.getLogger(StatReader.class);

	/**
	 * LDAP
	 */
    // private LdapRepository ldapRepository;

	/**
	 * DB
	 */
    // private JdbcRepository jdbcRepository;

    @Override
    public List<UserDTO> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	// TODO Auto-generated method stub
	return null;
    }

	// private List<UserDTO> userList;
    /*
     * private DataSource dataSource;
     * 
     * @Override public List<UserDTO> read() throws Exception,
     * UnexpectedInputException, ParseException, NonTransientResourceException {
     * 
     * LOG.debug("StatReader : read : "); JdbcPagingItemReader<UserDTO>
     * databaseReader = new JdbcPagingItemReader<>();
     * databaseReader.setDataSource(dataSource); databaseReader.setPageSize(10);
     * 
     * PagingQueryProvider queryProvider = createQueryProvider();
     * databaseReader.setQueryProvider(queryProvider);
     * databaseReader.setRowMapper(new ParameterizedRowMapper<UserDTO>() {
     * 
     * @Override public UserDTO mapRow(ResultSet rs, int rowNum) throws
     * SQLException {
     * 
     * String nir = rs.getString("nir"); UserDTO user = new
     * UserDTO(rs.getString("cn"), nir, rs.getDate("dt_naissance"),
     * rs.getDate("dt_sup"), rs.getDate("dt_crea"),
     * rs.getString("type_compte")); if
     * (TypeCompte.FC.getValue().equals(user.getTypeCompte())) { try {
     * user.setDateTransitionFc(jdbcRepository.findFcTransitionByNir(nir)); }
     * catch (TechnicalException exception) { LOG.error(
     * "StatReader : Exception technique : ", exception); throw new
     * RuntimeException(exception); } }
     * 
     * return user; } });
     * 
     * final List<UserDTO> userList = ldapRepository.getUsers(); if (null !=
     * userList) { for (UserDTO userDTO : userList) { if
     * (TypeCompte.FC.getValue().equals(userDTO.getTypeCompte())) { try {
     * userDTO.setDateTransitionFc(jdbcRepository.findFcTransitionByNir(userDTO.
     * getNir())); } catch (TechnicalException exception) { LOG.error(
     * "StatReader : Exception technique : ", exception); throw new
     * RuntimeException(exception); } } } } return databaseReader; }
     * 
     * public void setLdapRepository(LdapRepository ldapRepository) {
     * this.ldapRepository = ldapRepository; }
     * 
     * public void setJdbcRepository(JdbcRepository jdbcRepository) {
     * this.jdbcRepository = jdbcRepository; }
     * 
     * public void setDataSource(DataSource dataSource) { this.dataSource =
     * dataSource; }
     * 
     * private PagingQueryProvider createQueryProvider() {
     * PostgresPagingQueryProvider queryProvider = new
     * PostgresPagingQueryProvider(); queryProvider.setSelectClause(
     * "SELECT cn, nir, dt_naissance, dt_sup, dt_crea, type_compte");
     * queryProvider.setFromClause("FROM tpcitassure");
     * 
     * return queryProvider; }
     */
}
