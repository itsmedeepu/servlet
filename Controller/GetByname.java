package com.customer.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.customer.dao.Customerdao;
import com.customer.dto.Customer;

@WebServlet("/getbyname")
public class GetByname extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Customerdao ct = new Customerdao();
		List<Customer> c = ct.getCustomerByName(req.getParameter("name"));

		PrintWriter writer = res.getWriter();

		for (Customer t : c) {

			writer.println(t.getId());
			writer.println(t.getName());
			writer.println(t.getEmail());
			writer.println(t.getPhone());
			writer.println(t.getGender());

		}
	}

}
