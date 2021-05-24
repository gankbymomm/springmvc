<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="newAPI" value="/api/new" />
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<div class="main-content">
		<form action="<c:url value='/quan-tri/bai-viet/danh-sach'/>"
			id="formSubmit" method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a
							href='<c:url value="/trang-chu" />'>Trang chủ</a></li>
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
										<c:url var="createNEWURL" value="/quan-tri/bai-viet/chinh-sua" />
										<a flag="info"
											class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title="Thêm bài viết"
											href='${createNEWURL}'> <span> <i
												class="fa fa-plus-circle bigger-110 purple"></i>
										</span>
										</a>
										<button id="btnDelete" name="btnDelete" type="button"  onclick="warningBeforeDelete()" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title="Xóa bài viết" onchange="document.getElementByClass('checkboxId').disabled = !this.checked;" disabled >
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
													<th>Tên Bài Viêt</th>
													<th>Mô Tả Ngắn</th>
													<th>Nội dung</th>
													<th>Thao Tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td><input type="checkbox" name="checkboxId" class="checkboxId" id="checkbox_${item.id}" value="${item.id}" onkeyup="checkForm(this)" /></td>
														<td>${item.title}</td>	
														<td>${item.shortDescription}</td>
														<td>${item.content}</td>
														<td>
															<c:url var="updateNEWURL" value="/quan-tri/bai-viet/chinh-sua">
																<c:param name="id" value="${item.id}" />
															</c:url> 
															<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip" title="Cập nhật bài viết" href='${updateNEWURL}'>
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
		var totalPage = ${model.totalPage};
		var currentPage = ${model.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(2);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
		function warningBeforeDelete() {
			 swal({
			  title: "Xác nhận xóa ",
			  text: "Bạn có chắc xóa nó hay không ?",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-success",
			  cancelButtonClass: "btn-danger",
			  confirmButtonText: "Xóa",
			  cancelButtonText: "Hủy bỏ!",
			}).then(function(isConfirm) {
			  if (isConfirm) {
					var ids = $('tbody input[type=checkbox]:checked').map(function (){
						return $(this).val();
					}).get();
						deleteNew(ids);
			  }
			});
		}
		function deleteNew(data) {
			$.ajax({
				url : '${newAPI}',
				contentType : 'application/json',
				type : 'DELETE',
				data: JSON.stringify(data),
				success: function (result){
					window.location.href = "${NewURL}?page=1&limit=2&message=delete_success";
				},
				error: function (error){
					window.location.href = "${NewURL}?page=1&limit=2&message=error_system";
				}
			});
		} 
		 var chck = $(".checkboxId"), button = $("#btnDelete");
			button.attr("disabled","disabled");
			chck.change(function(){
				if (this.checked) {
					button.removeAttr("disabled");
				} else {
					button.attr("disabled", "disabled");
				}
		});
		/* function checkForm(v) {
			var bt = document.getElementById('btnDelete');
			var ids = $('tbody input[type=checkbox]:checked');
			if (ids == null){
				bt.disabled = false;
				return false;
			} else {
				bt.disabled = true;
			}
		} */
	</script>
</body>

</html>