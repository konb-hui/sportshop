<%--
  Created by IntelliJ IDEA.
  User: 文辉
  Date: 2017/7/25
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>淘一淘-搜索${keyword}</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sort.js"></script>
    <script src="${pageContext.request.contextPath}/js/holder.js"></script>
    <style>
        .like-button {
            left: 80% !important;
            top: 70% !important;
        }
        .data>ul {
            padding: 0;
        }
        .page-div {
            margin-top: 10px;
        }
        .page-info {
            padding: 35px 35px 35px 55px;
        }
    </style>
</head>
<body>
<div id="main" class="container">
    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>
    <div class="content">
        <div class="module">
            <div class="">
                <h3>
                    搜索结果><span style="color: red;">${keyword}</span>
                </h3>
                <hr>
            </div>

            <div class="bd">
                <div class="data">
                    <ul>
                        <c:forEach items="${goods}" var="good">
                            <li class="data-item-li">
                                <div class="to-big">
                                    <a href="goodAction_showDetail?gid=${good.gid}"> <img src="${pageContext.request.contextPath}/${good.images}/1.jpg" width="260px" height="260px" alt=""/>
                                    </a>
                                </div>
                                <p class="text-right">
                                    <a href="goodAction_showDetail?gid=${good.gid}">${good.gname}</a>
                                </p>
                                <div class="text-right">
                                    <b>普通价：￥${good.price}</b><b>会员价￥${good.vipPrice}</b>
                                </div>
                            </li>
                        </c:forEach>

                        <div class="clear-float" style="clear: both;"></div>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
