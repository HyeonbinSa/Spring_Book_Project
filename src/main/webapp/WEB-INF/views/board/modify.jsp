<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp" %>



<form role="form" method="post">

<div class="box-body">
	<div class="form-group">
		<label for="exampleInputBno1">Bno</label>
		<input type="text" name="bno" class="form-control" value="${boardVO.bno }" readonly="readonly">
	</div>	
	<div class="form-group">
		<label for="exampleInputTitle1">Title</label>
		<input type="text" name="title" class="form-control" value="${boardVO.title }" >
	</div>
	<div class="form-group">
		<label for="exampleInputPawword1">Content</label>
		<textarea class="form-control" name="content" rows="3">${boardVO.content}</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputWriter1">Writer</label>
		<input type="text" name="writer" class="form-control" value="${boardVO.writer }" >
	</div>
</div>
<div class="box-footer">
	<button type="submit" class="btn btn-primary">SAVE</button>
	<button type="submit" class="btn btn-warning">CANCEL</button>
	<script>
$(document).ready(function(){
 var formObj = $("form[role='form']");
 console.log(formObj);

 $(".btn-primary").on("click", function(){
	 formObj.submit();
	 }); 
 $(".btn-warning").on("click", function(){
	self.location="/board/listAll";
 });
});
</script>
</div>

</form>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
