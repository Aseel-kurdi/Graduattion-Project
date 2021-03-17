import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

// for pharmacy **********************************************************************************************************
public class ApprovalPage extends HttpServlet {

    PharmacyService pharmacyData = new PharmacyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Pharmacy> data= new ArrayList<Pharmacy>();
        try {
            data = pharmacyData.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("information",data);
        RequestDispatcher r=req.getRequestDispatcher("ApprovalPage.jsp");
        r.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String status = req.getParameter("status");
            String id = req.getParameter("id");
            pharmacyData.updateStatus(status,id);
            ArrayList<Pharmacy> data= new ArrayList<Pharmacy>();
            data = pharmacyData.getData();
            req.setAttribute("information",data);
            RequestDispatcher r=req.getRequestDispatcher("ApprovalPage.jsp");
            r.forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
