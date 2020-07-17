<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/css/table-product.css" />" rel="stylesheet">
<%@ page contentType="text/html; charset=UTF-8" %>

<div class="product">
	<br>
	<div class="table100 ver1">
		<div class="table100-head">
			<table>
				<thead>
					<tr class="row100 head">
						<th class="cell100 column1">Code</th>
						<th class="cell100 column2">Name</th>
						<th class="cell100 column3">Cost Price</th>
						<th class="cell100 column4">Selling Price</th>
						<th class="cell100 column4">Created Date</th>
						<th class="cell100 column5">Image</th>
						<th class="cell100 column6">Action</th>
					</tr>
				</thead>
			</table>
		</div>

		<div class="table100-body">
			<table>
				<tbody>
					<c:if test="${not empty products}">
						<c:forEach var="product" items="${products}">
							<tr class="row100 body">
								<td class="cell100 column1"><c:out value="${product.code}"></c:out></td>
								<td class="cell100 column2"><c:out value="${product.name}"></c:out></td>
								<td class="cell100 column3"><c:out value="${product.costPrice}"></c:out></td>
								<td class="cell100 column4"><c:out value="${product.sellingPrice}"></c:out></td>
								<td class="cell100 column4"><c:out value="${product.createdDate}"></c:out></td>
								<td class="cell100 column5">
									<img src="<c:url value="${product.imageUris[0]}" />" />
								</td>
								
								<td class="cell100 column6">
									<button><i class="glyphicon glyphicon-pencil"></i></button>
									<button><i class="glyphicon glyphicon-trash"></i></button>
								</td>
							</tr>	
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>