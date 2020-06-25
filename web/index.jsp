
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Poszuk Ksiazek</title>
  </head>
  <body>
<form action="${pageContext.request.contextPath}/search" method="post">
  Search: <input type="text" name="Search"><br><br>
  <input type="submit" value="Search">
  <select name="comboBox">
    <option value="ISBN">ISBN</option>
    <option value="TYTUL">Tytul</option>
    <option value="ROK">Rok</option>
    <option value="CENA">Cena</option>
    <option value="w.NAME">Wydawca</option>
    <option value="a.NAME">Autor</option>
  </select>
</form>

  </body>
</html>
