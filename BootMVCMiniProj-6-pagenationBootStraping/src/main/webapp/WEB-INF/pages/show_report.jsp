 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
  <c:when test="${!empty pageData}">
  <table align="center" border="1" bgcolor="red">
  
  <tr>
  <th>empno</th>
  <th>empname</th>
  <th>job</th>
  <th>salary</th>
  <th>deptno</th>
  <th>oparations</th>
  </tr>

  <c:forEach var="emp" items="${pageData.getContent()}">
  <tr bgcolor="blue">
  <th>${emp.empno}</th>
<th>${emp.empname}</th>
<th>${emp.job}</th>
<th>${emp.sal}</th>
<th>${emp.deptno}</th>
<td><a href="edit?no=${emp.empno}"><img src="images/edit.jpg" width="30px" height="40px"></a>&nbsp;&nbsp;
<a  onclick="return confirm('are you sure delete??')" href="delete?no=${emp.empno}"><img src="images/delete.png" width="30px" height="40px"></a>
</td>
  </tr>
</c:forEach>
  </table>
  <br><br>
  <center>
  <c:if test="${!pageData.isFirst()}">
  <a href="report?page=0">first</a>&nbsp;&nbsp;
  </c:if>
  <a href="report?page=${pageData.getNumber()+1}">next</a>
  <c:if test="${!pageData.isFirst()}">
   <a href="report?page=${pageData.getNumber()-1}">previous</a>&nbsp;&nbsp;</c:if>
   <a href="report?page=${pageData.getTotalPages()-1}">last</a>
  
  </center>
  
  
  
  
  </c:when>
  <c:otherwise>
  <div style="color:red; text-align:center;">no data found</div>
</c:otherwise>


</c:choose>
<br><br>
<h1 style="color:red;text-align:center">${msglist}</h1>
<br><br>

<center><a href="register"> Add Employee<img src="images/add.png" width="30px" height="40px"></a></center>
<br><br>
<center><a href=".">HOME<img src="images/home.jpg" width="200" height="150" alt="Sample Image"></a></center>