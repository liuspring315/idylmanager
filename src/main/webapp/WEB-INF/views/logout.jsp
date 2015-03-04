<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/WEB-INF/views/include/meta.jsp" %>
</head>
<body class="logo-f">
<div id="mybg">
    <div id="container">
        <div class="main">
            <div id="slides">
                您已经成功退出系统，谢谢使用！

                出于安全考虑，请关闭您的浏览器。
                <script type="text/javascript" >
                    window.open('','_self');
                    window.close();
                </script>
            </div>
            <div class="clearit"></div>
        </div>
    </div>
</div>
</div>
</body>
</html>