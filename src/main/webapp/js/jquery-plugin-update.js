(function(jQuery){
	$.updateEvent = function(config) {
		$("input[value='修改']").unbind("click");
		$("input[value='修改']").bind("click",function(){
			/**
			 * 获取id
			 */
			var id = $(this).parent().siblings("td:first").children("input").attr("value");
			window.location.href = config.url+"?"+config.id+"="+id;
		});
	}
})(jQuery);