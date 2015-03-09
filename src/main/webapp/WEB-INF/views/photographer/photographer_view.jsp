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
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
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
                                <tr>
                                    <td><input type="checkbox"/> </td>
                                    <td>1</td>
                                    <td>摄影师</td>
                                    <td>mayun</td>
                                    <td>马云</td>
                                    <td>男</td>
                                    <td>13333334444</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>正常</td>
                                    <td><button type="button" class="btn btn-primary"  onclick="javascript:showPhotographerModal(1)">查看</button></td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"/> </td>
                                    <td>1</td>
                                    <td>摄影师</td>
                                    <td>mayun</td>
                                    <td>马云</td>
                                    <td>男</td>
                                    <td>13333334444</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>正常</td>
                                    <td>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-info">操作</button>
                                            <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                                                <span class="caret"></span>
                                                <span class="sr-only">Toggle Dropdown</span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">查看</a></li>
                                                <li class="divider"></li>
                                                <li><a href="#">账户锁定</a></li>
                                                <li class="divider"></li>
                                                <li><a href="#">保证金变更记录</a></li>
                                                <li><a href="#">账户锁定记录</a></li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"/> </td>
                                    <td>1</td>
                                    <td>摄影师</td>
                                    <td>mayun</td>
                                    <td>马云</td>
                                    <td>男</td>
                                    <td>13333334444</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>正常</td>
                                    <td>
                                       <div class="btn-group">
                                            <button type="button" class="btn btn-info">操作</button>
                                            <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                                                <span class="caret"></span>
                                                <span class="sr-only">Toggle Dropdown</span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">查看</a></li>
                                                <li class="divider"></li>
                                                <li><a href="#">批准入住</a></li>
                                                <li><a href="#">否决入住</a></li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"/> </td>
                                    <td>1</td>
                                    <td>摄影师</td>
                                    <td>mayun</td>
                                    <td>马云</td>
                                    <td>男</td>
                                    <td>13333334444</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>正常</td>
                                    <td>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-info">操作</button>
                                            <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                                                <span class="caret"></span>
                                                <span class="sr-only">Toggle Dropdown</span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">查看</a></li>
                                                <li class="divider"></li>
                                                <li><a href="#">撤销否决</a></li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
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
    $(function () {
        $('#example2').dataTable({
            "bPaginate": true,
            "bLengthChange": false,
            "bFilter": false,
            "bSort": true,
            "bInfo": true,
            "bAutoWidth": false
        });

    });
    function showPhotographerModal(id){
        $('#photographerModal').modal('show');
    }
</script>
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
</body>
</html>