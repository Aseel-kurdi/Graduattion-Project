import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupAndroid extends HttpServlet {
    //this sign up page for pharmacist
    private PharmacistService data=new PharmacistService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pharmacyName=req.getParameter("pharmacyName");
        String pharmacyID=req.getParameter("pharmacyID");
        String pharmacistFirstName=req.getParameter("pharmacistFirstName");
        String pharmacistLastName=req.getParameter("pharmacistLastName");
        int pharmacistSyndicalNumber=Integer.parseInt(req.getParameter("pharmacistSyndicalNumber"));
        String Email=req.getParameter("Email");
        String phoneNumber=req.getParameter("phoneNumber");
        String pass=(req.getParameter("pass"));
        String status="new";

        Pharmacist pharmacist=new Pharmacist();
        pharmacist.setPharmacyName(pharmacyName);
        pharmacist.setPharmacyID(pharmacyID);
        pharmacist.setPharmacistFirstName(pharmacistFirstName);
        pharmacist.setPharmacistLastName(pharmacistLastName);
        pharmacist.setPharmacistSyndicalNumber(pharmacistSyndicalNumber);
        pharmacist.setEmail(Email);
        pharmacist.setPhoneNumber(phoneNumber);
        pharmacist.setPassword(pass);
        pharmacist.setStatus(status);

        //put data in database
        try {
            data.signUp(pharmacist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dis=req.getRequestDispatcher("signup.jsp");
        dis.forward(req,resp);



    }
}
