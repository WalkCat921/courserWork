<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="lable" required="true" %>
<%@ attribute name="value" required="true" %>
<%@ attribute name="errors" required="true" type="java.util.Map" %>

<div class="form-outline mb-4">
            <c:set var="error" value="${errors[name]}"/>
            <input class="form-control" type="text" name="${name}"
                   value="${value}"/>
     <label  class="form-label">${lable}</label>
    <c:if test="${not empty error}">
                <div class="text-danger">
                        ${error}
                </div>
            </c:if>
</div>