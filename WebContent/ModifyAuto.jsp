<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Automotive, model.OptionSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>-AUTO CONFIGURATION-</title>
</head>
<body>
	<H2>AUTO CONFIGURATION</H2>
		<%
			Automotive auto = (Automotive) session.getAttribute("auto");
			ArrayList<OptionSet> optionSets = auto.getOptionSets();
		%> 
		<form method="post" action="ShowChoice">
			<table border = "1">
					<tr><th>Make - Model Name</th><td align="center"><%out.println(auto.getMake() + " - " + auto.getModel()); %></td></tr>
					<% for(int i = 0; i < optionSets.size(); i++){%>
					<tr>
					<th><%String optionSetName = auto.getOptionSetName(i);
						  out.println(optionSetName); %></th>
					<td align="right"><select name="<%=optionSetName%>">
							<% 
								int size = auto.getOptionSetSize(i);
								for(int j = 0 ; j < size ; j++)
								{
									String optionName = auto.getOptionName(i, j) ;
								%>
									<option value="<%=optionName%>"><%=optionName%></option>
								<%
								}
								%>
							</select>
						</tr>
					<%} %>
				<tr><td align="right" colspan="2"><input type="submit" value="Done"></td></tr>
			</table>
		</form>
</body>
</html>