package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Connexion;
import dao.FiliereDao;
import entities.Filiere;

public class FiliereDaoImpl implements FiliereDao {

	private Connection connection = Connexion.getConnexion();
	   UserDaoImpl ud = new UserDaoImpl(); 

	
	@Override
	public boolean create(Filiere o) {
		
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("insert into filiere (code, libelle) values (?, ?)");
			
			ps.setString(1, o.getCode());
			ps.setString(2, o.getLibelle());
			
			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("Filiere bien Ajoutée ...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de l'ajout de filiere "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean update(Filiere o) {
		
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("update filiere set code = ?, libelle = ? where id = ?");
			
			ps.setString(1, o.getCode());
			ps.setString(2, o.getLibelle());
			ps.setInt(3, o.getId());
			
			
			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("Filiere bien Modifiée ...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la modification de filiere "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean delete(Filiere o) {

		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("delete from filiere where id = ?");
			
			ps.setInt(1, o.getId());
			
			
			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("Filiere bien supprimée ...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la supression de filiere "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public Filiere getById(int id) {
		
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from filiere where id = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null && rs.next())
			{
				Filiere f = new Filiere();
				
				f.setId(rs.getInt(1));
				f.setCode(rs.getString(2));
				f.setLibelle(rs.getString(3));
				

				
				rs.close();
				ps.close();
				
				return f;
			}
			
		} catch (SQLException e) {
			System.out.println("Probleme dans filiere getById "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Filiere> getAll() {

		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from filiere");
			
			ResultSet rs = ps.executeQuery();
			
			List<Filiere> filieres = new ArrayList<Filiere>();
			
			while (rs.next())
			{
				Filiere f = new Filiere();
				
				f.setId(rs.getInt(1));
				f.setCode(rs.getString(2));
				f.setLibelle(rs.getString(3));
			

				filieres.add(f);
			}
			
			rs.close();
			ps.close();
			
			return filieres;
			
		} catch (SQLException e) {
			System.out.println("Probleme dans filiere getAll "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<String> getAllFields() {
		
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from filiere");
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			List<String> fields = new ArrayList<String>();
			
			for(int i=1; i<=rsmd.getColumnCount(); i++)
				fields.add(rsmd.getColumnName(i));
			
			rs.close();
			ps.close();
			
			return fields;
			
		} catch (SQLException e) {
			System.out.println("Probleme dans filiere getAllFields "+e.getMessage());
		}
		
		return null;
	}

}
