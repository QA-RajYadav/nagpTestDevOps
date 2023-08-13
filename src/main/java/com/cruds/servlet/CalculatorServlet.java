package com.cruds.servlet;

import com.cruds.service.CalculatorService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CalculatorServlet
 */
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strNum1 = request.getParameter("num1");
        String strNum2 = request.getParameter("num2");

        int result;

        if (strNum1.length() == 0 && strNum2.length() == 0) {
            result = 0;
        } else {

            int num1 = Integer.parseInt(strNum1);
            int num2 = Integer.parseInt(strNum2);

            result = CalculatorService.add(num1, num2);
        }

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        request.setAttribute("RESULT", String.valueOf(result));
        rd.forward(request, response);
    }

}
