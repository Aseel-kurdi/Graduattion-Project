import javax.servlet.http.HttpServlet;

public class Pharmacy extends HttpServlet {
    private String pharmacyName;
    private String email;
    private int pharmacyID;
    private String phoneNumber;
    private String password;
    private String status;
    private String Address;


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(int pharmacyID) {
        this.pharmacyID = pharmacyID;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
