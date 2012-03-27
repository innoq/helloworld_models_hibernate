<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,com.innoq.helloworld.models.Profile"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Address List</title>
    </head>

    <body>

        <hr><ol> <%
            @SuppressWarnings("unchecked")
            List<Profile> profileList = (List<Profile>)request.getAttribute("profileList");
            for (Profile profile : profileList) { %>
                <li><%= profile.getFirstName() %> <%= profile.getLastName() %>: 
                <%= profile.getReceivedMessages().size() %></li> <%
            } %>
        </ol><hr>

     </body>
 </html>