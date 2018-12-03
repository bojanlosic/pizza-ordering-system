import java.io.Serializable;

/**
 * Created by Admin on 1/13/2018.
 */
public class Pica implements Serializable {
    private String velicina;
    private String vrsta;
    private String odPriloga;
    private String nacinPlacanja;
    private String adresa, brojTelefona, napomena;

    public Pica(){
        this.velicina = "";
        this.vrsta = "";
        this.odPriloga = "";
        this.nacinPlacanja = "";
        this.adresa = "";
        this.brojTelefona = "";
        this.napomena = "";
    }

    public Pica(String velicina, String vrsta, String odPriloga, String nacinPlacanja, String adresa, String brojTelefona, String napomena) {
        this.velicina = velicina;
        this.vrsta = vrsta;
        this.odPriloga = odPriloga;
        this.nacinPlacanja = nacinPlacanja;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.napomena = napomena;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getOdPriloga() {
        return odPriloga;
    }

    public void setOdPriloga(String odPriloga) {
        this.odPriloga = odPriloga;
    }

    public String getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String toString() {
        return "Narudzbina{ " + velicina + "; " + vrsta + "; " + odPriloga + "; " + nacinPlacanja + "; " + adresa + "; " + brojTelefona + "; " + napomena + '}';
    }
}
