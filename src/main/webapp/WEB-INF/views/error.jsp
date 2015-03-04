<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/WEB-INF/views/include/meta.jsp" %>
</head>

<body onload="reLoad();">
<div id="doc">
    <jsp:include flush="true" page="/WEB-INF/views/include/header.jsp"/>
    <div id="mainbody">
        <div class="grid mt10 fix">
            <jsp:include flush="true" page="/WEB-INF/views/include/menu.jsp"/>
            <div class="colm fr">
                <div class="news fix">
                    <div class="welcome tc">
                        <DIV id="error" style="text-align: left">
                            <P>
                            <STRONG>提示信息:</STRONG>您无权限访问该页面</P>
                            </DIV>
                    </div>
                </div>
            </div><!-- colm end-->
        </div>
    </div><!-- mainbody end-->
    <jsp:include flush="true" page="/WEB-INF/views/include/footer.jsp"/>
</div>
</body>
</html>