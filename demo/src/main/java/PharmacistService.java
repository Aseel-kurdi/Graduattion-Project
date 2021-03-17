import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;


public class PharmacistService {
    public int signUp(Pharmacist pharmacist) throws Exception {
        int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduation", "EMP", "EMP");
        Statement st = con.createStatement();
        String query = "insert into pharmacist values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, pharmacist.getPharmacyName());
        pst.setString(2, pharmacist.getPharmacyID());
        pst.setString(3, pharmacist.getPharmacistFirstName());
        pst.setString(4, pharmacist.getPharmacistLastName());
        pst.setInt(5, pharmacist.getPharmacistSyndicalNumber());
        pst.setString(6, pharmacist.getEmail());
        pst.setString(7, pharmacist.getPhoneNumber());
        pst.setString(8, hashPassword(pharmacist));
        pst.setString(9, pharmacist.getStatus());
        result = pst.executeUpdate();
        st.close();
        con.close();
        return result;
    }

    private String hashPassword(Pharmacist pharmacist) throws NoSuchAlgorithmException {
        byte[] password = String.valueOf(pharmacist.getPharmacistSyndicalNumber())
                .concat(pharmacist.getPassword())
                .getBytes(StandardCharsets.UTF_8);
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        return new String(md.digest(password));
    }


    public ArrayList<Pharmacist> getData() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduation", "EMP", "EMP");
        Statement st = con.createStatement();
        String que = " Select * from pharmacist";
        ResultSet rs = st.executeQuery(que);
        ArrayList<Pharmacist> pharmacistInfo = new ArrayList<Pharmacist>();

        while (rs.next()) {
            if (!rs.getString(9).equals("new"))
                continue;
            Pharmacist newPha = new Pharmacist();
            newPha.setPharmacyName(rs.getString(1));
            newPha.setPharmacyID(rs.getString(2));
            newPha.setPharmacistFirstName(rs.getString(3));
            newPha.setPharmacistLastName(rs.getString(4));
            newPha.setPharmacistSyndicalNumber(rs.getInt(5));
            newPha.setEmail(rs.getString(6));
            newPha.setPhoneNumber(rs.getString(7));
            newPha.setPassword(rs.getString(8));
            newPha.setStatus(rs.getString(9));
            pharmacistInfo.add(newPha);
        }
        st.close();
        con.close();
        return pharmacistInfo;


    }

    public void updateStatus(String status, String id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduation", "EMP", "EMP");
        Statement st = con.createStatement();
        String query = " UPDATE pharmacist SET sta_tus = '" + status + "' where PharmacistsyndicalNumber = " + Integer.parseInt(id);
        PreparedStatement pst = con.prepareStatement(query);
        int result = pst.executeUpdate();
        st.close();
        con.close();

    }
    public boolean login(Pharmacist pharmacist)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduation", "EMP", "EMP");
        Statement st = con.createStatement();
        String que = " Select * from pharmacist";
        ResultSet rs = st.executeQuery(que);
            if (rs.getInt(5)==pharmacist.getPharmacistSyndicalNumber() &&
                    rs.getString(8)==hashPassword(pharmacist)) {
               return true;
            }
            else{
                return false;
            }
        }


}
