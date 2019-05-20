


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CalisanIslemleri {
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ArrayList<Calisan> calisanlariGetir() {
        
        ArrayList<Calisan> cikti = new ArrayList<Calisan>();
        
        try {
            statement =  con.createStatement();
            String sorgu =  "Select * From personel";
            
            ResultSet rs =  statement.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String telefon  = rs.getString("telefon");
                String adres = rs.getString("adres");
                String email = rs.getString("email");
                String tc = rs.getString("tc");
                String gorev = rs.getString("gorev");
                java.util.Date isegiris = rs.getDate("tarih");
                
                cikti.add(new Calisan(id, ad, soyad, telefon, adres, email, tc, gorev,isegiris));
                
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
        
        
        
        
    }
    public void calisanGuncelle(int id,String yeni_ad,String yeni_soyad,String yeni_telefon,String yeni_adres,String yeni_email,String yeni_tc,String yeni_gorev,java.util.Date yeni_tarih) {
        String sorgu =  "Update personel set ad = ? , soyad = ? , telefon = ? , adres = ?, email = ? , tc = ? , gorev = ? , tarih = ? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,yeni_ad);
            preparedStatement.setString(2,yeni_soyad);
            
            preparedStatement.setString(3,yeni_telefon);
            preparedStatement.setString(4,yeni_adres);
            
            preparedStatement.setString(5, yeni_email);
            preparedStatement.setString(6, yeni_tc);
            preparedStatement.setString(7, yeni_gorev);
            
            preparedStatement.setDate(8, new java.sql.Date( yeni_tarih.getTime() ));

            
            preparedStatement.setInt(9, id);
            
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void calisanSil(int id) {
        
        String sorgu = "Delete from personel where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    public void calisanEkle(String ad,String soyad,String telefon,String adres,String email,java.util.Date tarih,String tc,String gorev) {
        
        String sorgu = "Insert Into personel (ad,soyad,telefon,adres,email,tc,tarih,jobid,gorev) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, telefon);
            preparedStatement.setString(4, adres);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, tc);
            
            preparedStatement.setDate(7, new java.sql.Date( tarih.getTime() ));
            
            preparedStatement.setInt(8, 3);
            preparedStatement.setString(9, gorev);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
    
        
        
        
        
        
        
        
    
    public CalisanIslemleri() {
        
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
        
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        
        
        try {
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Bağlantı Başarılı...");
            
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }
        
        
    }


    
    
}
