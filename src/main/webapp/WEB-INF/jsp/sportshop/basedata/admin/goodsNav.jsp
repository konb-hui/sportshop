<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="templatemo-top-nav-container">
    <div class="row">
        <nav class="templatemo-top-nav col-lg-12 col-md-12">
            <ul class="text-uppercase">
                <li><a href="goodAction_listGood">所有商品</a></li>
                <li><a href="#" id="add">添加商品</a></li>
            </ul>
            <span>&nbsp;</span>
                    <select id="changecategory" name="changecategory">
                    <option value="选择">选择类别</option>
                          <c:forEach items="${categories}" var="category">
                           <option value="${category.cid}" ${cid == category.cid ?"selected":"" }>${category.cname}</option>
                           </c:forEach>
                    </select>
                    <span>&nbsp;</span>
                    <select id="changebrand" name="changebrand">
                    <option value="选择">选择品牌</option>
                          <c:forEach items="${brands}" var="brand">
                           <option value="${brand.bid}" ${bid == brand.bid ?"selected":"" }>${brand.bname}</option>
                           </c:forEach>
                    </select>
                    <span>&nbsp;</span>
                    <input type="text" placeholder="输入id或商品名" id="key" name="key" value="${key}">
                    <span>&nbsp;</span>
                    <button class="btn btn-default" id="search">
                        <span>搜索</span>
                    </button>
        </nav>
    </div>
</div>

