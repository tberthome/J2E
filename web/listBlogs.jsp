<%@ page import="fr.epsi.blog.beans.Utilisateur" %><%--
  Created by IntelliJ IDEA.
  User: douce
  Date: 17/05/2019
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String titre = request.getParameter("titre");
    String description = request.getParameter("description");
    String auteur = request.getParameter("auteur");
    String dateCreation = request.getParameter("dateCreation");
%>


<h1> Book: </h1>
<p> <%="SAMPLE 2 RESULT " + strBook%> </p>

</body>
</html>
