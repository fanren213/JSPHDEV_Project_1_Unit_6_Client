/**
 * @author      Bonan Cao <bonanc@andrew.cmu.edu>
 * @Andrew ID   bonanc
 * @Date 		Oct. 14. 2015
 * Class ShowChoice is the servlet for the result of options and price.
 */
package servlet;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

/**
 * Servlet implementation class ShowChoice
 */
public class ShowChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowChoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Read the parameters from request.
		Automotive auto = (Automotive) request.getSession().getAttribute("auto");
		if(auto != null){
			String modelName = auto.getModel();
			String makeName = auto.getMake();
			double baseprice = auto.getBasePrice();
			request.getSession().setAttribute("modelName", modelName);
			request.getSession().setAttribute("makeName", makeName);
			request.getSession().setAttribute("basePrice", baseprice);
			ArrayList<OptionSet> optionSets = auto.getOptionSets();
			int size = optionSets.size();
			request.getSession().setAttribute("size", size);
			// Set the values for the result and calculate the total price.
			for(int i = 0; i < size; i++){
				String optionSetName = auto.getOptionSetName(i);
				String optionChoiceName = request.getParameter(optionSetName);
				auto.setOptionChoice(optionSetName, optionChoiceName);
				Double optionPrice = auto.getOptionChoicePrice(optionSetName);
				if(optionChoiceName != null)
					request.getSession().setAttribute("optionSetName" + i, optionSetName);
					request.getSession().setAttribute("choiceName" + i, optionChoiceName);
					request.getSession().setAttribute("optionPrice" + i, optionPrice);
				}
			Double totalPrice = auto.getTotalPrice();
			// Forward to jsp.
			request.getSession().setAttribute("totalPrice", totalPrice);
			request.getRequestDispatcher("ShowChoice.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
