package nutrilog;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
            case "/search.jsp":
                url = "/search.jsp";
                break;
            case "/results.jsp":
                url = searchByName(request, response);
                break;
            case "/information.jsp":
                loadInfo(request, response);
                url = searchByNumber(request, response);
                break;
            case "/event.jsp":
                url = "/event.jsp";
                break;
            default:
                response.sendError(404, "Page Not Found.");
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
            case "/registration.jsp":
                url = addPatient(request, response);
                break;
            case "/event.jsp":
                url = addEvent(request, response);
                break;
            default:
                response.sendError(404, "Page Not Found.");
        }

        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    private String searchByNumber(HttpServletRequest request,
            HttpServletResponse response) {
        Person person = NutriLogDB.searchByNumber(request.getParameter("searchValue"));
        request.setAttribute("results", person);
        return "/information.jsp";
    }
    
    private String searchByName(HttpServletRequest request,
            HttpServletResponse response) {
        List<Person> people = NutriLogDB.searchByName(request.getParameter("searchValue"));
        request.setAttribute("results", people);
        return "/results.jsp";
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
        person.setTOB(request.getParameter("tob"));
        int lbs = Integer.parseInt(request.getParameter("pounds"));
        int ozs = Integer.parseInt(request.getParameter("ounces"));
        person.setBirthWeight(lbs, ozs);
        NutriLogDB.addPerson(person);
        return "/registration.jsp";
    }
    
    private String addEvent(HttpServletRequest request, HttpServletResponse response) {
        Event event = new Event();
        Person patient = NutriLogDB.searchByNumber(request.getParameter("patientNumber"));
        event.setPatient(patient);
        try {
            int amt = Integer.parseInt(request.getParameter("foodAmount"));
            event.setFoodAmount(amt);
        }
        catch (Exception e){
        }
        if (!request.getParameter("foodUnits").equals("Select"))
            event.setFoodUnits(request.getParameter("foodUnits"));
        switch (request.getParameter("diaper")) {
            case "Urine Only":
                event.findUrine();
                break;
            case "Stool Only":
                event.findStool();
                break;
            case "Both Urine and Stool":
                event.findUrine();
                event.findStool();
                break;
            default:
                break;
        }
        String d = request.getParameter("date");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date=format.parse(d);
        }
        catch (ParseException pe) {
        }
        event.setEventDate(date);
        event.setEventTime(request.getParameter("time"));
        int lbs = 0;
        int ozs = 0;
        try {
            lbs = Integer.parseInt(request.getParameter("pounds"));
            ozs = Integer.parseInt(request.getParameter("ounces"));
        }
        catch (Exception e){
        }
        finally {
            event.setWeight(lbs, ozs);
        }
        NutriLogDB.addEvent(event);
        return "/event.jsp";
    }
    
    private void loadInfo(HttpServletRequest request, HttpServletResponse response) {
        List<Event> dataSet = NutriLogDB.getPatientInfo(request.getParameter("searchValue"));
        try{
            request.setAttribute("lastFed", dataSet.get(0));
            request.setAttribute("lastChanged", dataSet.get(1));
            request.setAttribute("lastWeighed", dataSet.get(2));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
    }
}
