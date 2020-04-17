<%@ page language="java"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>会员</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sort.js"></script>
    <script src="${pageContext.request.contextPath}/js/holder.js"></script>
</head>
<script type="text/javascript">
   $(document).ready(function () {
	   $("#buy").click(function(){
		   var monthnum = $("#monthnum1").val();
           $.ajax({
               url:"./userAction_becomeVip",
               type:"POST",
               data:{
                   monthnum:monthnum
               },
               success:function (result) {
					alert("购买成功");
					history.go(0);
               },
               error:function () {
                   alert("购买失败");
               }
           })
	   });
	   	   $('#renew').click(function(){
		   var monthnum = $('#monthnum2').val();
           $.ajax({
               url:"./userAction_renewVip",
               type:"POST",
               data:{
                   monthnum:monthnum
               },
               success:function (result) {
					alert("续费成功");
					history.go(0);
               },
               error:function () {
                   alert("续费失败");
               }
           })
	   });
   });
</script>
<body>
<div id="main" class="container">

    <div id="header">
        <%@ include file="header.jsp" %>
    </div>
    <h1 style="color:red">成为VIP，购物享优惠，更有购物积分换换取礼品,每月只需30元</h1>
    <c:if test="${!isVip }">
    购买<input type="number" value="1" name="monthnum1" id="monthnum1">月<button style="background: white;color: red" id="buy" name="buy">点击购买</button>
    </c:if>
  <c:if test="${isVip }">
  您的VIP到
                                                                          <time datetime="${user.endTime}">
                                                                            ${user.endTime.year+1900}年
                                                                            ${user.endTime.month+1}月
                                                                            ${user.endTime.date}日
                                                                        </time>到期
                                                                        <br/>
    续费<input type="number" value="1" name="monthnum2" id="monthnum2">月<button style="background: white;color: red" id="renew" name="renew">点击购买</button>
    <button style="background: red;color: black">前往兑换商品</button>
    </c:if>
</div>
</body>
</html>