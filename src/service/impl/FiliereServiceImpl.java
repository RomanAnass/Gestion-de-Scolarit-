package service.impl;

import java.util.List;

import dao.FiliereDao;
import dao.impl.FiliereDaoImpl;
import entities.Filiere;
import service.FiliereService;

public class FiliereServiceImpl implements FiliereService {

	private FiliereDao filiereDao = new FiliereDaoImpl() ;

	@Override
	public List<Filiere> getSortedFiliere() {
		
		List<Filiere> filieres = this.filiereDao.getAll();
		
		return filieres;
	}
}
