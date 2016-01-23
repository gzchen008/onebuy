<!-- COMMON HEAD -->
<#include "../include/top.ftl">
<!-- COMMON HEAD -->
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-sm-4">
		<h2>商品详情</h2>
		<ol class="breadcrumb">
			<li><a href="${rootPath}/admin/goods">商品管理</a></li>
			<li><strong>商品详情</strong></li>
		</ol>
	</div>
</div>
<!-- 内页导航结束 -->

<div class="row">
                <div class="col-lg-9">
                    <div class="wrapper wrapper-content animated fadeInUp">
                        <div class="ibox">
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="m-b-md">
                                            <a href="project_detail.html#" class="btn btn-white btn-xs pull-right">编辑项目</a>
                                            <h2>${good.name}</h2>
                                        </div>
                                        <dl class="dl-horizontal">最新一期状态：
                                            <#import "../macro/judge_stage.ftl" as s/>
                                            <@s.judge latestStage.status />
                                            
                                            <dd><span class="label label-primary"></span>
                                            </dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-5">
                                        <dl class="dl-horizontal">

                                            <dt>项目经理：</dt> 
                                            <dd>Beaut-zihan</dd>
                                            
                                            <dt>当前期数：</dt> 
                                            <dd>${latestStage.num}</dd>
                                        </dl>
                                    </div>
                                    <div class="col-lg-7" id="cluster_info">
                                        <dl class="dl-horizontal">

                                            <dt>商品创建于：</dt> 
                                            <dd>${good.time}</dd>
                                            <dt></dt>
                                            <dd class="project-people">
                                                
                                            </dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <dl class="dl-horizontal">
                                            <dt>最新一期进度</dt>
                                            <dd>
                                                <div class="progress progress-striped active m-b-sm">
                                                    <div style="width:${(latestStage.purchasedQuantity/latestStage.quantity)?string.percent};" class="progress-bar"></div>
                                                </div>
                                                <small>当前已完成本期总进度的 <strong>${(latestStage.purchasedQuantity/latestStage.quantity)?string.percent}</strong></small>
                                            </dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="row m-t-sm">
                                    <div class="col-lg-12">
                                        <div class="panel blank-panel">
                                            <div class="panel-heading">
                                                <div class="panel-options">
                                                    <ul class="nav nav-tabs">
                                                        <li class="active"><a href="${rootPath}/admin/goods/detail/${good.id}#tab-1" data-toggle="tab">商品详情</a>
                                                        </li>
                                                        <li class=""><a href="${rootPath}/admin/goods/detail/${good.id}#tab-2" data-toggle="tab">获奖用户</a>
                                                        </li>
                                                        
                                                    </ul>
                                                </div>
                                            </div>

                                            <div class="panel-body">

                                                <div class="tab-content">
                                                    
                                                    <div class="tab-pane active" id="tab-1">
                                                        <div class="feed-activity-list">
                                                            <div class="feed-element">
                                                                
                                                                <div class="media-body ">
                                                                    <small class="pull-right text-navy">1天前</small>
                                                                    <div class="photos">
                                                                        <a target="_blank" href="">
                                                                            <img alt="image" class="feed-photo" src="${rootPath}/upload/goods/apple.png">
                                                                        </a>
                                                                        <a target="_blank" href="">
                                                                            <img alt="image" class="feed-photo" src="${rootPath}/upload/goods/iphone6s.jpg">
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>


                                                         
                                                        </div>

                                                    </div>
                                                    
                                                    <div class="tab-pane" id="tab-2">

                                                        <table class="table table-striped">
                                                            <thead>
                                                                <tr>
                                                                    <th>所属期数</th>
                                                                    <th>用户名</th>
                                                                    <th>幸运码</th>
                                                                    <th>获奖时间</th>
                                                                    <th>是否发货</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                
                                                                    <#import "../macro/luckey_user.ftl" as users/>
                                                                    <@users.showUser stages/>
                                                               

                                                            </tbody>
                                                        </table>

                                                    </div>
                                                </div>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="wrapper wrapper-content project-manager">
                        <h4>商品描述</h4>
                        <img src="${rootPath}/upload/goods/apple.png" class="img-responsive">
                        <p class="small">
                            <br>${good.description!("描述无")}
                        </p>
                        
                        <div class="m-t-md">
                            <a href="project_detail.html#" class="btn btn-xs btn-primary">新增新的一期</a>
                        </div>
                        <br/>
                        <a href="${rootPath}/admin/goods/uploadPage/${good.id}" class="btn btn-primary">上传商品详情图片</a>
                        
            </div>
       </div>
</div>
<#include "../include/footer.ftl"/>
