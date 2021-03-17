import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq=req.getRequestDispatcher("login.jsp");
        rq.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher rq=req.getRequestDispatcher("login.jsp");
//        rq.forward(req,resp);
        PharmacyService p = new PharmacyService();
        Pharmacy pharmacy=new Pharmacy();

        String pharmacyName=req.getParameter("pharmacyName");
        int pharmacyID=Integer.parseInt(req.getParameter("pharmacyID"));
        String pass=(req.getParameter("pass"));
        pharmacy.setPharmacyID(pharmacyID);
        pharmacy.setPharmacyName(pharmacyName);
        pharmacy.setPassword(pass);

        PrintWriter out = resp.getWriter();
        try {
            if(p.login(pharmacy)){
                RequestDispatcher rq=req.getRequestDispatcher("login.jsp");
                rq.forward(req,resp);
            }
            else{
                out.println("Pharmacy name or Password incorrect, please try again ^^ ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
