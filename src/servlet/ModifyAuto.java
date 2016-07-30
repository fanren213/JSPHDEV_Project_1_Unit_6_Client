/**
 * @author      Bonan Cao <bonanc@andrew.cmu.edu>
 * @Andrew ID   bonanc
 * @Date 		Oct. 14. 2015
 * Class ModifyAuto is the servlet for selecting the options of automobile.
 */
package servlet;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import client.*;
import constants.*;
import model.*;
public class ModifyAuto extends HttpServlet{
	public DefaultSocketClient client;
	private CarModelOptionsIO carModelOptionsIO;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String strLocalHost = "";
		try{
			strLocalHost = InetAddress.getLocalHost().getHostName();
			InetAddress.getLocalHost().getHostName();
		}
		catch (UnknownHostException e){
			System.err.println ("Unable to find local host");
		}
		client = new DefaultSocketClient(strLocalHost, ClientConstants.iDAYTIME_PORT);
		client.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		carModelOptionsIO = client.getCarModelOptionsIO();
		response.setContentType("text/html");
		// Get the auto with chosen name.
		carModelOptionsIO.sendOutput(3);
		String name = request.getParameter("modelName");
		String[] names = name.split(" - ");
		String modelName = names[1];
		carModelOptionsIO.sendOutput(modelName);
		Automotive auto = new Automotive();
		try {
			auto = (Automotive) carModelOptionsIO.handleInput();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Forward the auto to jsp.
		if(auto != null){
			//out.println(auto.toString());
			request.getSession().setAttribute("auto", auto);
			request.getRequestDispatcher("ModifyAuto.jsp").forward(request, response);
		}
		client.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
}
