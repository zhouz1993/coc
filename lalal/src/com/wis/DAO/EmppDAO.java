package com.wis.DAO;

import java.sql.SQLException;
import java.util.List;

import com.wis.entity.Empp;

public interface EmppDAO {
	public List<Empp> findAll() throws SQLException;
	public void add(Empp emp);
	public void delete(Integer id);
	public void update(Empp emp);
	public List<Empp> findEmp(Integer empno);
	public List<Empp> findEmpByName(String name);

}