package oslomet.webprog;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name ="Motorvogn")
public class Motorvogn {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "PERSONNR")
    private String personnr;
    @Column(name = "NAVN")
    private String navn;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "KJENNETEGN")
    private String kjennetegn;
    @Column(name = "MERKE")
    private String merke;
    @Column(name = "TYPE")
    private String type;

    public Motorvogn(String personnr, String navn, String adresse, String kjennetegn, String merke, String type) {
        this.personnr = personnr;
        this.navn = navn;
        this.adresse = adresse;
        this.kjennetegn = kjennetegn;
        this.merke = merke;
        this.type = type;
    }

    public Motorvogn() {
    }
//gettere og settere

    public String getPersonnr() {
        return personnr;
    }

    public void setPersonnr(String personnr) {
        this.personnr = personnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getKjennetegn() {
        return kjennetegn;
    }

    public void setKjennetegn(String kjennetegn) {
        this.kjennetegn = kjennetegn;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

