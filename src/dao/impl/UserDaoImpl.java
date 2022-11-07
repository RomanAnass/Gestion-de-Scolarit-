package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Connexion;
import dao.UserDao;

import entities.User;

public class UserDaoImpl implements UserDao {
	private Connection connection = Connexion.getConnexion();
	@Override
	public boolean create(User o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getById(int id) {
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from user where id = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null && rs.next())
			{
				User u= new User();
				u.setId(rs.getInt("id"));
				u.setNom(rs.getString("nom"));
				u.setLogin(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				return u;
			}
			
		} catch (SQLException e) {
			System.out.println("Probleme dans filiere getById "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<User> getAll() {
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from user");
			
			ResultSet rs = ps.executeQuery();
			
			List<User> user = new ArrayList<User>();
			
			while (rs.next())
			{
				User u= new User();
				
				u.setId(rs.getInt("id"));
				u.setLogin(rs.getString("email"));
				u.setNom(rs.getString("nom"));
				u.setPassword(rs.getString("password"));
				
				user.add(u);
			}
			
			rs.close();
			ps.close();
			
			return user;
			
		} catch (SQLException e) {
			System.out.println("Probleme dans user getAll "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<String> getAllFields() {
		// TODO Auto-generated method stub
		return null;
	}

}
