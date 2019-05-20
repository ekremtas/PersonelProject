
import java.util.Date;

public class Calisan {
    
    private int id;
    private String ad;
    private String soyad;
    private String telefon;
    private String adres;
    private String email;
    private String tc;
    private String gorev;
    private java.util.Date isegiris;
    
    public Calisan(int id, String ad, String soyad, String telefon, String adres, String email,String tc,String gorev,Date isegiris) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.adres = adres;
        this.email = email;
        this.tc = tc;
        this.gorev = gorev;
        this.isegiris = isegiris;
    }

    Calisan(int id, String ad, String soyad, String telefon, String adres, String email, String tc, Date egiris, String gorev) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }
    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
    }
    public Date getIsegiris() {
        return isegiris;
    }

    public void setIsegiris(Date isegiris) {
        this.isegiris = isegiris;
    }
    
    
}
