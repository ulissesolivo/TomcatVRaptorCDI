<%-- 
    Document   : editar
    Created on : 13/10/2015, 22:13:40
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
    <h1>Editar Pessoa</h1>
    <form action="<c:url value='/pessoa/salvar' />" enctype="multipart/form-data" method="post">
      <table>
        <tbody>
          <tr>
            <td>Id</td>
            <td><input value="${pessoa.id}" name="pessoa.id" readonly="readonly" /></td>
          </tr>
          <tr>
            <td>Código</td>
            <td><input value="${pessoa.codigo}" name="pessoa.codigo" readonly="readonly" /></td>
          </tr>
          <tr>
            <td>Nome</td>
            <td><input value="${pessoa.nome}" name="pessoa.nome" /></td>
          </tr>
          <tr>
            <td><input type="button" onclick="location.href = '<c:url value="/pessoa/listar" />';" value="Cancelar" /></td>
            <td><input type="submit" value="Salvar" /></td>
          </tr>
        </tbody>
      </table>
    </form>
  </body>
</html>
