<!-- COMMON HEAD -->
<#include "../include/top.ftl">
<!-- COMMON HEAD -->
<!-- 内页导航开始 -->


<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>详情</h2>
		<ol class="breadcrumb">
			<li><a href="${rootPath}/admin/stages/latest">所有期数</a></li>
			<li><a href="${rootPath}/admin/stages/detail/${stage.id!}">详情</a></li>
			<li><strong>修改</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 内页导航结束 -->
<!--主内容开始-->
<div class="wrapper wrapper-content animated fadeInUp">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>
						修改本期 <small>必填</small>
					</h5>

				</div>
				<div class="ibox-content">
					<form method="get" class="form-horizontal" action="${rootPath}/admin/stages/update/${stage.id}">
									<div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            <small class="text-navy">状态</small>
                                        </label>

                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label><input type="radio" checked="" value="0" id="optionsRadios1" name="statusRadio">未开始</label>
                                            </div>
                                            <div class="radio">
                                                <label><input type="radio" value="1" id="optionsRadios2" name="statusRadio">开始进行</label>
                                            </div>
                                            <div class="radio">
                                                <label><input type="radio" value="4" id="optionsRadios3" name="statusRadio">结束</label>
                                            </div>
                                            
                                        </div>
                                    </div>
						<div class="hr-line-dashed"></div>
						<div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            <small class="text-navy">是否发货</small>
                                        </label>

                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label><input type="radio"  value="1" id="optionsRadios1" name="deliveryRadio">是</label>
                                            </div>
                                            <div class="radio">
                                                <label><input type="radio" checked="" value="0" id="optionsRadios2" name="deliveryRadio">否</label>
                                            </div>
                                        </div>
                                    </div>
						<div class="hr-line-dashed"></div>

						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<button class="btn btn-primary" type="submit">保存内容</button>
								<button class="btn btn-white" type="submit">取消</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!--COMMON FOOTER-->
<#include "../include/footer.ftl">
<!--COMMON FOOTER-->