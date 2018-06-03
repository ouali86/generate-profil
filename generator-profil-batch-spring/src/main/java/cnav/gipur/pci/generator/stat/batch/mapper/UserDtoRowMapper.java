package cnav.gipur.pci.generator.stat.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import cnav.gipur.pci.batch.model.UserDTO;

/**
 * 
 * @author ZEX9977
 *
 */
public class UserDtoRowMapper implements RowMapper<UserDTO> {
	
	/**
	 * Default logger
	 */
    private static final Logger LOG = LoggerFactory.getLogger(UserDtoRowMapper.class);

    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
	    String nir = rs.getString("nir");
	    Date dt_naissance = parseDate(rs.getString("dt_naissance"), "dd/MM/yyyy");
	    Date dt_crea = rs.getTimestamp("dt_crea");
	    Date dt_crea_fed = rs.getTimestamp("dt_crea_fed");
	    Date dt_sup = rs.getTimestamp("dt_sup");
	    Date dateTransFc = rs.getTimestamp("dateTransFc");
	    UserDTO user = new UserDTO(rs.getString("cn"), nir, dt_naissance, dt_sup, dt_crea, dt_crea_fed,
		    rs.getString("type_compte"), dateTransFc);

	    return user;
	} catch (SQLException sqlException) {
			LOG.error("{}", sqlException.getMessage());
			throw new RuntimeException(sqlException);
		}

	}
    
    private Date parseDate(String date, String format)
    {
	if (!StringUtils.isEmpty(date)) {
	    try {
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		return formatter.parse(date);
	    } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
        return null;
    }

}
