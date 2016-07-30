<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>-AUTO CONFIGURATION-</title>
</head>
<body>
		<H2>AUTO CONFIGURATION</H2>
		<%
			DecimalFormat price = new DecimalFormat("####0.00");
			String modelName = (String) session.getAttribute("modelName");
			String makeName = (String) session.getAttribute("makeName");
			Double basePrice = (Double) session.getAttribute("basePrice");
			Double totalPrice = (Double) session.getAttribute("totalPrice");
			Integer size = (Integer) session.getAttribute("size");
			String[] choiceName = new String[size];
			String[] optionSetName = new String[size];
			Double[] optionPrice = new Double[size];
			for(int i = 0; i < size; i++){
				choiceName[i] = (String) session.getAttribute("choiceName" + i);
				optionSetName[i] = (String) session.getAttribute("optionSetName" + i);
				optionPrice[i] = (Double) session.getAttribute("optionPrice" + i);
			}
		%>
		<form>
			<table border = "1">
					<tr>
						<th>Make - Model Name</th>
						<td align="center" colspan = "2"><%out.println(makeName + " - " + modelName); %></td>
					</tr>
					<tr>
						<th>Base Price</th>
						<td align="center" colspan = "2"><%out.println(price.format(basePrice)); %></td>
					</tr>
					<tr>
						<th>Features</th>
						<th>Choice</th>
						<th>Price</th>
					</tr>
					<tr>
						<% for(int i = 0; i < size; i++){%>
						<th><%=optionSetName[i]%></th>
						<td align="right"><%out.println(choiceName[i]); %></td>
						<td align="right"><%out.println(price.format(optionPrice[i])); %></td>
					</tr>
					<%} %>
					<tr>
						<th>Total Price</th>
						<td align = "center" colspan = "2"><%out.println(price.format(totalPrice)); %></td>
					</tr>
			</table>
		</form>
</body>
</html>