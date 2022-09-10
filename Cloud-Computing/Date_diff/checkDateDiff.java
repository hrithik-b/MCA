import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;


@WebServlet(urlPatterns = {"/checkDateDiff"})
public class checkDateDiff extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet checkDateDiff</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Difference between Dates</h1>");
            
            
            String db1 = request.getParameter("date1");
            String db2 = request.getParameter("date2");
            
            String dba1[ ] = db1.split("-");
            String dba2[ ] = db2.split("-");
            
           
            
            LocalDate dob1 = LocalDate.of(Integer.parseInt(dba1[0]),Integer.parseInt(dba1[1]),Integer.parseInt(dba1[2]));
            
            LocalDate dob2 = LocalDate.of(Integer.parseInt(dba2[0]),Integer.parseInt(dba2[1]),Integer.parseInt(dba2[2]));
            Period diff = Period.between(dob1,dob2);
            
          
            String res = " "+diff.getYears() + " Years " + diff.getMonths() + " Months " + diff.getDays() +  " Days";
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
    }// </editor-fold>

}
