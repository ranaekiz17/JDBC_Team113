import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;


public class JDBC_Query_1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

       // 1- Kullanilacak veritabanı için doğru sürücüyü ekle     // ilgili Driver'i yuklemeliyiz, mySQL'ı cagırıyorz.
                                                                  // Driver'i bulamama ihtimaline karsı forName methodu icin
                                                                  // ClassNotFoundException fırlatır.
        Class.forName("com.mysql.cj.jdbc.Driver");


        //  2-> Database baglantisi kurulur.        // data-base sahibinden yandaki bilgiler alınmak zorundadır.
         /*                                         // Url yoksa biz olustururuz.
          URL: "jdbc:mysql://194.140.198.209/heallife_hospitaltraining";
          USERNAME= "heallife_hospitaltraininguser";
          PASSWORD="PI2ZJx@9m^)3";                 // PASSWORD="mYJ5hf)Zh!AH";
         */

        Connection con = DriverManager.getConnection("jdbc:mysql://194.140.198.209/heallife_hospitaltraining",
                                                             "heallife_hospitaltraininguser",
                                                              "mYJ5hf)Zh!AH");
        // Olusturulan conenction bir objeye atanmasa da calisir
        // ancak ilerde ilgili connection'i kullanmak istersek ona ulasamayiz.
        // O yuzden onu Connection nesnesine atama yapariz.


        // 3-> SQL sorgularını yapabilmek için suite hazirla


        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        // ortalama data base ayarları bunlardır.

        // 4-> SQL sorgularini hazirla ve calistir.
                                                                    // bir ResultSet'in varolması için Statement'a
                                                                                // ihtiyaci vardir
        String query = "SELECT * FROM heallife_hospitaltraining.staff";
        ResultSet rs = st.executeQuery(query);                            // Query sadece sorgu icin yapilir, burada bilgi var mı var.

        rs.next();
        System.out.println(rs.getString("name"));

    }


}
