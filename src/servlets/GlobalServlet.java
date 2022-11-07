package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.EtudiantBean;
import beans.FiliereBean;

@WebServlet("/home/*")
public class GlobalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		HttpSession session= req.getSession();
		
		if(req.getRequestURI().contains("etudiant")) {
			System.out.println("etudiant");
		if(session.getAttribute("etudiantBean") == null) 
			session.setAttribute("etudiantBean", new EtudiantBean()); 
		req.getRequestDispatcher("/WEB-INF/Etudiant.jsp").forward(req, resp);
		
		}
		
		if(req.getRequestURI().contains("filiere")){
			System.out.println("fiellere");
			if(req.getSession().getAttribute("filiereBean") == null)
				req.getSession().setAttribute("filiereBean", new FiliereBean()); 
			req.getRequestDispatcher("/WEB-INF/Filiere.jsp").forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		this.doGet(req, resp);
	}
}
