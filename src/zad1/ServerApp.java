package zad1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServerApp extends HttpServlet {

    DB db = new DB();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            
            resp.getWriter().write(db.getResultQuery(db.getConn(), ("SELECT ISBN, a.NAME, TYTUL, w.NAME, ROK, CENA FROM POZYCJE p " +
                    "JOIN AUTOR a ON a.AUTID = p.AUTID " +
                    "JOIN WYDAWCA w ON w.WYDID = p.WYDID " +
                    "WHERE " + ((req.getParameter("comboBox").equals("ROK") || req.getParameter("comboBox").equals("CENA")) ?
                    (req.getParameter("comboBox") + " = " + req.getParameter("Search")) :
                    (req.getParameter("comboBox") + " LIKE '%" + req.getParameter("Search") + "%'")))));




        }catch (Exception ex){ex.printStackTrace();}



    }
}
