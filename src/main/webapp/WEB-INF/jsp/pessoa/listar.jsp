<%-- 
    Document   : listar
    Created on : 13/10/2015, 22:14:09
    Author     : uliss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Listar Pessoas</h1>
    <table>
      <thead>
        <tr>
          <th><a href="<c:url value='/pessoa/editar' />">Nova</a></th>
          <th>&nbsp;</th>
          <th>Id</th>
          <th>Código</th>
          <th>Nome</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${pessoas}" var="pessoa">
          <tr>
            <td><a href="<c:url value='/pessoa/editar/${pessoa.id}' />">Editar</a></td>
            <td><a href="<c:url value='/pessoa/excluir/${pessoa.id}' />">Excluir</a></td>
            <td>${pessoa.id}</td>
            <td>${pessoa.codigo}</td>
            <td>${pessoa.nome}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
