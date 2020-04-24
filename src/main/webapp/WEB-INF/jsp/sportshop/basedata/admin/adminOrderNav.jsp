
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="templatemo-top-nav-container">
    <div class="row">
        <nav class="templatemo-top-nav col-lg-12 col-md-12">
            <ul class="text-uppercase">
                <li><a href="myorderAction_listOrderForAdmin">未发货</a></li>
                <li><a href="myorderAction_listReceivedOrder">已发货</a></li>
                <li><a href="myorderAction_listCompletedOrder">已完成</a></li>
            </ul>
         <span>&nbsp;</span>
              <input type="text" placeholder="输入订单号查找" id="oid" name="oid" value="${oid}">
              <span>&nbsp;</span>
          <button class="btn btn-default" id="search" onclick="search(this)">
              <span>搜索</span>
          </button>
          <input type="hidden" id="status" value="${status}">
                    <script type="text/javascript">
          	function search(obj) {
				var status = $(obj).siblings("#status").val();
				var oid = $("#oid").val();
				window.location.href =$("body").data("url") + "?status=" + status + "&oid=" + oid;
			}
          </script>
        </nav>
    </div>
</div>
