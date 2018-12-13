<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div class="container">  
   <table class="table table-striped">
   <thead>
     <tr class="listHeading">
       <td align="center">Course ID</td>
       <td align="center">Course Name</td>
       <td align="center">Class Size</td>
       <td align="center">Credit</td>
       <td align="center">Weekday</td>
       <td align="center">Start Time</td>
       <td align="center">End Time</td>
       <td align="center">Exam Time</td>
       <td align="center">CurrentEnrollment</td>
       <td align="center">Operation</td>
       <td align="center">Grade</td>
     </tr>
   </thead>
     <c:forEach items="${courses}" var="course">
     <tr>
       <td align="center">${course.courseid}</td>
       <td align="center">${course.courseName}</td>
       <td align="center">${course.classSize}</td>
       <td align="center">${course.credit}</td>
       <td align="center">${course.weekday}</td>
       <td align="center"><fmt:formatDate type="time"  value="${course.startTime}" /></td>
       <td align="center"><fmt:formatDate type="time"  value="${course.endTime}" /></td> 
       <td align="center"><fmt:formatDate type="both"  dateStyle="medium" timeStyle="medium"  value="${course.examTime}" /></td> 
       <td align="center">${course.studentEnrolments.size()}</td>
       <td align="center"><a href="${pageContext.request.contextPath}/lecturer/${course.courseid}">Enrollment list</a></td>
       <td><a href="${pageContext.request.contextPath}/lecturer/gradelist/${course.courseid}">Grade</a></td>    
     </tr>
     </c:forEach>
    
   </table>
    
</div>
</body>
