<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Enumeration" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Проверка на возможность извлечения </title>
  </head>
  <body>
    <p>Эта страница позволяет убедиться, что мы можем получить атрибуты приложения, сеанса и запроса, установленные на
       предыдущей странице.</p>
    <p>значение атрибутов приложения (applicationAttribute): <%= application.getAttribute("applicationAttribute") %> <br/>
      значение атрибутов сеанса (sessionAttribute): <%= session.getAttribute("sessionAttribute") %> <br/>
      значение атрибутов запроса (requestAttribute): <%= request.getAttribute("requestAttribute") %> <br />
    </p>
    <p>B контексте приложения были обнаружены следующие атрибуты:<br /><br/>
        <%
        Enumeration applicationAttributeNames = pageContext.getAttributeNamesInScope(pageContext.APPLICATION_SCOPE);
        while (applicationAttributeNames.hasMoreElements()) {
          out.println(applicationAttributeNames.nextElement()+"<br/>");
        }
        %>
    </p>
    <p>
      <a href="buggy.jsp">Этa гиперссылка указывает на JSP, к которой будет выполняться переход при возникновении исключения.</a>
    </р>
  </body>
</html>
