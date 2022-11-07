package beans;

import java.util.List;

import entities.Filiere;
import service.FiliereService;
import service.impl.FiliereServiceImpl;

public class FiliereBean {
	
	private Filiere filiere;
	private boolean modifyContext;
	
	public FiliereBean(){
		this.filiere = new Filiere();
		this.modifyContext = false;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	
	public boolean isModifyContext() {
		return modifyContext;
	}

	public void setModifyContext(boolean modifyContext) {
		this.modifyContext = modifyContext;
	}

	public List<Filiere> getFilieres() {
		
		FiliereService filiereService = new FiliereServiceImpl();
		
		return filiereService.getSortedFiliere();
	}
	
	public String getLabel() {
		
		return modifyContext ? "Modification" : "Ajoute";
	}
}
