package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.FiliereBean;
import dao.FiliereDao;
import dao.impl.FiliereDaoImpl;
import entities.Filiere;


@WebServlet("/filiere/*")
public class FiliereServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session= req.getSession();
		FiliereDao filiereDao = new FiliereDaoImpl();
		FiliereBean filiereBean = (FiliereBean)session.getAttribute("filiereBean");
		

		
		if(req.getRequestURI().contains("save"))
		{
			System.out.println("save");
			filiereBean.getFiliere().setCode(req.getParameter("code"));
			filiereBean.getFiliere().setLibelle(req.getParameter("libelle"));
			
			if(filiereBean.isModifyContext()) {
				filiereDao.update(filiereBean.getFiliere());
				filiereBean.setModifyContext(false);
			}
			
			else
				filiereDao.create(filiereBean.getFiliere());
			
			filiereBean.setFiliere(new Filiere());
		}
		
		if(req.getRequestURI().contains("modify"))
		{
			System.out.println("modifue");
			
			int id = Integer.parseInt(req.getParameter("id"));
			filiereBean.setFiliere(filiereDao.getById(id));
			session.setAttribute("filiereBean", filiereBean);
			filiereBean.setModifyContext(true);
		}
		
		if(req.getRequestURI().contains("delete"))
		{
			System.out.println("delete");
			int id = Integer.parseInt(req.getParameter("id"));
			filiereDao.delete(filiereDao.getById(id));
		}
		
		resp.sendRedirect("http://localhost:8080/Gestion_ecole/home/filiere");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		this.doGet(req, resp);
	}
}
