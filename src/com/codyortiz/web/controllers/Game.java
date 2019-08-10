package com.codyortiz.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/home.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer number = (Integer) session.getAttribute("number");
		Integer guess = Integer.parseInt(request.getParameter("guess"));
		
		Random r = new Random();
		
		if(session.getAttribute("number") == null) {
			session.setAttribute("number", r.nextInt(100));
		}
		
		if(guess.equals(number)) {
			session.setAttribute("number", r.nextInt(100));
			session.setAttribute("response", "correct");
		}
		
		if(guess > number) {
			session.setAttribute("response", "high");
		}
		
		else {
			session.setAttribute("response", "low");
		}
		
		doGet(request, response);
	}

}
