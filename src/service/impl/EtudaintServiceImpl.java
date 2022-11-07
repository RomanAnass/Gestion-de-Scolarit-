package service.impl;

import java.util.List;

import dao.impl.EtudiantDaoImpl;
import entities.Etudiant;

import service.EtudiantService;

public class EtudaintServiceImpl implements EtudiantService {
	private EtudiantDaoImpl ed = new  EtudiantDaoImpl();

	@Override
	public List<Etudiant> getSortedEtudiant() {
	List<Etudiant> etud = this.ed.getAll();
		
		return etud;
	}

}
