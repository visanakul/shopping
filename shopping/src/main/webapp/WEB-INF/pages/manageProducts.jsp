<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissble">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product name </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" class="form-control" />
								<sf:errors cssClass="help-block" path="name" element="em"></sf:errors>
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand name </label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									class="form-control" />
								<sf:errors cssClass="help-block" path="brand" element="em"></sf:errors>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter
								description </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									class="form-control" />
								<sf:errors cssClass="help-block" path="description" element="em"></sf:errors>

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								unit price </label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPrice" id="unitPrice"
									class="form-control" />
								<sf:errors cssClass="help-block" path="unitPrice" element="em"></sf:errors>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								quantity </label>
							<div class="col-md-8">
								<sf:input type="text" path="quantity" id="quantity"
									class="form-control" />
								<sf:errors cssClass="help-block" path="quantity" element="em"></sf:errors>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								Image : </label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors cssClass="help-block" path="file" element="em"></sf:errors>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								category </label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />

							</div>
						</div>
						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btb btn-primary" />
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
								<sf:hidden path="active" />
							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>