<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach" />
<c:url var="newApi" value="/api/new" />
<c:url var="editURL" value="/quan-tri/bai-viet/chinh-sua" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
	<title>Chỉnh sửa bài viết</title>
</head>

<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>

					<li><a href="#">Forms</a></li>
					<li class="active">Thêm bài viết</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">
								${message}
							</div>
						</c:if>
						<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
							<div class="form-group">
								<label for="categoryCode" class="col-sm-3 control-label no-padding-right">Thể
									loại:</label>
								<div class="col-sm-9">
									<form:select path="categoryCode" id="categoryCode">
										<form:option value="" label="-- Chọn thể loại --" />
										<form:options items="${categories}" />
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên
									bài viết</label>
								<div class="col-sm-9">
									<form:input path="title" cssClass="col-xs-10 col-sm-5" id="title" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Ảnh
									đại diện</label>
								<div class="col-sm-9">
									<input type="file" class="col-xs-10 col-sm-5" id="thumbNail"
										name="thumbNail" />
								</div>
							</div>
							<div class="form-group">
								<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Mô
									tả ngắn:</label>
								<div class="col-sm-9">
									<form:textarea path="shortDescription" rows="5" cols="10"
										cssClass="form-control" id="shortDescription" />
								</div>
							</div>
							<div class="form-group">
								<label for="content" class="col-sm-3 control-label no-padding-right">Nội
									dung:</label>
								<div class="col-sm-9">
									<form:textarea path="content" rows="5" cols="10" cssClass="form-control"
										id="content" />
								</div>
							</div>
							<form:hidden path="id" id="newId" />
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<c:if test="${not empty model.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i>
											Cập nhật bài viết
										</button>
									</c:if>
									<c:if test="${empty model.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i>
											Thêm bài viết
										</button>
									</c:if>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i>
										Hủy
									</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddOrUpdateNew').click(function (e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function (i, v) {
				data[""+v.name+""] = v.value;
			});
			var id = $('#newId').val();
			if (id == "") {
				addNew(data);
			} else {
				updateNew(data);
			}
		});
		function addNew(data) {
			$.ajax({
				url: '${newApi}',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function (result) {
					window.location.href = "${editURL}?page=1&limit=2&id="+result.id+"&message=insert_success";
				},
				error: function (error) {
					window.location.href = '${newURL}?page=1&limit=2&message=error_system';
				}
			});
		}
		function updateNew(data) {
			$.ajax({
				url: '${newApi}',
				type: 'PUT',
				contentType: 'application/json',
				dataType: 'json',
				data: JSON.stringify(data),
				success: function (result) {
					window.location.href = '${editURL}?page=1&limit=2&id='+result.id+'&message=update_success';
				},
				error: function (error) {
					window.location.href = '${editURL}?page=1&limit=2&id='+result.id+'&message=error_system';
				}
			});
		}
	</script>

</body>

</html>