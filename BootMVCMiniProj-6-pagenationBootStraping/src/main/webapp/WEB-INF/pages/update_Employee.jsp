<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color:lightcyan;text-align:center">UPDATE THE EMPLOYEE DETAILS</h1>

<frm:form modelAttribute="emp">

<table align="center" bgcolor="orange">

<tr>
<td>Employee number:</td>
<td>
<frm:input path="empno" readonly="true"/>
</td>
</tr>

<tr>
<td>Name:</td>
<td>
<frm:input path="empname"/>
</td>
</tr>

<tr>
<td>Job:</td>
<td>
<frm:input path="job"/>
</td>
</tr>

<tr>
<td>Salary:</td>
<td>
<frm:input path="sal"/>
</td>
</tr>

<tr>
<td>Dept No:</td>
<td>
<frm:select path="deptno">
<option value="10">10</option>
<option value="20">20</option>
<option value="30">30</option>
</frm:select>
</td>
</tr>

<tr>
<td> <input type="submit" value="Update Employee"></td>
<td> <input type="reset" value="Cancel"></td>
</tr>
</table>
</frm:form>
