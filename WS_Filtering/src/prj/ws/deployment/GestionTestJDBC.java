package prj.ws.deployment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prj.ws.deployment.Main;

public class GestionTestJDBC extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE          = "/WEB-INF/test_jdbc.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Main test = new Main();
        List<String> messages = test.executerTests( request );

        request.setAttribute( ATT_MESSAGES, messages );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
