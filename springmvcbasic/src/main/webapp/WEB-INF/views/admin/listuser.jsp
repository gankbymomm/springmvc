<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách người dùng</title>
</head>

<body>
	<div class="main-content">
		<form action="<c:url value='/quan-tri/quan-ly-nguoi-dung'/>"
			id="formSubmit" method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href='<c:url value="/trang-chu" />'>Trang chủ</a></li>
					</ul>
					<!-- /.breadcrumb
						onchange="document.getElementByClass('checkboxId').disabled = !this.checked;"
					 -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty message}">
								<div class="alert alert-${alert}">${message}</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<c:url var="createNEWURL" value="#" />
										<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title="Thêm người dùng" href='${createNEWURL}'> <span> 
											<i class="fa fa-plus-circle bigger-110 purple"></i>
										</span>
										</a>
										<button id="btnDelete" name="btnDelete" type="button"  onclick="warningBeforeDelete()" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title="Xóa người dùng" onchange="document.getElementByClass('checkboxId').disabled = !this.checked;" disabled >
											<span> <i class="fa fa-trash-o bigger-110 pink"></i></span>
										</button>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th><input type="checkbox" name="checkAll" class="checkAll" id="checkAll" ></th>
													<!-- <th>Hình đại diện</th> -->
													<th>Tên người dùng</th>
													<th>Tên đầy đủ</th>
													<th>Thao Tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${user.listResult}">
													<tr>
														<td><input type="checkbox" name="checkboxId" class="checkboxId" id="checkbox_${item.id}" value="${item.id}" /></td>
														<td>${item.userName}</td>	
														<td>${item.fullName}</td>
														<td>
															<c:url var="updateNEWURL" value="3">
																<c:param name="id" value="${item.id}" />
															</c:url> 
															<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip" title="Cập nhật thông tin người dùng" href='${updateNEWURL}'>
																<i class="fa fa-pencil-square-o" aria-hidden="true"></i> 
															</a>
														</td>
													<tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page"> 
										<input type="hidden" value="" id="limit" name="limit">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script>
		var totalPage = ${user.totalPage};
		var currentPage = ${user.page};
		$(function () {
	        window.pagObj = $('#pagination').twbsPagination({
	            totalPages: totalPage,
	            startPage: currentPage,
	            visiblePages: 10,
	            onPageClick: function (event, page) {
	                if (currentPage != page) {
						$("#page").val(page);
						$("#limit").val(6);
						$("#formSubmit").submit();
					}
	            }
	        });
	    });
	</script>
</body>

</html>