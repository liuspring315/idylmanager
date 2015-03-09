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
                管理员账户管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
                <li class="active">管理员账户管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">管理员账户列表</h3>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th width="10px"><input type="checkbox"/> </th>
                                    <th>序号</th>
                                    <th>用户名</th>
                                    <th>真实姓名</th>
                                    <th>启用时间</th>
                                    <th>会员状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><input type="checkbox"/> </td>
                                    <td>1</td>
                                    <td>mayun</td>
                                    <td>马云</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>正常</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"/> </td>
                                    <td>1</td>
                                    <td>mayun</td>
                                    <td>马云</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>正常</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"/> </td>
                                    <td>1</td>
                                    <td>mayun</td>
                                    <td>马云</td>
                                    <td>2015-02-02 11:11</td>
                                    <td>正常</td>
                                    <td></td>
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
</script>

</body>
</html>