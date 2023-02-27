package com.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.customer.dto.Customer;

public class Customerdao {

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop?user=root&password=root");
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public Customer saveCustomer(Customer c) {

		Connection con = getConnection();
		String query = "insert into customer (cname,cemail,cphone,cgender) values(?,?,?,?)";
		try {
			PreparedStatement pt = con.prepareStatement(query);

			pt.setString(1, c.getName());
			pt.setString(2, c.getEmail());
			pt.setString(3, c.getPhone());
			pt.setString(4, c.getGender());

			int ex = pt.executeUpdate();

			Customer ct = getCustomerByPhone(c.getPhone());
			con.close();
			return ct;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public Customer getCustomerByPhone(String phone) {

		Connection con = getConnection();
		String query = "select * from customer where cphone=?";
		try {
			PreparedStatement pt = con.prepareStatement(query);

			pt.setString(1, phone);

			ResultSet ex = pt.executeQuery();
			Customer c = new Customer();
			if (ex.next()) {

				c.setId(ex.getInt(1));
				c.setName(ex.getString(2));
				c.setEmail(ex.getString(3));
				c.setPhone(ex.getString(4));
				c.setGender(ex.getString(5));

			}
			con.close();
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public Customer getCustomerById(int id) {

		Connection con = getConnection();
		String query = "select * from customer where cid=?";
		try {
			PreparedStatement pt = con.prepareStatement(query);

			pt.setInt(1, id);

			ResultSet ex = pt.executeQuery();
			Customer c = new Customer();
			if (ex.next()) {
				c.setId(ex.getInt(1));
				c.setName(ex.getString(2));
				c.setEmail(ex.getString(3));
				c.setPhone(ex.getString(4));
				c.setGender(ex.getString(5));

			}
			con.close();
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public List<Customer> getCustomerByName(String name) {

		Connection con = getConnection();

		String query = "select * from customer where cname=?";

		try {
			PreparedStatement pt = con.prepareStatement(query);

			pt.setString(1, name);
			ResultSet ex = pt.executeQuery();

			List<Customer> c = new ArrayList<Customer>();
			while (ex.next()) {

				Customer c1 = new Customer();
				c1.setId(ex.getInt(1));
				c1.setName(ex.getString(2));
				c1.setEmail(ex.getString(3));
				c1.setPhone(ex.getString(4));
				c1.setGender(ex.getString(5));
				c.add(c1);

			}
			return c;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
