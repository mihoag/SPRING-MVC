package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Util.httpUtil;
import model.student;

/**
 * Servlet implementation class apiAdminNew
 */
@WebServlet(urlPatterns = "/api")
public class apiAdminNew extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public apiAdminNew() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
         student st = httpUtil.of(request.getReader()).toModel(student.class);
         System.out.println(st.toString());
         response.setContentType("application/json");
         ObjectMapper map = new ObjectMapper();
         map.writeValue(response.getOutputStream(), st);
         
	}

}
