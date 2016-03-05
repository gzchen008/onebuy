$(function() {
		//slider
	    var $slider = $('#demo-slider-0');
	    var counter = 0;
	    var getSlide = function() {
	      counter++;
	      return '<li><img src="http://s.amazeui.org/media/i/demos/bing-' +
	        (Math.floor(Math.random() * 4) + 1) + '.jpg" />' +
	        '<div class="am-slider-desc">动态插入的 slide ' + counter + '</div></li>';
	    };

	    $('.js-demo-slider-btn').on('click', function() {
	      var action = this.getAttribute('data-action');
	      if (action === 'add') {
	        $slider.flexslider('addSlide', getSlide());
	      } else {
	        var count = $slider.flexslider('count');
	        count > 1 && $slider.flexslider('removeSlide', $slider.flexslider('count') - 1);
	      }
	    });
	    //header right
	    $("#fenlei").on("click",function(){
	    	$(".ui-actionsheet").addClass("show");
	    });
	    $(".ui-actionsheet-cancel").on("click",function(){
	    	$(".ui-actionsheet").removeClass("show");
	    });
	    //post.html
	    $(window).scroll(function(){
	    	var btop = document.body.scrollTop;
	    	if(btop>5){
	    		$(".am-tabs-nav").addClass("tabfixed");
	    		$(".ui-header").css("display","none");
	    		$(".am-tabs-nav").css("margin-top","0px")	
	    	}else{
	    		$(".am-tabs-nav").removeClass("tabfixed");
	    		$(".ui-header").css("display","block");
	    		$(".am-tabs-nav").css("margin-top","45px");
	    	}
	    });

	    //cart.html
	    //confirm delete
	    $("#delLink").on('click',function(){
	    	$(".mask").fadeIn(200);
	    	setTimeout(function time(){
	    		$("#pageDialog").css("display","block")
	    	}, 300);
	    	$("#btnMsgCancel").on('click',function(){
	    		$("#pageDialog").css("display","none");
	    		$(".mask").fadeOut(200);
	    	});
	    	$("#btnMsgOk").on('click',function(){
	    		$("#delLink").closest("#cartBody").detach();
	    		$("#pageDialog").css("display","none");
	    		$(".mask").fadeOut(200);//!!!!当id多的时候，存在一个就近选择的问题
	    		$("#mycartpay").css("display","none");
	    		setTimeout(function empty(){
	    			$("#divNone").css("display","block");	
	    		},300);
	    		$("#numadd").on('click',function(){
	    			var value =  parseInt($("#txtNum").val())+1;
	    			$("#txtNum").value = value + "";
	    		});
	    	});
	    });

	    //edit_message.html
});
//function:go back to 
window.onload=function(){
	var topbtn=document.getElementById("div_fastnav");         
	var timer=null;                               //set a timemachine
	window.onscroll=function(){
		var backtop=document.body.scrollTop;
		if(backtop>=50){
			topbtn.style.display="block";
		}else{
			topbtn.style.display="none";
		}
	}

	topbtn.onclick=function(){
		// alert("Hello");
		timer=setInterval(function(){
			var backtop=document.body.scrollTop;
			var speedtop=backtop/5;
			document.body.scrollTop=backtop-speedtop;   //everyone click minus 100
			if(backtop==0){
				clearInterval(timer);
			}
		},30);                                 //30ms run one time  
	}
}

