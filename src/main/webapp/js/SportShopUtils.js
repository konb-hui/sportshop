var SportShopUtils = {
	/**
	 * 基础数据模块
	 */
	basedata:{
		/**
		 *基础数据模块的查询页面的删除功能的处理 
		 */
		deleteObj:{
			/**
			 *当页面上的复选框被选中以后 ，点击删除按钮要做的事
			 */
			deleteFunction:function(config){
				$.deleteObj(config);
			},
			/**
			 * 当页面的单项删除被选中后要做的事
			 */
			deleteOneFunction:function(config){
				$.deleteOne(config);
			}
			
		},
		/**
		 * 修改的逻辑
		 */
		updateObj:{
			updateFunction:function(config){
				$.updateEvent(config);
			}
		},
		/**
		 * 分页的逻辑
		 */
		dispage:{
			/**
			 * 当点击首页、上一页、下一页、尾页的时候，要跳转到的action
			 */
			linkNextPage:function(){
				/**
				 * this为当前的按钮
				 */
				var currentPage = $(this).attr("param");
				var url = $("body").data("url");
				window.location.href = url+"?currentPage="+currentPage;
			}
		},
		/**
		 * 初始化事件
		 */
		initEvent:function(){
			/**
			 * 给首页添加click事件
			 */
			$("input[flag='firstPage']").unbind("click");
			$("input[flag='firstPage']").bind("click",function(){
				
					/**
					 * this就代表首页的按钮
					 */
				SportShopUtils.basedata.dispage.linkNextPage.call(this);
			});
			
			/**
			 * 给上一页添加click事件
			 */
			$("input[flag='prePage']").unbind("click");
			$("input[flag='prePage']").bind("click",function(){
				if($(this).attr("param")=="0"){
					alert("已经是第一页了");
				}else{
					/**
					 * this就代表首页的按钮
					 */
					SportShopUtils.basedata.dispage.linkNextPage.call(this);
				}
			});
			
			/**
			 * 给下一页添加click事件
			 */
			$("input[flag='nextPage']").unbind("click");
			$("input[flag='nextPage']").bind("click",function(){
				/**
				 * linkNextPage函数中的this代表"下一页"的按钮的对象
				 */
				var totalPages = $(this).attr("last");//总的页数
				if($(this).attr("param")>totalPages){//已经没有下一页了
					alert("已经是最后一页了");
				}else{
					SportShopUtils.basedata.dispage.linkNextPage.call(this);
				}
			});
			
			/**
			 * 给尾页添加click事件
			 */
			$("input[flag='lastPage']").unbind("click");
			$("input[flag='lastPage']").bind("click",function(){
				SportShopUtils.basedata.dispage.linkNextPage.call(this);
			});
			/**
			 * 给跳转添加click事件
			 */
			$("#jump").unbind("click");
			$("#jump").bind("click",function(){
				var currentPage = $("#pageNo").val();
				var totalPages = $(this).attr("last");//总的页数
				if(currentPage < 1 || currentPage > totalPages){
					alert("请输入正确的页数");
				}else{
					var url = $("body").data("url");
					window.location.href = url+"?currentPage="+currentPage;
				}
			});
		}
	},
};
