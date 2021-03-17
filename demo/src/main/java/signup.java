import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class signup extends HttpServlet {
    //this sign up page for pharmacist
    private PharmacyService data=new PharmacyService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher r=req.getRequestDispatcher("signup.jsp");
        r.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pharmacyName=req.getParameter("pharmacyName");
        int pharmacyID=Integer.parseInt(req.getParameter("pharmacyID"));
        String Email=req.getParameter("Email");
        String phoneNumber=req.getParameter("phoneNumber");
        String pass=(req.getParameter("pass"));
        String Address=(req.getParameter("Address"));
        String status="new";

        Pharmacy pharmacy=new Pharmacy();
        pharmacy.setPharmacyName(pharmacyName);
        pharmacy.setPharmacyID(pharmacyID);
        pharmacy.setEmail(Email);
        pharmacy.setPhoneNumber(phoneNumber);
        pharmacy.setPassword(pass);
        pharmacy.setStatus(status);
        pharmacy.setAddress(Address);

        //put data in database
        try {
            data.PharmacySignUp(pharmacy);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dis=req.getRequestDispatcher("signup.jsp");
        dis.forward(req,resp);



    }
}
