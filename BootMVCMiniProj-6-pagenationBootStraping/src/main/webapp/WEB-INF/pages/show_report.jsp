 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
crossorigin="anonymous">
<div class="container p-3 my-3 border" >

<h1 style="color:bule;text-align:center"> page Record are::(${pageData.getPageable().getPageNumber()+1}/${pageData.getTotalPages()})</h1>
<c:choose>
  <c:when test="${!empty pageData}">
  <table align="center" class="table table-hover">
  <<thead>
  
  <tr>
  <th>empno</th>
  <th>empname</th>
  <th>job</th>
  <th>salary</th>
  <th>deptno</th>
  <th>oparations</th>
  </tr>
  </thead>

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
  <a href="report?page=${pageData.getNumber()-1}">previous</a>
  </c:if>
  <a href="report?page=${pageData.getNumber()+1}">next</a>
  <c:if test="${!pageData.isFirst()}">&nbsp;&nbsp;</c:if>
  <c:forEach var="i" begin="0" step="1" end="${pageData.getTotalPages()-1}">
  [
  <a href="report?page=${i}">${i+1}</a>&nbsp;
  ]
  
  
  </c:forEach>
  
  <c:if test="${!pageData.isLast()}">
   <c:if test="${!pageData.isLast()}">
   </c:if>
   <a href="report?page=${pageData.getTotalPages()-1}">last</a>
   </c:if>
  
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





</div>