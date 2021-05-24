<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<title>Đăng Nhập</title>
</head>

<body>
	<div class="container">
		<div class="login-form">
			<div class="main-div">
				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">
						UserName or PassWord is not valid !!!
					</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">
						Not Permission !!!
					</div>
				</c:if>
				<form action="j_spring_security_check" id="formLogin" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập">
					</div>
					<div class="form-group">
						<input type="password" id="passWord" name="j_password" class="form-control" placeholder="Mật khẩu">
					</div>
					<button type="submit" class="btn btn-primary">Đăng nhập</button>
				</form>
				<div class="card-footer">
					<div class="sign-up">
						Bạn chưa có tài khoản?
						<a href="<c:url value="/dang-ky" />">Đăng ký</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
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
		var data = {};
		$.ajax({
			url: '${userApi}',
			method: 'POST',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(data),
			success: function (result){
				window.location.href = '${registerApi}?message=insert_success';
			},
			error: function (error){
				window.location.href = '${registerApi}?message=error_system';
			},
		})
	});
</script>

</html>
