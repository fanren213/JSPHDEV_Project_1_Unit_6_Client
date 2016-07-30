/**
 * @author      Bonan Cao <bonanc@andrew.cmu.edu>
 * @Andrew ID   bonanc
 * @Date 		Oct. 14. 2015
 * Class SelectAuto is the servlet for selecting automobile from the linked hash map.
 */
package servlet;

import java.io.IOException;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

import client.CarModelOptionsIO;
import client.DefaultSocketClient;
import constants.ClientConstants;

public class SelectAuto extends HttpServlet{
	public DefaultSocketClient client;
	private CarModelOptionsIO carModelOptionsIO;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
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
		// Get the name of models in the linked hash map.
		ServletOutputStream out = response.getOutputStream();
		carModelOptionsIO.sendOutput(2);
		String modelList = new String();
		try {
			modelList = (String) carModelOptionsIO.handleInput();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.close();
		String[] modelName = modelList.substring(0, modelList.length() - 1).split("\n");
		out.println("<html>");
		out.println("<head><title>-AUTO CONFIGURATION-</title></head>");
		out.println("<body>");
		out.println("<h2>AUTO CONFIGURATION</h2>");
		out.print("Please choose the automobile for modification:");
		out.print("<form method=\"post\" action=\"ModifyAuto\">");
		out.print("<select name=\"modelName\">");
		for(int i = 0; i < modelName.length; i++){
			out.print("<option value=\""+modelName[i]+"\">"+modelName[i]+"</option>");
		}
		out.print("</select><br>");
		out.print("<input type=\"submit\" value=\"Submit\"></form></body></html>");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}
