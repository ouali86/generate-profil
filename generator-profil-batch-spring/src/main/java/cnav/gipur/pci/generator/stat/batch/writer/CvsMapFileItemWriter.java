package cnav.gipur.pci.generator.stat.batch.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.batch.item.ItemWriter;

import cnav.gipur.pci.batch.model.StatDTO;
import cnav.gipur.pci.batch.utils.CSVUtils;

/**
 * 
 * @author ZEX9977
 *
 */
public class CvsMapFileItemWriter implements ItemWriter<StatDTO> {

	private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm";

	private static final String FLOAT_PATERN_FORMAT = "%.2f";
	private static final String INTEGER_PATERN_FORMAT = "%02d";

	private static final Locale LOCAL = Locale.FRANCE;

	private String filePath;
	private String colonneDate;
	private String colonneDebutPeriode;
	private String colonneFinPeriode;
	private String colonneNbrAccesRetraitePeriode;
	private String colonneRatioAccesRetraiteFcPeriode;
	private String colonneNbrComptePeriode;
	private String colonneNbrCompteLocauxPeriode;
	private String colonneNbrCompteFcPeriode;
	private String colonneRatioCompteFcPeriode;
	private String colonneNbrCompteSuppPeriode;
	private String colonneRatioCompteHommePeriode;
	
	
	private String colonneRatioCompteFemmePeriode;
	private String colonneRatioCompteMoin45Periode;
	

	private String colonneRatioCompteEntre4555Periode;
	private String colonneRatioComptePlus55Periode;
	private String colonneNbrTransFcPeriode;
	private String colonneNbrCompteGlobal;
	private String colonneNbrCompteLocauxGlobal;
	private String colonneNbrCompteFcGlobal;
	private String colonneRatioCompteFcGlobal;
	private String colonneNbrCompteSuppGlobal;
	private String colonneRatioCompteHommeGlobal;
	private String colonneRatioCompteFemmeGlobal;
	private String colonneRatioCompteMoin45Global;
	
	
	private String colonneRatioCompteEntre4555Global;
	private String colonneRatioComptePlus55Global;
	private String colonneNbrTransFcGlobal;
	
	private String colonneNbrCompteHommePeriode;	
	private String colonneNbrCompteFemmePeriode;

	private String colonneNbrCompteMoin45Periode;
	private String colonneNbrCompteEntre4555Periode;
	private String colonneNbrComptePlus55Periode;


	private String colonneNbrCompteHommeGlobal;	
	private String colonneNbrCompteFemmeGlobal;
	private String colonneNbrCompteMoin45Global;
	private String colonneNbrCompteEntre4555Global;
	private String colonneNbrComptePlus55Global;


	@Override
	public void write(List<? extends StatDTO> items) throws Exception {
		if (items == null)
			throw new Exception("CvsMapFileItemWriter : write : Pas de stat reçues");
		if (items.get(0) == null)
			throw new Exception("CvsMapFileItemWriter : write : Pas de stat reçues");
		final StatDTO statDTO = items.get(0);
		//
		final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		final File fileDir = new File(filePath);
		final OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileDir), StandardCharsets.UTF_8);
		CSVUtils.writeLine(writer, Arrays.asList(colonneDate, dateFormat.format(statDTO.getCurrentDate())));
		CSVUtils.writeLine(writer, Arrays.asList(colonneDebutPeriode, dateFormat.format(statDTO.getFromDate())));
		CSVUtils.writeLine(writer, Arrays.asList(colonneFinPeriode, dateFormat.format(statDTO.getToDate())));
		CSVUtils.writeLine(writer,
				Arrays.asList(colonneNbrAccesRetraitePeriode, statDTO.getNbrAccesComptePeriod().toString()));
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioAccesRetraiteFcPeriode,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioAccesCompteFcPeriod()) + "%"));
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrComptePeriode, statDTO.getNbrComptePeriod().toString()));
		CSVUtils.writeLine(writer,
				Arrays.asList(colonneNbrCompteLocauxPeriode, statDTO.getNbrCompteLocauxPeriod().toString()));
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteFcPeriode, statDTO.getNbrCompteFcPeriod().toString()));
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioCompteFcPeriode,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioCompteFcPeriod()) + "%"));
		CSVUtils.writeLine(writer,
				Arrays.asList(colonneNbrCompteSuppPeriode, statDTO.getNbrCompteSuppPeriod().toString()));
		/////////nbr
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteHommePeriode,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrCompteHommePeriod())));
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteFemmePeriode,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrCompteFemmePeriod())));
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteMoin45Periode,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrCompteMoin45Period())));
		
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteEntre4555Periode,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrCompteEntre4555Period())));
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrComptePlus55Periode,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrComptePlus55Period())));
		///////////////
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioCompteHommePeriode,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioCompteHommePeriod()) + "%"));

		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioCompteFemmePeriode,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioCompteFemmePeriod()) + "%"));
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioCompteMoin45Periode,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioCompteMoin45Period()) + "%"));

		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioCompteEntre4555Periode,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioCompteEntre4555Period()) + "%"));
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioComptePlus55Periode,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioComptePlus55Period()) + "%"));
	 
		
		
		 
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrTransFcPeriode, statDTO.getNbrTransFcPeriod().toString()));
		// SAUT DE LIGNE
		CSVUtils.writeLine(writer, Arrays.asList("", ""));
		// SAUT DE LIGNE
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteGlobal, statDTO.getNbrCompteGlobal().toString()));
		CSVUtils.writeLine(writer,
				Arrays.asList(colonneNbrCompteLocauxGlobal, statDTO.getNbrCompteLocauxGlobal().toString()));
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteFcGlobal, statDTO.getNbrCompteFcGlobal().toString()));
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioCompteFcGlobal,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioCompteFcGlobal()) + "%"));
		CSVUtils.writeLine(writer,
				Arrays.asList(colonneNbrCompteSuppGlobal, statDTO.getNbrCompteSuppGlobal().toString()));
		/////////nbr
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteHommeGlobal,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrCompteHommeGlobal())));
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteFemmeGlobal,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrCompteFemmeGlobal())));
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteMoin45Global,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrCompteMoin45Global())));
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrCompteEntre4555Global,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrCompteEntre4555Global())));
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrComptePlus55Global,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrComptePlus55Global())));


		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrComptePlus55Global,
				String.format(LOCAL, INTEGER_PATERN_FORMAT, statDTO.getNbrComptePlus55Global())));
		
		///////////////////
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioCompteHommeGlobal,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioCompteHommeGlobal()) + "%"));
		 
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioCompteFemmeGlobal,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioCompteFemmeGlobal()) + "%"));
 
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioCompteMoin45Global,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioCompteMoin45Global()) + "%"));
 
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioCompteEntre4555Global,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioCompteEntre4555Global()) + "%"));
 
		CSVUtils.writeLine(writer, Arrays.asList(colonneRatioComptePlus55Global,
				String.format(LOCAL, FLOAT_PATERN_FORMAT, statDTO.getRatioComptePlus55Global()) + "%"));
 
		CSVUtils.writeLine(writer, Arrays.asList(colonneNbrTransFcGlobal, statDTO.getNbrTransFcGlobal().toString()));
		//
		writer.flush();
		writer.close();
	}

	public String getcolonneDate() {
		return colonneDate;
	}

	public void setColonneDate(String colonneDate) {
		this.colonneDate = colonneDate;
	}

	public String getcolonneDebutPeriode() {
		return colonneDebutPeriode;
	}

	public void setColonneDebutPeriode(String colonneDebutPeriode) {
		this.colonneDebutPeriode = colonneDebutPeriode;
	}

	public String getcolonneFinPeriode() {
		return colonneFinPeriode;
	}

	public void setColonneFinPeriode(String colonneFinPeriode) {
		this.colonneFinPeriode = colonneFinPeriode;
	}

	public String getcolonneNbrComptePeriode() {
		return colonneNbrComptePeriode;
	}

	public void setColonneNbrComptePeriode(String colonneNbrComptePeriode) {
		this.colonneNbrComptePeriode = colonneNbrComptePeriode;
	}

	public String getcolonneNbrCompteLocauxPeriode() {
		return colonneNbrCompteLocauxPeriode;
	}

	public void setColonneNbrCompteLocauxPeriode(String colonneNbrCompteLocauxPeriode) {
		this.colonneNbrCompteLocauxPeriode = colonneNbrCompteLocauxPeriode;
	}

	public String getcolonneNbrCompteFcPeriode() {
		return colonneNbrCompteFcPeriode;
	}

	public void setColonneNbrCompteFcPeriode(String colonneNbrCompteFcPeriode) {
		this.colonneNbrCompteFcPeriode = colonneNbrCompteFcPeriode;
	}

	public String getcolonneRatioCompteFcPeriode() {
		return colonneRatioCompteFcPeriode;
	}

	public void setColonneRatioCompteFcPeriode(String colonneRatioCompteFcPeriode) {
		this.colonneRatioCompteFcPeriode = colonneRatioCompteFcPeriode;
	}

	public String getcolonneNbrCompteSuppPeriode() {
		return colonneNbrCompteSuppPeriode;
	}

	public void setColonneNbrCompteSuppPeriode(String colonneNbrCompteSuppPeriode) {
		this.colonneNbrCompteSuppPeriode = colonneNbrCompteSuppPeriode;
	}

	public String getcolonneRatioCompteHommePeriode() {
		return colonneRatioCompteHommePeriode;
	}

	public void setColonneRatioCompteHommePeriode(String colonneRatioCompteHommePeriode) {
		this.colonneRatioCompteHommePeriode = colonneRatioCompteHommePeriode;
	}

 
	public String getcolonneRatioCompteFemmePeriode() {
		return colonneRatioCompteFemmePeriode;
	}

	public void setColonneRatioCompteFemmePeriode(String colonneRatioCompteFemmePeriode) {
		this.colonneRatioCompteFemmePeriode = colonneRatioCompteFemmePeriode;
	}

	public String getcolonneRatioCompteMoin45Periode() {
		return colonneRatioCompteMoin45Periode;
	}

	public void setColonneRatioCompteMoin45Periode(String colonneRatioCompteMoin45Periode) {
		this.colonneRatioCompteMoin45Periode = colonneRatioCompteMoin45Periode;
	}

	public String getcolonneRatioCompteEntre4555Periode() {
		return colonneRatioCompteEntre4555Periode;
	}

	public void setColonneRatioCompteEntre4555Periode(String colonneRatioCompteEntre4555Periode) {
		this.colonneRatioCompteEntre4555Periode = colonneRatioCompteEntre4555Periode;
	}

	public String getcolonneRatioComptePlus55Periode() {
		return colonneRatioComptePlus55Periode;
	}

	public void setColonneRatioComptePlus55Periode(String colonneRatioComptePlus55Periode) {
		this.colonneRatioComptePlus55Periode = colonneRatioComptePlus55Periode;
	}

	public String getcolonneNbrTransFcPeriode() {
		return colonneNbrTransFcPeriode;
	}

	public void setColonneNbrTransFcPeriode(String colonneNbrTransFcPeriode) {
		this.colonneNbrTransFcPeriode = colonneNbrTransFcPeriode;
	}

	public String getcolonneNbrCompteGlobal() {
		return colonneNbrCompteGlobal;
	}

	public void setColonneNbrCompteGlobal(String colonneNbrCompteGlobal) {
		this.colonneNbrCompteGlobal = colonneNbrCompteGlobal;
	}

	public String getcolonneNbrCompteLocauxGlobal() {
		return colonneNbrCompteLocauxGlobal;
	}

	public void setColonneNbrCompteLocauxGlobal(String colonneNbrCompteLocauxGlobal) {
		this.colonneNbrCompteLocauxGlobal = colonneNbrCompteLocauxGlobal;
	}

	public String getcolonneNbrCompteFcGlobal() {
		return colonneNbrCompteFcGlobal;
	}

	public void setColonneNbrCompteFcGlobal(String colonneNbrCompteFcGlobal) {
		this.colonneNbrCompteFcGlobal = colonneNbrCompteFcGlobal;
	}

	public String getcolonneRatioCompteFcGlobal() {
		return colonneRatioCompteFcGlobal;
	}

	public void setColonneRatioCompteFcGlobal(String colonneRatioCompteFcGlobal) {
		this.colonneRatioCompteFcGlobal = colonneRatioCompteFcGlobal;
	}

	public String getcolonneNbrCompteSuppGlobal() {
		return colonneNbrCompteSuppGlobal;
	}

	public void setColonneNbrCompteSuppGlobal(String colonneNbrCompteSuppGlobal) {
		this.colonneNbrCompteSuppGlobal = colonneNbrCompteSuppGlobal;
	}

	public String getcolonneRatioCompteHommeGlobal() {
		return colonneRatioCompteHommeGlobal;
	}

	public void setColonneRatioCompteHommeGlobal(String colonneRatioCompteHommeGlobal) {
		this.colonneRatioCompteHommeGlobal = colonneRatioCompteHommeGlobal;
	}

	public String getcolonneRatioCompteFemmeGlobal() {
		return colonneRatioCompteFemmeGlobal;
	}

	public void setColonneRatioCompteFemmeGlobal(String colonneRatioCompteFemmeGlobal) {
		this.colonneRatioCompteFemmeGlobal = colonneRatioCompteFemmeGlobal;
	}

	public String getcolonneRatioCompteMoin45Global() {
		return colonneRatioCompteMoin45Global;
	}

	public void setColonneRatioCompteMoin45Global(String colonneRatioCompteMoin45Global) {
		this.colonneRatioCompteMoin45Global = colonneRatioCompteMoin45Global;
	}

	public String getColonneNbrCompteMoin45Global() {
		return colonneNbrCompteMoin45Global;
	}

	public void setColonneNbrCompteMoin45Global(String colonneNbrCompteMoin45Global) {
		this.colonneNbrCompteMoin45Global = colonneNbrCompteMoin45Global;
	}
	
	public String getcolonneRatioCompteEntre4555Global() {
		return colonneRatioCompteEntre4555Global;
	}

	public void setColonneRatioCompteEntre4555Global(String colonneRatioCompteEntre4555Global) {
		this.colonneRatioCompteEntre4555Global = colonneRatioCompteEntre4555Global;
	}

	public String getcolonneRatioComptePlus55Global() {
		return colonneRatioComptePlus55Global;
	}

	public void setColonneRatioComptePlus55Global(String colonneRatioComptePlus55Global) {
		this.colonneRatioComptePlus55Global = colonneRatioComptePlus55Global;
	}

	public String getcolonneNbrTransFcGlobal() {
		return colonneNbrTransFcGlobal;
	}

	public void setColonneNbrTransFcGlobal(String colonneNbrTransFcGlobal) {
		this.colonneNbrTransFcGlobal = colonneNbrTransFcGlobal;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getColonneNbrAccesRetraitePeriode() {
		return colonneNbrAccesRetraitePeriode;
	}

	public void setColonneNbrAccesRetraitePeriode(String colonneNbrAccesRetraitePeriode) {
		this.colonneNbrAccesRetraitePeriode = colonneNbrAccesRetraitePeriode;
	}

	public String getColonneRatioAccesRetraiteFcPeriode() {
		return colonneRatioAccesRetraiteFcPeriode;
	}

	public void setColonneRatioAccesRetraiteFcPeriode(String colonneRatioAccesRetraiteFcPeriode) {
		this.colonneRatioAccesRetraiteFcPeriode = colonneRatioAccesRetraiteFcPeriode;
	}

	public String getColonneNbrCompteEntre4555Global() {
		return colonneNbrCompteEntre4555Global;
	}

	public void setColonneNbrCompteEntre4555Global(String colonneNbrCompteEntre4555Global) {
		this.colonneNbrCompteEntre4555Global = colonneNbrCompteEntre4555Global;
	}
	public String getColonneNbrCompteMoin45Periode() {
		return colonneNbrCompteMoin45Periode;
	}

	public void setColonneNbrCompteMoin45Periode(String colonneNbrCompteMoin45Periode) {
		this.colonneNbrCompteMoin45Periode = colonneNbrCompteMoin45Periode;
	}
	public String getColonneNbrComptePlus55Global() {
		return colonneNbrComptePlus55Global;
	}

	public void setColonneNbrComptePlus55Global(String colonneNbrComptePlus55Global) {
		this.colonneNbrComptePlus55Global = colonneNbrComptePlus55Global;
	}
	public String getColonneNbrCompteHommePeriode() {
		return colonneNbrCompteHommePeriode;
	}

	public void setColonneNbrCompteHommePeriode(String colonneNbrCompteHommePeriode) {
		this.colonneNbrCompteHommePeriode = colonneNbrCompteHommePeriode;
	}

	
	public String getColonneNbrCompteFemmePeriode() {
		return colonneNbrCompteFemmePeriode;
	}

	public void setColonneNbrCompteFemmePeriode(String colonneNbrCompteFemmePeriode) {
		this.colonneNbrCompteFemmePeriode = colonneNbrCompteFemmePeriode;
	}
	public String getColonneNbrCompteHommeGlobal() {
		return colonneNbrCompteHommeGlobal;
	}

	public void setColonneNbrCompteHommeGlobal(String colonneNbrCompteHommeGlobal) {
		this.colonneNbrCompteHommeGlobal = colonneNbrCompteHommeGlobal;
	}
	public String getColonneNbrCompteFemmeGlobal() {
		return colonneNbrCompteFemmeGlobal;
	}

	public void setColonneNbrCompteFemmeGlobal(String colonneNbrCompteFemmeGlobal) {
		this.colonneNbrCompteFemmeGlobal = colonneNbrCompteFemmeGlobal;
	}
	public String getColonneNbrCompteEntre4555Periode() {
		return colonneNbrCompteEntre4555Periode;
	}

	public void setColonneNbrCompteEntre4555Periode(String colonneNbrCompteEntre4555Periode) {
		this.colonneNbrCompteEntre4555Periode = colonneNbrCompteEntre4555Periode;
	}
	public String getColonneNbrComptePlus55Periode() {
		return colonneNbrComptePlus55Periode;
	}

	public void setColonneNbrComptePlus55Periode(String colonneNbrComptePlus55Periode) {
		this.colonneNbrComptePlus55Periode = colonneNbrComptePlus55Periode;
	}
}
