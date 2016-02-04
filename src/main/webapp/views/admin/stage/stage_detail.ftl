<!-- COMMON HEAD -->
<#include "../include/top.ftl">
<!-- COMMON HEAD -->
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-sm-4">
		<h2>详情</h2>
		<ol class="breadcrumb">
			<li><a href="${rootPath}/admin/stages/latest">所有期数</a></li>
			<li><strong><a href="${rootPath}/admin/stages/detail/${stage.id}">详情</a></strong></li>
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
                                            <a href="${rootPath}/admin/stages/edit/${(stage.id)!}" class="btn btn-white btn-xs pull-right">修改本期</a>
                                            <h2>${stage.good.name}</h2>
                                        </div>
                                        <dl class="dl-horizontal">最新一期状态：
                                            <#import "../macro/judge_stage.ftl" as s/>
                                            <@s.judge stage.status/>
                                            
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
                                            <dd>${(stage.num)!("0")}</dd>
                                        </dl>
                                    </div>
                                    <div class="col-lg-7" id="cluster_info">
                                        <dl class="dl-horizontal">

                                            <dt>商品创建于：</dt> 
                                            <dd>${(stage.createTime)?datetime}</dd>
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
                                            	<#if stage??>
                                                <div class="progress progress-striped active m-b-sm">
                                                    <div style="width:${(stage.purchasedQuantity/stage.quantity)?string.percent};" class="progress-bar"></div>
                                                </div>
                                                <small>当前已完成本期总进度的 <strong>${(stage.purchasedQuantity/stage.quantity)?string.percent}</strong></small>
                                                </#if>
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
                                                        <li class="active"><a href="${rootPath}/admin/stages/detail/${stage.good.id}#tab-1" data-toggle="tab">商品详情</a>
                                                        </li>
                                                        <li class=""><a href="${rootPath}/admin/stages/detail/${stage.good.id}#tab-2" data-toggle="tab">获奖用户</a>
                                                        </li>
                                                        <li class=""><a href="${rootPath}/admin/stages/detail/${stage.good.id}#tab-3" data-toggle="tab">此期订单</a>
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
                                                                    <div class="photos">
                                                                    <#if (stage.good.detailPhotos)??>
                                                                    	<#list stage.good.detailPhotos as photo>
                                                                        <a target="_blank" href="">
                                                                            <img class="feed-photo" src="${photo}">
                                                                        </a>
                                                                        </#list>
                                                                    </#if>
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
                                                                
                                                                <#if stage??>
                                                                    <tr>
																	<td><span class="label label-primary">第 ${stage.num} 期</span></td>
																	<td>${(stage.luckyUser.username)!("匿名")}</td>
																	<td>${(stage.luckyCode)!("无")}</td>
																	<td>${(stage.announceTime)!("未揭晓")}</td>
																	<td><#if stage.ifDelivery??> 未发货
	 																		<#if stage.ifDelivery=1> 已发货
																			</#if> 
																		</#if></td>
																	</tr>	
                                                               	</#if>	

                                                            </tbody>
                                                        </table>

                                                    </div>
                                                    
                                                    <div class="tab-pane" id="tab-3">

                                                        <table class="table table-striped">
                                                            <thead>
                                                                <tr>
                                                                    <th>订单遍号</th>
                                                                    <th>用户名</th>
                                                                    <th>抽奖码</th>
                                                                    <th>下单时间</th>
                                                                    <th>购买数量</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                
                                                                <#if stage.orders??>
                                                                	<#list stage.orders as order>
                                                                    <tr>
																	<td><span class="label label-primary">第 ${(order.id)!("#")} 期</span></td>
																	<td><a>${(order.userDetail.user.username)!("无")}</a></td>
																	<td><#list order.codes as code>
																		${(code.code)!("#")},
																		</#list>
																	</td>
																	<td>${(order.time)!("#")}</td>
																	<td>${(order.purchasedQuantity)!("0")}</td>
																	</tr>
																	</#list>	
                                                               	</#if>	

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
                        <h4>商品主图片、描述</h4>
                        <img id="mainPhoto" src="${(stage.good.mainPhoto)!}" class="img-responsive">
                        <p class="small">
                            <br>${stage.good.description!("描述无")}
                        </p>
                        <div class="m-t-md">
                        <#if createStage>
                            <a href="${rootPath}/admin/goods/stage/create/${stage.good.id}" class="btn btn-xs btn-primary">新增新的一期</a>
                        <#else>
                        	<a onclick="createStageWarn()" class="btn btn-xs btn-primary">该商品最新一期进度未完成，无法开始新一期!!!</a>
                        </#if>
						</div>
                        <br/>
                        <div class="m-t-md">
                        <a href="${rootPath}/admin/goods/detail/${stage.good.id}" class="btn btn-xs btn-primary">查看此商品</a>
                        </div>
                        <div class="m-t-md">
						</div>
            </div>
       </div>
</div>
<#include "../include/footer.ftl"/>

<script>
function createStageWarn(){
	alert("该商品最新一期进度未完成，无法开始新一期!!!");
}
$('li[id$="Li"]').attr('class','');
$('li#stageItemLi').attr('class','active');
</script>