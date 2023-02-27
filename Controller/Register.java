package com.customer.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.customer.dao.Customerdao;
import com.customer.dto.Customer;

public class Register extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		Customer c = new Customer();

		c.setName(req.getParameter("name"));
		c.setEmail(req.getParameter("email"));
		c.setPhone(req.getParameter("phone"));
		c.setGender(req.getParameter("gender"));

		Customerdao ct = new Customerdao();

		Customer saveCustomer = ct.saveCustomer(c);

		PrintWriter writer = res.getWriter();

		writer.println(saveCustomer.getId());
		writer.println(saveCustomer.getName());
		writer.println(saveCustomer.getEmail());
		writer.println(saveCustomer.getPhone());
		writer.println(saveCustomer.getGender());

	}

}
