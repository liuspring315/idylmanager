<%@page import="java.util.Date"%>
<%@ page import="com.capinfo.examsystem.service.account.ShiroDbRealmService" %>
<%@ page import="com.capinfo.examsystem.service.account.ShiroDbRealmService.ShiroUser" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglibs.jsp" %>
<%ShiroUser user = ShiroDbRealmService.getSessionUser();request.setAttribute("user",user);%>
<script type="text/javascript">
	function tj(o){
		var paramNames = ["yhid"];
        var paramValues = ["${user.id}"];
        sumbitPostForm(o,paramNames,paramValues);
	}
    function logout(){
        if(confirm("是否确认退出？")){
            window.location.href = "${ctx}/roll/logout";
        }
    }
</script>
<div class="cols fl">
    <div class="mod">
        <div class="hd"><h3 class="px14 tc">你好：<shiro:principal/></h3></div>
        <div class="bd mt10">
            <div class="pic tc mt10">
                <p>
                <c:if test="${user.pichttp!=''&&user.pichttp!=null }">
	                <img src="${ctx}/<shiro:principal property="pichttp"/>?d=<%=new Date().getTime()%>" width="120" height="180">
                </c:if>
                <c:if test="${user.pichttp==''||user.pichttp==null }">
               		 <img src="${resourceUrl}/images/noPic.gif" width="120" height="180">
                </c:if>
                
                </p>
            </div>
            <div class="list"> 
                <ul>
                    <c:if test="${user.grywzt==0 }">
                        <li><a href="javascript:tj('/zygwy/mainxz');">阅读须知与承诺</a></li>
                        <li><a href="javascript:alert('请阅读须知与承诺后确认信息');">确认信息</a></li>
                        <li><a href="javascript:alert('请确认信息后选择居住地');">选择居住地</a></li>
                        <li><a href="javascript:alert('请选择居住地后上传照片');">上传照片</a></li>
                        <li><a href="javascript:alert('请上传照片后网上缴费');">网上缴费</a></li>
                    </c:if>
                    <c:if test="${user.grywzt==10 }">
                        <li><a href="javascript:tj('/zygwy/mainxz');">阅读须知与承诺</a></li>
                        <li><a href="javascript:tj('/zygwy/queryKsxx');">确认信息</a></li>
                        <li><a href="javascript:tj('/zygwy/queryKsjzd');">选择居住地</a></li>
                        <li><a href="javascript:alert('请选择居住地后上传照片');">上传照片</a></li>
                        <li><a href="javascript:alert('请上传照片后网上缴费');">网上缴费</a></li>
                    </c:if>
                    <c:if test="${user.grywzt==20 }">
                        <li><a href="javascript:tj('/zygwy/mainxz');">阅读须知与承诺</a></li>
                        <li><a href="javascript:tj('/zygwy/queryKsxx');">确认信息</a></li>
                        <li><a href="javascript:tj('/zygwy/queryKsjzd');">选择居住地</a></li>
                        <li><a href="javascript:tj('/zygwy/pic');">上传照片</a></li>
                        <li><a href="javascript:alert('请上传照片后网上缴费');">网上缴费</a></li>
                    </c:if>
                    <c:if test="${user.grywzt==30 }">
                        <li><a href="javascript:tj('/zygwy/mainxz');">阅读须知与承诺</a></li>
                        <li><a href="javascript:tj('/zygwy/queryKsxx');">确认信息</a></li>
                        <li><a href="javascript:tj('/zygwy/queryKsjzd');">选择居住地</a></li>
                        <li><a href="javascript:tj('/zygwy/pic');">上传照片</a></li>
                        <li><a href="javascript:tj('/zygwy/queryKsjfje');">网上缴费</a></li>
                    </c:if>
                    <c:if test="${user.grywzt==40 }">
                        <li><a href="javascript:tj('/zygwy/mainxz');">阅读须知与承诺</a></li>
                        <li><a href="javascript:tj('/zygwy/queryKsxx');">确认信息</a></li>
                        <li><a href="javascript:tj('/zygwy/queryKsjzd');">选择居住地</a></li>
                        <li><a href="javascript:tj('/zygwy/pic');">上传照片</a></li>
                        <li><a href="javascript:tj('/zygwy/queryKsjfje');">网上缴费</a></li>
                    </c:if>
                    <li><a href="${ctx}/xxts/cjwt2" target="_blank">常见问题</a></li>
                    <li><a href="#" onclick="javascript:logout()">退出系统</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>