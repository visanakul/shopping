<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}">
</c:set>
<spring:url value="/resources/images" var="images"></spring:url>
<spring:url value="/resources/css" var="css"></spring:url>
<spring:url value="/resources/js" var="js"></spring:url>
<spring:url value="/resources/vendor" var="vendor"></spring:url>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>
<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot='${contextRoot}';
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- Bootstrap core CSS -->
<link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<!-- Data table bootstrap-->
<!-- <link href="${css}/dataTables.bootstrap.css" rel="stylesheet"> -->

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">


</head>

<body>
	<div id="wrapper">
		<!-- Navigation -->
		<%@ include file="./shared/navBar.jsp"%>
		<div id="content">
			<!-- Page Content -->
			<!-- Home Page Content if clicks home link-->
			<c:if test="${userClickHome==true }">
				<%@ include file="home.jsp"%>
			</c:if>

			<!-- About Us Page Content if clicks about link-->
			<c:if test="${userClickAbout==true }">
				<%@ include file="about.jsp"%>
			</c:if>

			<!-- Contact Us Page Content if clicks contact link-->
			<c:if test="${userClickContact==true}">
				<%@ include file="contact.jsp"%>
			</c:if>
			
			<!-- Product details Page Content if clicks show product-->
			<c:if test="${userClickShowProduct==true}">
				<%@ include file="singleProduct.jsp"%>
			</c:if>

			<!-- Contact Us Page Content if clicks Product list-->
			<c:if
				test="${userClickAllProducts==true or userClickCategoryProducts==true }">
				<%@ include file="listProducts.jsp"%>
			</c:if>
		</div>

	</div>

	<div class="footer">
		<!-- footer content -->
		<%@ include file="./shared/footer.jsp"%>
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="${vendor}/jquery/jquery.min.js"></script>
	<script src="${vendor}/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Data table -->
	<script src="${js}/jquery.dataTables.js"></script>

	<!-- Data table bootstrap -->
	<!-- <script src="${js}/dataTables.bootstrap.js"></script> -->
	
	<!-- My Application js file -->
	<script src="${js}/myapp.js"></script>

</body>

</html>
