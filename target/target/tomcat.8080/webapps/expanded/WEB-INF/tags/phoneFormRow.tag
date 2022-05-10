<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="lable" required="false" %>
<%@ attribute name="type" required="false" %>
<%@ attribute name="value" required="false" %>
<%@ attribute name="min" required="false" %>
<%@ attribute name="max" required="false" %>
<%@ attribute name="id" required="false" %>
<%@ attribute name="placeholder" required="false" %>
<%@ attribute name="errors" required="true" type="java.util.Map" %>
<%@ attribute name="productAdd" required="true" type="com.egor.zhukovsky.phoneshop.model.product.Product" %>



<c:if test="${not empty lable}">
<c:if test="${type.equals('text') || type.equals('url')}">
    <c:set var="error" value="${errors[name]}"/>
    <div class="form-floating mb-3 mb-md-0">
        <input class="form-control" id="${id}" name="${name}" type="${type}" value="${empty error ? productAdd[name] : param[name]}" placeholder="${placeholder}" />
        <label for="${id}">${lable}</label>
    </div>
    <c:if test="${not empty error}">
        <div class="text-danger">${error}</div>
    </c:if>
</c:if>
</c:if>


<c:if   test="${empty lable}">
<c:if test="${type.equals('text') || type.equals('url')}">
    <c:set var="error" value="${errors[name]}"/>
    <input class="form-control" id="${id}" name="${name}" type="${type}" value="${empty error ? productAdd[name] : param[name]}" placeholder="${placeholder}" />
    <c:if test="${not empty error}">
        <div class="text-danger">${error}</div>
    </c:if>
</c:if>
</c:if>

<c:if test="${not empty lable}">
    <c:if test="${type.equals('number')}">
        <div class="form-floating mb-3 mb-md-0">
            <c:set var="error" value="${errors[name]}"/>
            <input class="form-control" id="${id}" min="${min}" value="${empty error ? productAdd[name] : param[name]}" max="${max}" name="${name}" type="${type}" placeholder="${placeholder}" />
            <label for="${id}">${lable}</label>
        </div>
        <c:if test="${not empty error}">
            <div class="text-danger">${error}</div>
        </c:if>
    </c:if>
</c:if>

<c:if test="${empty lable}">
    <c:if test="${type.equals('number')}">
        <c:set var="error" value="${errors[name]}"/>
        <input class="form-control" id="${id}" min="${min}" value="${empty error ? productAdd[name] :  param[name]}" max="${max}" name="${name}" type="${type}" placeholder="${placeholder}" />
        <c:if test="${not empty error}">
            <div class="text-danger">${error}</div>
        </c:if>
    </c:if>
</c:if>