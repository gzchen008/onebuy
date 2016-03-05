	1.
	首页 index
	用户相关 member/*
		个人资料 profile
		购物车 cart
	订单相关  order/*
		晒单 lucky/show
	期数相关 stage/*
		最新揭晓 newest
		商品列表 product/list	
		
	2.
	所有微信相关的命名,使用wechat,(chat不需要大写)不使用weixin
	
	3.
	微信资源文件放在resources/wechat_assets

	4.
	所有Controller,都要加Wc前缀,为了避免和后台Controller产生同名的Bean
	
	5.
	一般Get请求,只为了显示页面的,方法中加上page后缀,如profilePage,接收表单进行更新的方法加update作为前缀
	
	6.
	对于展示,和修改页相同的,使用同一个URL,使用GET\POST方法区分是展示还是提交