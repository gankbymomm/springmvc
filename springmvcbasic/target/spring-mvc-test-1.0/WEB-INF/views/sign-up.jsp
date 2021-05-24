<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="registerAPi" value="/dang-ky" />
<c:url var="userApi" value="/api/user" />
<!DOCTYPE html>
<html>

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
							<input id="username" type="text" maxlength="50" class="form-control"
								placeholder="Nhập tên tài khoản" onkeyup="checkForm(this)" />
						</div>
						<div class="form-group">
							<label class="control-label" for="signupFullName">Tên đầy đủ</label>
							<input id="fullname" type="text" maxlength="50" class="form-control"
								placeholder="Tên đầy đủ" onkeyup="checkForm(this)"/>
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPassword">Mật khẩu</label>
							<input id="password" type="password" maxlength="25" class="form-control"
								placeholder="Mật khẩu ít nhất 6 ký tự" length="40" onkeyup="checkForm(this)" />
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPasswordagain">Nhập lại mật
								khẩu</label>
							<input id="passwordagain" type="password" maxlength="25" class="form-control"
								placeholder="Nhập lại mật khẩu" onkeyup="checkForm(this)" />
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
		var data = {};
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function (i, v) {
			data["" + v.name + ""] = v.value;
		});
		addUser(data);
	});
	function addUser(data){
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
				window.location.href = '${registerApi}?message=error_success';
			},
		})
	}
</script>

</html>