 $(document).ready(function(){
     var websocket = null;
     //存储联系人
     var user = [];
     //存储未读消息数
     var num = [];
     //定位
     var i = 0;
     $(".chat-input").hide();
     $.ajax({
	        url: "chatAction_getData",
	        type: "post",
	        data: {},
      success: function(result){
    	  $.each(result.userdata,function(key,values){
    			  user[i] = values[1];
    			  num[i] = values[2];
    			  var str = values[0] + "";
    			  $(".text-uppercase").prepend('<li><a href="javascript:void(0)" value="' + values[0] + '" flag="' + values[1] +'" class="active" onclick="showMsg(this)" id="'+ str + '">' + values[1] + '(' + values[2] + ')</a></li>');
    		  i++;
    	  })
      },
      error:function (){
          alert("初始化失败");
      }
  });
                //判断当前浏览器是否支持WebSocket
                if ('WebSocket' in window) {
                    websocket = new WebSocket("ws://localhost:8080/sportshop/ws/bitcoinServer");

                    //连接成功建立的回调方法
                    websocket.onopen = function () {
                    	var array = new Array();
                    	array[0] = "-2";
                        websocket.send(array);
                    }
                    $("#send-message").click(function() {
                    	var mydate = new Date();
        				var t=mydate.toLocaleString('chinese', { hour12: false });
            			var sendMsg = $("#input-message").val();
            			if(sendMsg.trim != ""){
            	            var element = '<div class="chat-message2 chat-message"> <div class="chat-message-content2  animated slideInRight">' + t + '<br/><div class="info-content"> ' + sendMsg + '</div> </div> </div>';
            	            var element_float = '<div class="clear-float"></div>';
            	            $(".chat-content-body").append(element, element_float);


            	            //始终保持滚动条滚动到最下方
            	            $(".chat-content").scrollTop($(".chat-content")[0].scrollHeight);
            	            var array = new Array();
            	        	array[0] = $("#sendId").text();
            	        	array[1] = $("#receiveId").text();
            	        	array[2] = sendMsg;
            	        	websocket.send(array);
            			}
            			$("#input-message").val("");
            		});
                    //接收到消息的回调方法
                    websocket.onmessage = function (event) {
                    	var mydate = new Date();
        				var t=mydate.toLocaleString('chinese', { hour12: false });
                    	var strs = event.data.split(",",3);
                    	//判断是否为第一个联系人
                    	if(i == 0){
                    		user[i] = strs[1];
                    		num[i] = 0;
                    		i++;
                    		$(".text-uppercase").append('<li><a href="javascript:void(0)" value="' + parseInt(strs[0]) + '" flag="' + strs[1] +  '" class="active" onclick="showMsg(this)" id="'+ strs[0] + '">' + strs[1] + '</a></li>');
                    	}else{
                    		var flag = true;
                    		for(var j = 0; j < user.length;j++){
                    			if(user[j] == strs[1]){
                    				flag = false;
                    				num[j]++;
                    				break;
                    			}
                    		}
                			//是新增联系人就添加
                			if(flag){
                				user[i] = strs[1];
                				num[i] = 1;
                				i++;
                				$(".text-uppercase").append('<li><a href="javascript:void(0)" value="' + parseInt(strs[0]) + '" flag="' + strs[1] +  '" class="active" onclick="showMsg(this)" id="'+ strs[0] + '">' + strs[1] + '</a></li>');
                			}
                    	}
                    	if($("#receiveId").text().trim() != ""){
                    		if(strs[0] != $("#receiveId").text().trim()){
                    			//遍历user找到当前user的未读消息数
                    			var a = 0;
                    			for(var j = 0; j < user.length;j++){
                    				if(user[j] == strs[1]){
                    					a = j;
                    					break;
                    				}
                    			}
                    			$("#" + strs[0]).text(strs[1] + "(" + num[a] +  ")");
                    		}
                    	}else{
                    		var a = 0;
                			for(var j = 0; j < user.length;j++){
                				if(user[j] == strs[1]){
                					a = j;
                					break;
                				}
                			}
                			$("#" + strs[0]).text(strs[1] + "(" + num[a] +  ")");
                			add(parseInt(strs[0]),parseInt($("#sendId").text()),strs[2],0,t);
                    	}
                    	if(strs[0] == $("#receiveId").text().trim()){
                            var element = '<div class="chat-message1 chat-message"> <div class="chat-message-content1">' + t + '<br/><div class="info-content"> ' + strs[2] + '</div> </div> </div>';
                            var element_float = '<div class="clear-float"></div>';
                            $(".chat-content-body").append(element, element_float);

                            //始终保持滚动条滚动到最下方
                            $(".chat-content").scrollTop($(".chat-content")[0].scrollHeight);
                    	}
                    }
                    
                    //连接发生错误的回调方法
                    websocket.onerror = function () {
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
                	if($("#receiveId").text().trim() != ""){
                		var s = $("#receiveId").text();
            			$.ajax({
            		        url: "chatAction_changeStatus",
            		        type: "post",
            		        data: {
            		        	senduser:s,
            		        },
            		     success: function(result){
            		     },
            		     error:function (){
            		         alert("发送失败");
            		     }
            		 });
                	}
                    websocket.close();
                }
                
            });
 function showMsg(obj) {
	 if($("#receiveId").text().trim() != ""){
		 var s = $("#receiveId").text();
			$.ajax({
		        url: "chatAction_changeStatus",
		        type: "post",
		        data: {
		        	senduser:s,
		        },
		     success: function(result){
		     },
		     error:function (){
		         alert("发送失败");
		     }
		 });
	 }
	$(".chat-input").show();
	$(".chat-content-body").children().remove();
	var senduser = $(obj).attr("value");
	var receiveuser = $("#sendId").text();
	$("#receiveId").text($(obj).attr("value"));
	$("#receive").text($(obj).attr("flag"));
	$("#" + $(obj).attr("value")).text($(obj).attr("flag") + "(0)");
	$.ajax({
        url: "chatAction_getUnreadMsg",
        type: "post",
        data: {
        	senduser:senduser,
        	receiveuser:receiveuser,
        },
     success: function(result){
    	 var history = '<a href="javascript:void(0)" id="record" onclick="showRecordMsg(this)">点击获取聊天记录</a>';
		 $(".chat-content-body").prepend(history);
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
 function showRecordMsg(obj) {
	$(obj).remove();
	var senduser = $("#receiveId").text().trim();
	$.ajax({
        url: "chatAction_getReadMsg",
        type: "post",
        data: {
        	senduser:senduser,
        },
     success: function(result){
    	 $.each(result.read,function(key,values){
    		 if(values.senduser == senduser){
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
           