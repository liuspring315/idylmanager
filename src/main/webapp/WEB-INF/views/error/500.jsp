<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/WEB-INF/views/include/meta.jsp" %>
    <script type="text/javascript">
        function reLoad(){
            setInterval("newURL()",1000);
        }
        function newURL(){
            var seconds = parseInt(document.getElementById("seconds").innerText);
            seconds--;
            if(seconds==0){
                window.history.back();
            }
            document.getElementById("seconds").innerText = seconds;
        }
    </script>
</head>

<body>
<div id="doc">
    <jsp:include flush="true" page="/WEB-INF/views/include/header.jsp"/>
    <div id="mainbody">
        <div class="grid mt10 fix">
            <jsp:include flush="true" page="/WEB-INF/views/include/menu.jsp"/>
            <div class="colm fr">
                <div class="news fix">
                    <div class="welcome tc">
                        <DIV id="error" style="text-align: left">
                            <STRONG>提示信息:</STRONG>您无权限访问该页面</P>
<!--                             <P>请<A href="javascript:window.history.back ()">&nbsp;返&nbsp;&nbsp;回&nbsp;</A>上一页面 -->
<!--                                 或等<label id="seconds">5</label>秒后页面自动跳转 -->
<!--                             </P> -->
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