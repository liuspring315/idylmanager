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
                主面板
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
                <li class="active">主面板</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">


        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <jsp:include flush="true" page="/WEB-INF/views/include/footer.jsp"/>

</div><!-- ./wrapper -->


</body>
</html>