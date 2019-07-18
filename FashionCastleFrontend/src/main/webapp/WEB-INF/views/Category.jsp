<%@include file="Header.jsp"%>

<h2 align="center">Manage Category</h2>
<form action="InsertCategory" method="post">
<table align="center">
	<tr>
			<td>Category Name</td>
			<td><input type="text" name="catName"/></td>
	</tr>
	<tr>
			<td>Category Desc</td>
			<td> <input type="text" name="catDesc"/><td>
	</tr>
	<tr>
			<td colspan="2"><input type="submit" value="Insert Category"/></td>				
	</tr>
	
</table>
</form>
<table align="center">

<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operation</td>
</tr>
<c:forEach items="$(categoryList)" var="category">
<tr>
	<td>$(category.categoryId)</td>
	<td>$(category.categoryName)</td>
	<td>$(category.categoryDesc)</td>
	<td><a href="<c:url value="/deleteCategory/$(category.categoryId" />">Delete</a></td>
	<td><a href="<c:url value="/editCategory/$(category.categoryId" />">edit</a></td>
</tr>
</c:forEach>

</table>