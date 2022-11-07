package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Connexion;
import dao.EtudiantDao;
import dao.FiliereDao;
import entities.Etudiant;


public class EtudiantDaoImpl implements EtudiantDao {

	private Connection connection = Connexion.getConnexion();
	   private FiliereDao f = new FiliereDaoImpl();
	   UserDaoImpl ud = new UserDaoImpl(); 

	@Override
	public boolean create(Etudiant o) {
		if(this.connection == null)
	 	return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("insert into etudiant (nom,prenom,cne,id_filiere) values (?, ?,?,?);");
			
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getCne());
			ps.setInt(4, o.getFiliere().getId());
			
			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("Etudiant bien Ajoutée ...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de l'ajout de Etudiant "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean update(Etudiant o) {
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("update etudiant set nom = ?, prenom = ? ,cne=? , id_filiere =?  where id = ?");
			
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getCne());
			ps.setInt(4, o.getFiliere().getId());
			ps.setInt(5, o.getId());
			
			
			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("Etudiant bien Modifiée ...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la modification de filiere "+e.getMessage());
		}
		
		return false;
		
		
	}

	@Override
	public boolean delete(Etudiant o) {
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("delete from etudiant where id = ?");
			
			ps.setInt(1, o.getId());

			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("etudiant bien supprimée ...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la supression de filiere "+e.getMessage());
		}
		
		return false;
	}
	

	@Override
	public Etudiant getById(int id) {
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from etudiant where id = ? ");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null && rs.next())
			{
				Etudiant e = new Etudiant();
				e.setId(rs.getInt("id"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setCne(rs.getString("cne"));
				
				
				
				//FiliereDao f = new FiliereDaoImpl();
				e.setFiliere(f.getById(rs.getInt("id_filiere")));
				 
				
				rs.close();
				ps.close();
				
				return e;
			}
			
		} catch (SQLException e) {
			System.out.println("Probleme dans Etudiant getById "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Etudiant> getAll() {
		
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from etudiant");
			
			ResultSet rs = ps.executeQuery();
			
			List<Etudiant> etu=new  ArrayList<Etudiant>();
			
			while (rs.next())
			{
				Etudiant e = new Etudiant();
				e.setId(rs.getInt("id"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setCne(rs.getString("cne"));
				e.setFiliere(f.getById(rs.getInt("id_filiere")));
				
				
				//FiliereDao f = new FiliereDaoImpl();
			
				
				etu.add(e);
			}
			
			rs.close();
			ps.close();
			
			return etu;
			
		} catch (SQLException e) {
			System.out.println("Probleme dans etudiant getAll "+e.getMessage());
		}
		
		return null;
		
	}

	@Override
	public List<String> getAllFields() {
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from etudiant");
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			List<String> fields = new ArrayList<String>();
			
			for(int i=1; i<=rsmd.getColumnCount(); i++)
				fields.add(rsmd.getColumnName(i));
			
			rs.close();
			ps.close();
			
			return fields;
			
		} catch (SQLException e) {
			System.out.println("Probleme dans etudiant getAllFields "+e.getMessage());
		}
		
		return null;
	}
	
	
	
	

}
