package beans;

import java.util.List;
import entities.Etudiant;
import service.EtudiantService;
import service.impl.EtudaintServiceImpl;


public class EtudiantBean {
	private Etudiant etudiant;
	private boolean modifyContext;
	
	
	public EtudiantBean() {
		this.etudiant=new Etudiant();
		this.setModifyContext(false);
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public boolean isModifyContext() {
		return modifyContext;
	}


	public void setModifyContext(boolean modifyContext) {
		this.modifyContext = modifyContext;
	}
	
	public String getLabel() {
		return modifyContext ? "Modification" : "Ajoute";
	}
	
			public List<Etudiant> getEtudiants() {
			EtudiantService es= new EtudaintServiceImpl();
			
			return es.getSortedEtudiant();
	}
	
	

}
