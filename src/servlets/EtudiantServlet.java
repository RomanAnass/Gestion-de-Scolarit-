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
import dao.FiliereDao;
import dao.impl.EtudiantDaoImpl;
import dao.impl.FiliereDaoImpl;
import entities.Etudiant;
@SuppressWarnings("unused")
@WebServlet("/etudiant/*")
public class EtudiantServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	FiliereDao filiereDao = new FiliereDaoImpl();
	EtudiantDaoImpl ed = new EtudiantDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		EtudiantBean etudiantBean = (EtudiantBean)session.getAttribute("etudiantBean");	
		
		if(req.getRequestURI().contains("save")){
				System.out.println("save");
			etudiantBean.getEtudiant().setNom(req.getParameter("nom"));
			etudiantBean.getEtudiant().setPrenom(req.getParameter("prenom"));
			etudiantBean.getEtudiant().setCne(req.getParameter("cne"));
			etudiantBean.getEtudiant().setFiliere(filiereDao.getById(Integer.valueOf(req.getParameter("id_f"))));
			
			if(etudiantBean.isModifyContext()) {
				ed.update(etudiantBean.getEtudiant());
				etudiantBean.setModifyContext(false);
			}
			
			else {
				ed.create(etudiantBean.getEtudiant());
				etudiantBean=new EtudiantBean();
			}
		}
		
		
		
		if(req.getRequestURI().contains("modify")){
			System.out.println("modifie");
			int id = Integer.valueOf(req.getParameter("id"));
			etudiantBean.setEtudiant(ed.getById(id));
			etudiantBean.setModifyContext(true);
			
		}
		
		if(req.getRequestURI().contains("delete")){
			System.out.println("delet");
			int id = Integer.valueOf(req.getParameter("id"));
			ed.delete(ed.getById(id));
			
		}
		
	resp.sendRedirect("http://localhost:8080/Gestion_ecole/home/etudiant");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	
}
