import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

public class PharmacyService {


    public int PharmacySignUp(Pharmacy pharmacy) throws Exception {
        //set data in table******************************************
        int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduation", "EMP", "EMP");
        Statement st = con.createStatement();
        String query = "insert into pharmacy values(?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, pharmacy.getPharmacyID());
        pst.setString(2, pharmacy.getPharmacyName());
        pst.setString(3,pharmacy.getEmail());
        pst.setString(4, pharmacy.getPhoneNumber());
        pst.setString(5, hashPassword(pharmacy));
        pst.setString(6, pharmacy.getStatus());
        pst.setString(7, pharmacy.getAddress());
        result = pst.executeUpdate();
        st.close();
        con.close();
        return result;
    }

    private String hashPassword(Pharmacy pharmacy) throws NoSuchAlgorithmException {
        byte[] password = String.valueOf(pharmacy.getPharmacyID())
                .concat(pharmacy.getPassword())
                .getBytes(StandardCharsets.UTF_8);
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        return new String(md.digest(password));
    }

    public ArrayList<Pharmacy> getData() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduation", "EMP", "EMP");
        Statement st = con.createStatement();
        String que = " Select * from pharmacy";
        ResultSet rs = st.executeQuery(que);
        ArrayList<Pharmacy> pharmacyInfo = new ArrayList<Pharmacy>();

        while (rs.next()) {
            if (!rs.getString(6).equals("new"))
                continue;
            Pharmacy newPha = new Pharmacy();
            newPha.setPharmacyName(rs.getString(2));
            newPha.setPharmacyID(rs.getInt(1));
            newPha.setEmail(rs.getString(3));
            newPha.setPhoneNumber(rs.getString(4));
            newPha.setPassword(rs.getString(5));
            newPha.setStatus(rs.getString(6));
            newPha.setAddress(rs.getString(7));
            pharmacyInfo.add(newPha);
        }
        st.close();
        con.close();
        return pharmacyInfo;
    }


    public void updateStatus(String status, String id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduation", "EMP", "EMP");
        Statement st = con.createStatement();
        String query = " UPDATE pharmacy SET sta_tus = '" + status + "' where PharmacyID = " + Integer.parseInt(id);
        PreparedStatement pst = con.prepareStatement(query);
        int result = pst.executeUpdate();
        st.close();
        con.close();

    }
    public boolean login(Pharmacy pharmacy)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduation", "EMP", "EMP");
        Statement st = con.createStatement();
        String que = " Select * from pharmacy";
        ResultSet rs = st.executeQuery(que);
            if(pharmacy.getStatus()!="new"){
                while (rs.next()) {
                    if (rs.getInt(1) == pharmacy.getPharmacyID() &&
                            rs.getString(5) == hashPassword(pharmacy)) {
                        return true;
                    }
                }
            }
                return false;



    }
}
