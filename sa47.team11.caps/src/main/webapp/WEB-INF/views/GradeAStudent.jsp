<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
<form:form method="POST" modelAttribute="studentEnrollment" class="form-horizontal"
	action="${pageContext.request.contextPath}/lecturer/create/${studentEnrollment.studentEnrolId}.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0 class="table table-striped">
				<tr class="listHeading">
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				<tr>
				   <td align="left"><s:message code="StudentEnrollment ID:" /></td>
				   <td align="left">${studentEnrollment.studentEnrolId}</td>
				 </tr>
				<tr>
				   <td align="left"><s:message code="Student ID"/></td>
				   <td align="left">${studentEnrollment.user.userid}</td>
				 </tr>
				<tr>
				   <td align="left"><s:message code="FirstMid Name" /></td>
				   <td align="left">${studentEnrollment.user.firstMidName}</td>
				 </tr>
				 <tr>
				   <td align="left"><s:message code="Last Name" /></td>
				   <td align="left">${studentEnrollment.user.lastName}</td>
				 </tr>
				<tr>
				   <td align="left"><s:message code="Student Email" /></td>
				   <td align="left">${studentEnrollment.user.email}</td>
				 </tr>
				<tr>
				   <td align="left"><s:message code="Score" /></td>
				   <td align="left"><form:input path="score"/></td>
				 </tr>
				
				 <tr>
				 <td align="center"><input type="submit" value="Submit"> </td>
				 <td align="left"><input type="reset" value="Reset"></td>
				 </tr>
		</table>
		</center>
	
	</form:form>
</body>
</html>
