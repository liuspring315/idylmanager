<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<spring:eval expression="@applicationProps['application.version']" var="applicationVersion"/>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="resourceUrl" value="${ctx}/resources"/>
<spring:eval expression="@applicationProps['runqianReportUrl']" var="runqianReportUrl"/>
<c:set var="runqianReportUrlShowkcks_zcwy" value="${runqianReportUrl}/showkcks_zcwy.jsp"/>
<c:set var="runqianReportUrlShowReport" value="${runqianReportUrl}/showReport0.jsp"/>
<spring:eval expression="@applicationProps['webroot']" var="webroot"/>
<spring:eval expression="@applicationProps['jftype']" var="jftype"/>
<spring:eval expression="@applicationProps['property_ksmc']" var="property_ksmc"/>