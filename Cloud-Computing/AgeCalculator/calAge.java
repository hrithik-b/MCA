import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;



@WebServlet(urlPatterns = {"/calAge"})
public class calAge extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calAge</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your Age</h1>");
            
            String s = request.getParameter("dob");
            String n[]=s.split("-");
            
            LocalDate dates=LocalDate.of(Integer.parseInt(n[0]),Integer.parseInt(n[1]), Integer.parseInt(n[2]));
          
            LocalDate now = LocalDate.now();
           
            LocalDate current;
            current = LocalDate.of(now.getYear(), now.getMonthValue(),now.getDayOfMonth());

            Period diff = Period.between(dates,current);
            String res = " "+ diff.getYears() + " years " + diff.getMonths() + " months " + diff.getDays() + " days";
            out.println(res);
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
