<%@ page import="fr.epsi.blog.beans.Utilisateur" %>
<%@ page import="fr.epsi.blog.beans.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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

<h1>ListBlogs</h1>

<%
    // retrieve your list from the request, with casting
    ArrayList<Blog> list = (ArrayList<Blog>) request.getAttribute("listBlogs");

// print the information about every category of the list
    for(Blog blog : list) {
        out.println("<h1 style=\"margin-top: 25px; border-top: solid #000;\">");
        out.println(blog.getTitre());
        out.println("</h1>");
        out.println("<ul>");
        out.println("<li>");
        out.println(blog.getCreateur().getNom());
        out.println("</li>");
        out.println("<li>");
        out.println(new SimpleDateFormat("yyyy-MM-dd").format(blog.getDateCreation()));
        out.println("</li>");
        out.println("</ul>");
    }
%>


</body>
</html>
