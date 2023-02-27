package com.customer.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.customer.dao.Customerdao;
import com.customer.dto.Customer;

@WebServlet("/getbyid")
public class GetStudent extends GenericServlet

{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		Customerdao ct = new Customerdao();

		Customer customer = ct.getCustomerById(Integer.parseInt(req.getParameter("id")));

		PrintWriter writer = res.getWriter();

		writer.println(customer.getId());
		writer.println(customer.getName());
		writer.println(customer.getEmail());
		writer.println(customer.getPhone());
		writer.println(customer.getGender());

	}

}
