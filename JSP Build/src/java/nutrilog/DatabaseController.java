package nutrilog;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getPathInfo();
        String url = "";
        switch (action) {
            case "/registration.jsp":
                url = "/registration.jsp";
                break;
            case "/manage":
                url = manage(request, response);
                break;
            default:
                response.sendError(404, "This isn't the page you're looking for.");
        }

        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        String url = "";
        switch (action) {
            case "/registration":
                url = addPatient(request, response);
                break;
            default:
                response.sendError(404, "Page Not Found");
        }

        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    private String manage(HttpServletRequest request,
            HttpServletResponse response) {
        //List checkedOutList = CheckoutDb.selectCheckedOutBooks();
        //request.setAttribute("checkedOutList", checkedOutList);
        return "/checkedOutList.jsp";
    }

    private String addPatient(HttpServletRequest request, HttpServletResponse response) {
        Person person = new Person();
        person.setFirstName(request.getParameter("firstName"));
        person.setLastName(request.getParameter("lastName"));
        person.setGender(request.getParameter("gender").charAt(0));
        String d = request.getParameter("dob");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date=format.parse(d);
        }
        catch (ParseException pe) {
        }
        person.setDOB(date);
        NutriLogDB.addPerson(person);
        return "/registration.jsp";
    }

    private String doCheckin(HttpServletRequest request,
            HttpServletResponse response) {
        long checkoutNumber =
                Long.parseLong(request.getParameter("checkoutNumber"));
        //NutriLogDB.addPerson(Person p);
        return manage(request, response);
    }
}
