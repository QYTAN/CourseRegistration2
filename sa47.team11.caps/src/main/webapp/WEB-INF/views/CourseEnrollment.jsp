<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CourseEnrolment</title>
</head>
<body>
<div class="container">
   <table class="table table-striped">
   <thead>
     <tr class="listHeading">
       <td align="center">Enrollment ID</td>
       <td align="center">Student ID</td>
       <td align="center">Student First_Mid Name</td>
       <td align="center">Student Last Name</td>
       <td align="center">Email</td>
       <td align="center">Enrollment Date</td>
      <!--  <td>Score</td>   -->
       <td align="center">Student Performance</td>    
     </tr>
    </thead>
     <c:forEach items="${studentEnrollments}" var="stuEnrollment">
     <tr>
       <td align="center">${stuEnrollment.studentEnrolId}</td>
       <td align="center">${stuEnrollment.user.userid}</td>
       <td align="center">${stuEnrollment.user.firstMidName}</td>
       <td align="center">${stuEnrollment.user.lastName}</td>
       <td align="center">${stuEnrollment.user.email}</td>
       <td align="center"><fmt:formatDate pattern="dd MMM yyyy" value="${stuEnrollment.dateRegistered}"/></td> 
       <%-- <td><a href="${pageContext.request.contextPath}/lecturer/create">Score</a></td>  --%>
       <td align="center"><a href="${pageContext.request.contextPath}/lecturer/viewstudent/${stuEnrollment.user.userid}">Student Performance</a></td>
         
     </tr>
     </c:forEach>    
   </table>
</div>
</body>
</html>
