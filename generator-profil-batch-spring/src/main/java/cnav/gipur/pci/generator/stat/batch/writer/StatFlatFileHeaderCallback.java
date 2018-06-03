package cnav.gipur.pci.generator.stat.batch.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

/**
 * 
 * @author ZEX9977
 *
 */
public class StatFlatFileHeaderCallback implements FlatFileHeaderCallback {
	// delimiter
	private String delimiteur;

	public void setDelimiteur(String delimiteur) {
		this.delimiteur = delimiteur;
	}

	//
	private String colonneDate;
	private String colonneDebutPeriode;
	private String colonneFinPeriode;
	private String colonneNbrComptePeriode;
	private String colonneNbrCompteLocauxPeriode;
	private String colonneNbrCompteFcPeriode;
	private String colonneRatioCompteFcPeriode;
	private String colonneNbrCompteSuppPeriode;
	private String colonneNbrCompteHomme;
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
	private String colonneNbrCompteMoin45Periode;
	private String colonneNbrCompteEntre4555Periode;
	private String colonneNbrComptePlus55Periode;
	
 
	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write('\ufeff');
		writer.write(colonneDate);
		writer.write(delimiteur);
		writer.write(colonneDebutPeriode);
		writer.write(delimiteur);
		writer.write(colonneFinPeriode);
		writer.write(delimiteur);
		writer.write(colonneNbrComptePeriode);
		writer.write(delimiteur);
		writer.write(colonneNbrCompteLocauxPeriode);
		writer.write(delimiteur);
		writer.write(colonneNbrCompteFcPeriode);
		writer.write(delimiteur);
		writer.write(colonneRatioCompteFcPeriode);
		writer.write(delimiteur);
		writer.write(colonneNbrCompteSuppPeriode);
		writer.write(delimiteur);		
		writer.write(colonneNbrCompteHomme);
		writer.write(delimiteur);		
		writer.write(colonneNbrCompteMoin45Periode);
		writer.write(delimiteur);
		writer.write(colonneNbrCompteEntre4555Periode);
		writer.write(delimiteur);	
		writer.write(colonneNbrComptePlus55Periode);
		writer.write(delimiteur);			
		writer.write(colonneRatioCompteHommePeriode);
		writer.write(delimiteur);
		writer.write(colonneRatioCompteFemmePeriode);
		writer.write(delimiteur);
		writer.write(colonneRatioCompteMoin45Periode);
		writer.write(delimiteur);
		writer.write(colonneRatioCompteEntre4555Periode);
		writer.write(delimiteur);
		writer.write(colonneRatioComptePlus55Periode);
		writer.write(delimiteur);
		writer.write(colonneNbrTransFcPeriode);
		writer.write(delimiteur);
		writer.write(colonneNbrCompteGlobal);
		writer.write(delimiteur);
		writer.write(colonneNbrCompteLocauxGlobal);
		writer.write(delimiteur);
		writer.write(colonneNbrCompteFcGlobal);
		writer.write(delimiteur);
		writer.write(colonneRatioCompteFcGlobal);
		writer.write(delimiteur);
		writer.write(colonneNbrCompteSuppGlobal);
		writer.write(delimiteur);
		writer.write(colonneRatioCompteHommeGlobal);
		writer.write(delimiteur);
		writer.write(colonneRatioCompteFemmeGlobal);
		writer.write(delimiteur);
		writer.write(colonneRatioCompteMoin45Global);
		writer.write(delimiteur);
		writer.write(colonneRatioCompteEntre4555Global);
		writer.write(delimiteur);
		writer.write(colonneRatioComptePlus55Global);
		writer.write(delimiteur);
		writer.write(colonneNbrTransFcGlobal);
	}

	public String getColonneNbrCompteHomme() {
		return colonneNbrCompteHomme;
	}

	public void setColonneNbrCompteHomme(String colonneNbrCompteHomme) {
		this.colonneNbrCompteHomme = colonneNbrCompteHomme;
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
	public String getColonneNbrCompteMoin45Periode() {
		return colonneNbrCompteMoin45Periode;
	}

	public void setColonneNbrCompteMoin45Periode(String colonneNbrCompteMoin45Periode) {
		this.colonneNbrCompteMoin45Periode = colonneNbrCompteMoin45Periode;
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
