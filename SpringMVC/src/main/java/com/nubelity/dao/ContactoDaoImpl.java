package com.nubelity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nubelity.model.Contacto;

public class ContactoDaoImpl implements ContactoDao{
	private JdbcTemplate jdbcTemplate;
	
	public ContactoDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Contacto> list() {
		String sql = "SELECT * FROM contacto";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Contacto.class));
	}

	@Override
	public void saveOrUpdate(Contacto contacto) {
		//no se concatenan para evitar la inyeccion de codigo
		String sql = "";
		int rowsAffected = -1;
		
		if(contacto.getId() > 0) {
			sql = "UPDATE contacto SET nombre = ?, email = ?, direccion = ?, telefono = ? " 
					+ "WHERE id = ?";
			rowsAffected = jdbcTemplate.update(sql, contacto.getNombre(), contacto.getEmail(), 
					contacto.getDireccion(), contacto.getTelefono(), contacto.getId());
			
		}else {
			sql = "INSERT INTO contacto (nombre, email, direccion, telefono) "
					+ "VALUES (?,?,?,?)";
			rowsAffected = jdbcTemplate.update(sql, contacto.getNombre(), contacto.getEmail(), 
					contacto.getDireccion(), contacto.getTelefono());
			
		}
		
		boolean realizado = rowsAffected > 0;
		System.out.println(rowsAffected + "|" + realizado);
	}

	@Override
	public Contacto get(int contactoId) {
		String sql = "SELECT * FROM contacto WHERE id = ?";
		return jdbcTemplate.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, contactoId);
			}
		}, new ResultSetExtractor<Contacto>() {
			@Override
			public Contacto extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Contacto contacto = new Contacto();
					contacto.setId(rs.getInt("id"));
					contacto.setNombre(rs.getString("nombre"));
					contacto.setEmail(rs.getString("email"));
					contacto.setDireccion(rs.getString("direccion"));
					contacto.setTelefono(rs.getString("telefono"));
					return contacto;
				}
				return null;
			}
		});
	}

	@Override
	public void delete(int contactoId) {
		String sql = "DELETE FROM contacto WHERE id = ?";
		jdbcTemplate.update(sql, contactoId);
	}
}
