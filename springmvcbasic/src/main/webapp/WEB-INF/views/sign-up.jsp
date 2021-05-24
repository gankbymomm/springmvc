<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="successRegistration" value="/dang-nhap" />
<c:url var= "failRegistration" value="/dang-ky" />
<c:url var="userApi" value="/api/user" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
</head>
<body id="RegisterForm">
	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-body">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
							${message}
						</div>
					</c:if>
					<form:form method="POST" name="theForm" modelAttribute="user" id="formSubmit" action="#" role="form">
						<div class="form-group">
							<h2>Đăng ký tài khoản</h2>
						</div>
						<div class="form-group">
							<label class="control-label" for="signupName">Tên đăng nhập</label>
							<form:input id="username" path="userName" type="text" maxlength="50" class="form-control"
								placeholder="Nhập tên tài khoản" onkeyup="checkForm(this)" />
								<form:errors path="userName" cssClass="text-danger"/>
						</div>
						<%-- <form:errors path="userName" cssClass="text-danger"/> --%>
						<div class="form-group">
							<label class="control-label" for="signupFullName">Tên đầy đủ</label>
							<form:input path="fullName" id="fullname" type="text" maxlength="50" class="form-control"
								placeholder="Tên đầy đủ" onkeyup="checkForm(this)"/>
								<form:errors path="fullName" cssClass="text-danger"/>
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPassword">Mật khẩu</label>
							<form:input path="passWord" id="password" type="password" maxlength="25" class="form-control"
								placeholder="Mật khẩu ít nhất 6 ký tự" length="40" onkeyup="checkForm(this)" />
								<form:errors path="passWord" cssClass="text-danger"/>
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPasswordagain">Nhập lại mật
								khẩu</label>
							<form:input path="passWordConfirm" id="passwordconfirm" type="password" maxlength="25" class="form-control"
								placeholder="Nhập lại mật khẩu" onkeyup="checkForm(this)" />
								<form:errors path="passWordConfirm" cssClass="text-danger"/>
						</div>
						<div class="form-group">
							<button id="signupSubmit" type="submit" class="btn btn-info btn-block" >Tạo
								tài khoản</button>
						</div>
						<p class="form-group">Xem lại <a href="#">chính sách </a> của trang web.</p>
						<hr>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	function checkForm(txt) {
		var bt = document.getElementById('signupSubmit');
		var ele = document.getElementsByTagName('input');
		for (var i = 0; i < ele.length; i++) {
			if (ele[i].type == 'text' && ele[i].type == 'password' && ele[i].value == '') {
				bt.disabled = true;
				return false;
			} else {
				bt.disabled = false;
			}
		}
	}
	$('#signupSubmit').click(function (e) {
		e.preventDefault();
		$.ajax({
			url: '${userApi}',
			method: 'POST',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(data),
			success: function (result){
				window.location.href = '${successRegistration}?message=insert_success';
			},
			error: function (error){
				window.location.href = '${failRegistration}?message=error_system';
			},
		})
	});
</script>

</html>