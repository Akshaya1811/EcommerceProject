<%@include file="Header.jsp"%>

<h2 align="center">Manage Category</h2>
<form action="<c:url value="/UpdateCategory"/>" method="post">
<table align="center">
<tr>
		<td> Category Id</td>td>
		<td> <input type="text" name="catId" readonlyvalue="${category.categoryId}"/></td>
</tr>
<tr>
		<td> Category Name</td>td>
		<td><input type="text" name="catName" value="${category.categoryName}"/></td>
<tr>
<tr>
		<td> Category Desc</td>td>
		<td><input type="text" name="catDesc"/>"${category.categoryDesc}"/></td>
<tr>
<tr>
		<td colspan="2"><input type="submit" value="Update Category"/></td>
</tr>				
</table>
</form>