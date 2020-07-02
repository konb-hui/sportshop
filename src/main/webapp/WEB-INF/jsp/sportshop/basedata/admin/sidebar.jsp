<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="templatemo-sidebar">
    <header class="templatemo-site-header">
        <div class="square"></div>
        <h1>后台管理</h1>
    </header>
    <div class="mobile-menu-icon">
        <i class="fa fa-bars"></i>
    </div>
    <nav class="templatemo-left-nav">
        <ul>
        <c:forEach items="${sessionScope.functions}" var="privilege">
        	<li><a href="${privilege.link}"><i class="${privilege.icon}"></i>${privilege.functionName}</a></li>
        </c:forEach>
            <li><a href="chatAction_chatUser"><i class="fa fa-user fa-fw"></i>聊天</a></li>
            <li><a href="adminAction_showSelf"><i class="fa fa-user fa-fw"></i>个人信息</a></li>
            <li><a href="adminAction_adminLogout"><i class="fa fa-eject fa-fw"></i>退出系统</a></li>
        </ul>
    </nav>
</div>
