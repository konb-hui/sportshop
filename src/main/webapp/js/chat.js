$(document).ready(function(){
	$("#message").text("消息(" + $("#message").attr("value") + ")");
    initdata();
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/sportshop/ws/bitcoinServer");

        //连接成功建立的回调方法
        websocket.onopen = function () {
        	var array = new Array();
        	array[0] = $("#chatUid").val();
            websocket.send(array);
        }
        var history = '<a href="javascript:void(0)" id="record" onclick="showRecordMsg(this)">点击获取聊天记录</a>';
		 $(".chat-content-body").append(history);
        $("#send-message").click(function() {
			var sendMsg = $("#input-message").val();
			if(sendMsg.trim != ""){
				var mydate = new Date();
				var t=mydate.toLocaleString('chinese', { hour12: false });
	            var element = '<div class="chat-message2 chat-message"><div class="chat-message-content2  animated slideInRight">' + t + '<br/><div class="info-content"> ' + sendMsg + '</div> </div> </div>';
	            var element_float = '<div class="clear-float"></div>';
	            $(".chat-content-body").append(element, element_float);


	            //始终保持滚动条滚动到最下方
	            $(".chat-content").scrollTop($(".chat-content")[0].scrollHeight);
	            var array = new Array();
	        	array[0] = $("#sendId").text();
	        	array[1] = "-2";
	        	array[2] = $("#send").text().trim();
	        	array[3] = sendMsg;
	        	websocket.send(array);
			}
			$("#input-message").val("");
		});

        //接收到消息的回调方法
        websocket.onmessage = function (event) {
        	if($("#sendId").text() == ""){
        		$.ajax({
        	        url: "chatAction_changeChatNum",
        	        type: "post",
        	        data: {},
        	     success: function(result){
        	    	 $("#message").text("消息(" + result.num + ")");
        	     },
        	     error:function (){
        	         alert("发送失败");
        	     }
        	 });
        	}
        	var mydate = new Date();
			var t=mydate.toLocaleString('chinese', { hour12: false });
            var element = '<div class="chat-message1 chat-message"> <div class="chat-message-content1">' + t + '<br/><div class="info-content"> ' + event.data + '</div> </div> </div>';
            var element_float = '<div class="clear-float"></div>';
            $(".chat-content-body").append(element, element_float);

            //始终保持滚动条滚动到最下方
            $(".chat-content").scrollTop($(".chat-content")[0].scrollHeight);
        }
        
        //连接发生错误的回调方法
        websocket.onerror = function () {
            alert("WebSocket连接发生错误");
        };

       //连接关闭的回调方法
        websocket.onclose = function () {
        }

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            closeWebSocket();
        }
        
    }
    else {
        alert('当前浏览器 Not support websocket')
    }


    //关闭WebSocket连接
    function closeWebSocket() {
    	if($("#sendId").text() != ""){
        	var s = $("#receiveId").text();
    		$.ajax({
    	        url: "chatAction_changeStatus",
    	        type: "post",
    	        data: {
    	        	senduser:s,
    	        },
    	     success: function(result){
    	    	 alert(result);
    	     },
    	     error:function (){
    	     }
    	 });
    	}
        websocket.close();
    }
    
});
function showRecordMsg(obj) {
	$(obj).remove();
	var senduser = $("#sendId").text().trim();
	$.ajax({
        url: "chatAction_getReadMsg",
        type: "post",
        data: {
        	senduser:senduser,
        },
     success: function(result){
    	 $.each(result.read,function(key,values){
    		 if(values.receiveuser == senduser){
    			 var element = '<div class="chat-message1 chat-message"> <div class="chat-message-content1">' + values.msgtime + '<br/><div class="info-content"> ' + values.msgcontent + '</div> </div> </div>';
                 var element_float = '<div class="clear-float"></div>';
                 $(".chat-content-body").prepend(element, element_float);

                 //始终保持滚动条滚动到最下方
                 $(".chat-content").scrollTop($(".chat-content")[0].scrollHeight); 
    		 }else{
    			var element = '<div class="chat-message2 chat-message"> <div class="chat-message-content2  animated slideInRight">' + values.msgtime + '<br/><div class="info-content"> ' + values.msgcontent + '</div> </div> </div>';
 	            var element_float = '<div class="clear-float"></div>';
 	            $(".chat-content-body").prepend(element, element_float);


 	            //始终保持滚动条滚动到最下方
 	            $(".chat-content").scrollTop($(".chat-content")[0].scrollHeight);
    		 }
    	 })
     },
     error:function (){
         alert("发送失败");
     }
 });
}
function initdata() {
	if($("#sendId").text() != ""){
		var senduser = $("#receiveId").text();
		var receiveuser = $("#sendId").text();
		$.ajax({
	        url: "chatAction_getUnreadMsg",
	        type: "post",
	        data: {
	        	senduser:senduser,
	        	receiveuser:receiveuser,
	        },
	     success: function(result){
	    	 $.each(result.unread,function(key,values){
	    		 if(values.senduser == senduser){
	    			 var element = '<div class="chat-message1 chat-message"> <div class="chat-message-content1">' + values.msgtime + '<br/><div class="info-content"> ' + values.msgcontent + '</div> </div> </div>';
	                 var element_float = '<div class="clear-float"></div>';
	                 $(".chat-content-body").append(element, element_float);

	                 //始终保持滚动条滚动到最下方
	                 $(".chat-content").scrollTop($(".chat-content")[0].scrollHeight);
	    		 }else{
	    			 var element = '<div class="chat-message2 chat-message"> <div class="chat-message-content2  animated slideInRight">' + values.msgtime + '<br/><div class="info-content"> ' + values.msgcontent + '</div> </div> </div>';
	  	            var element_float = '<div class="clear-float"></div>';
	  	            $(".chat-content-body").append(element, element_float);


	  	            //始终保持滚动条滚动到最下方
	  	            $(".chat-content").scrollTop($(".chat-content")[0].scrollHeight);
	    		 }
	    		 
	    	 })
	     },
	     error:function (){
	         alert("发送失败");
	     }
	 });
	}
}