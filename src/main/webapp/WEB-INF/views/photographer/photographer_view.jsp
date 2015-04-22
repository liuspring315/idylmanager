<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/meta.jsp" %>
</head>
<body class="skin-blue">
<div class="wrapper">
    <%@ include file="/WEB-INF/views/include/menu.jsp" %>
    <!-- Right side column. Contains the navbar and content of the page -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                服务提供者账户管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
                <li class="active">服务提供者账户管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">服务提供者账户列表</h3>
                        </div><!-- /.box-header -->
                        <div class="box box-danger">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" placeholder="用户名或姓名"  name="userName">
                                    </div>
                                    <div class="col-xs-3">
                                    <select class="form-control" name="registerCheckState">
                                        <option value="">未审核</option>
                                        <option value="">已入驻</option>
                                        <option value="">已否决</option>
                                    </select>
                                    </div>
                                    <div class="col-xs-3">
                                        <button type="submit" class="btn btn-primary">搜索</button>
                                    </div>
                                    <div class="col-xs-3">
                                        <button type="submit" class="btn btn-primary">批量否决</button>
                                    </div>
                                </div>
                            </div><!-- /.box-body -->
                        </div><!-- /.box -->
                        <div class="box-body">
                            <table id="photographerTable" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th width="10px"><input type="checkbox"/> </th>
                                    <th>序号</th>
                                    <th>类型</th>
                                    <th>用户名</th>
                                    <th>真实姓名</th>
                                    <th>性别</th>
                                    <th>移动电话</th>
                                    <th>注册时间</th>
                                    <th>启用时间</th>
                                    <th>入住状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${photographerList}" var ="photographer" varStatus="status">
                                <tr>
                                    <td><input type="checkbox"/> </td>
                                    <td>${status.count}</td>
                                    <td>${photographer.userTypeName}</td>
                                    <td>${photographer.userName}</td>
                                    <td>${photographer.familyName}${photographer.lastName}</td>
                                    <td>${photographer.genderName}</td>
                                    <td>${photographer.mobile}</td>
                                    <td>${photographer.addTime}</td>
                                    <td>${photographer.beginTime}</td>
                                    <td>${photographer.registerCheckStateName}</td>
                                    <td>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-info">操作</button>
                                            <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                                                <span class="caret"></span>
                                                <span class="sr-only">Toggle Dropdown</span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#" onclick="javascript:showPhotographerModal(${photographer.id})">查看</a></li>
                                                <li class="divider"></li>
                                                <c:if test="${photographer.registerCheckState==1}">
                                                <li><a href="#" onclick="javascript:showConfirmModalModal('pass',${photographer.userType},${photographer.id},'确认批准入住？')">批准入住</a></li>
                                                <li><a href="#"  onclick="javascript:showConfirmModalModal('over',${photographer.userType},${photographer.id},'确认否决入住？')">否决入住</a></li>
                                                </c:if>
                                                <c:if test="${photographer.registerCheckState==2}">
                                                    <li><a href="#" onclick="javascript:showConfirmModalModal('lock',${photographer.userType},${photographer.id},'确认账户锁定？')">账户锁定</a></li>
                                                    <li class="divider"></li>
                                                    <li><a href="#">保证金变更记录</a></li>
                                                    <li><a href="#">账户锁定记录</a></li>
                                                </c:if>
                                                <c:if test="${photographer.registerCheckState==3}">
                                                    <li><a href="#" onclick="javascript:showConfirmModalModal('rev',${photographer.userType},${photographer.id},'确认撤销否决？')">撤销否决</a></li>
                                                </c:if>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->


                </div><!-- /.col -->
            </div><!-- /.row -->
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <jsp:include flush="true" page="/WEB-INF/views/include/footer.jsp"/>

</div><!-- ./wrapper -->
<!-- DATA TABES SCRIPT -->
<script src="${resourceUrl}/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
<script src="${resourceUrl}/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
<!-- page script -->
<script type="text/javascript">
    function showPhotographerModal(id){
        $("#photographerModalBtn").attr("vid",id);
        $('#photographerModal').modal('show');
    }
    function showConfirmModalModal(action,userType,id,mess){
        $("#confirmModalMess").html(mess);
        $("#confirmModalBtn").attr("vid",id);
        $("#confirmModalBtn").attr("vaction",action);
        $("#confirmModalBtn").attr("vusertype",userType);
        $('#confirmModal').modal('show');
    }
    function confirmModalClick(){
        $("#personId").val($("#confirmModalBtn").attr("vid"));
        $("#userType").val($("#confirmModalBtn").attr("vusertype"));
        $("#showConfirmModalForm").attr("action","${ctx}/photographer/"+$("#confirmModalBtn").attr("vaction"));
        $("#showConfirmModalForm").submit();

    }
    $(document).ready(function() {
        <c:if test="${not empty message}">
        $("#alertModalMess").html("${message}");
        $('#alertModal').modal('show');
        </c:if>
    });
</script>
<form action="" method="post" id="showConfirmModalForm">
    <input type="hidden" id="personId" name="personId"/>
    <input type="hidden" id="userType" name="userType"/>
</form>
<!-- 对话框 -->
<div class="modal fade" id="photographerModal" tabindex="-1" role="dialog" aria-labelledby="photographerModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="photographerModalLabel">查看</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-3">
                        姓名<input type="text" class="form-control" placeholder=".col-xs-3">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        性别<input type="text" class="form-control" placeholder=".col-xs-3">
                    </div>
                    <div class="col-xs-4">
                        账户状态<input type="text" class="form-control" placeholder=".col-xs-4">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        电子邮箱<input type="text" class="form-control" placeholder=".col-xs-3">
                    </div>
                    <div class="col-xs-4">
                        出生日期<input type="text" class="form-control" placeholder=".col-xs-4">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        真实姓名<input type="text" class="form-control" placeholder=".col-xs-3">
                    </div>
                    <div class="col-xs-4">
                        所在地<input type="text" class="form-control" placeholder=".col-xs-4">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        证件类型<input type="text" class="form-control" placeholder=".col-xs-3">
                    </div>
                    <div class="col-xs-4">
                        证件号码<input type="text" class="form-control" placeholder=".col-xs-4">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        移动电话<input type="text" class="form-control" placeholder=".col-xs-3">
                    </div>
                    <div class="col-xs-4">
                        固定电话<input type="text" class="form-control" placeholder=".col-xs-4">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        认证等级<input type="text" class="form-control" placeholder=".col-xs-3">
                    </div>
                    <div class="col-xs-4">
                        当前保证金<input type="text" class="form-control" placeholder=".col-xs-4">
                    </div>
                </div>
                <div class="row">

                    <div class="col-xs-3">
                        注册时间<input type="text" class="form-control" placeholder=".col-xs-3">
                    </div>
                    <div class="col-xs-4">
                        启用日期<input type="text" class="form-control" placeholder=".col-xs-4">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-9">
                        个人简介<input type="text" class="form-control" placeholder=".col-xs-3">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Send message</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="photographerModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">确认</h4>
            </div>
            <div class="modal-body" id="confirmModalMess">
                确认吗？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="confirmModalBtn" onclick="javascript:confirmModalClick()">确认</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-labelledby="alertModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body" id="alertModalMess">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>