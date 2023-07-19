import java.sql.SQLException;

public class JDBC_Query_2 {


    public static void main(String[] args) throws SQLException {

        /*
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con= DriverManager.getConnection("jdbc:mysql://194.140.198.209/heallife_hospitaltraining",
                "heallife_hospitaltraininguser",
                "PI2ZJx@9m^)3");

        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

         */

        Statement st = ResuableMethods.createStatement(ResuableMethods.getConnection());

        ResultSet rs = st.executeQuery("SELECT * FROM heallife_hospitaltraining.staff");

        rs.next();
        System.out.println(rs.getString("name")+" - "+rs.getInt("id")); //(Super Admin - 1) 1.sıradaki datayi getirir
        //System.out.println(rs.getInt(2)+" "+rs.getString(1));

        rs.next();
        rs.next();
        System.out.println(rs.getString("name")+" - "+rs.getInt("id")); // (Sansa - 4) 2.sıradaki datayi getirir

        rs.absolute(11);
        System.out.println(rs.getString("name")+" - "+ rs.getInt("id"));  // Reyan - 12

        rs.absolute(1);
        System.out.println(rs.getString("name")+" - "+ rs.getInt("id"));  //Super Admin - 1

    }
}
