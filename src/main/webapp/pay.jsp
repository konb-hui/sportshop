<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>淘一淘</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopcart.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sort.js"></script>
    <script src="${pageContext.request.contextPath}/js/holder.js"></script>
    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/order.css">
</head>
<body>
<div id="main" class="container">
    <jsp:include page="header.jsp"/>
</div>
<div class="shopping_cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="account_heading account_heading_ah">
                    <h1 class="header-border">支付界面</h1>
                </div>
            </div>
        </div>
            <div class="modal-body">
                <form class="col-sm-8 form-horizontal" id="updatePsw-form" name="update-form" method="post">
                    <div class="form-group">
                        <label for="star" class="col-sm-2 control-label">支付方式</label>
                        <div class="col-sm-9">
                            <select class="form-control">
                            	<option>微信</option>
                            	<option>支付宝</option>
                            	<option>银联</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="star" class="col-sm-2 control-label">需支付：</label>
                        <div class="col-sm-9">
                           <span id="paymoney" class="form-control">${money}元</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-primary" id="savePay" onclick="pay(this)">确认支付</button>
                        <script type="text/javascript">
                        	function pay(obj) {
								var oid = $(obj).siblings("#oid").val();
								$.ajax({
						            url: "myorderAction_payOrder",
						            type: "POST",
						            data: {
						                oid:oid,
						            },
						            success: function () {
						                swal("购买成功", "", "success");
						                location.href = "myorderAction_listOrder2"
						            },
						            error: function () {
						                swal("购买失败，无法连接到服务器！");
						            }
						        });
							}
                        </script>
                        <input type="hidden" value="${oid}" id="oid">
                    </div>
                </form>
            </div>

    </div>
</div>
<div id="path" hidden>${pageContext.request.contextPath}</div>
</body>
</html>

