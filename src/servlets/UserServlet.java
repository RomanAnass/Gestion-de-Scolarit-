package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.UserDaoImpl;
import entities.User;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl ud = new UserDaoImpl();
		
    public UserServlet() {
       
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getRequestURI().contains("login"))
		{
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			System.out.println("login");
			
			if(email.equals("walid@fpl")&&password.equals("fpl")) {
				
				User u =new User();
				u.setLogin(email);
				u.setPassword(password);
				request.getSession().setAttribute("user", u);
				request.getRequestDispatcher("/WEB-INF/choix.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("http://localhost:8080/Gestion_ecole/loginUser.jsp");
			}
			
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
