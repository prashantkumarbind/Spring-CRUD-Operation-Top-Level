package com.webdeveloper.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.webdeveloper.entity.Employee;

public class ExecuteQuery implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt("id_no"));
		e.setName(rs.getString("name"));
		e.setAddress(rs.getString("address"));
		e.setAge(rs.getInt("age"));
		e.setDesignation(rs.getString("designation"));
		e.setSalary(rs.getFloat("salary"));
		return e;
	}

}
