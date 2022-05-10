<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="order" required="true" type="com.egor.zhukovsky.phoneshop.model.order.Order" %>
<%@ attribute name="lable" required="true" %>

<tr>
    <td>${lable}</td>
    <td>
        <c:choose>
            <c:when test="${order[name] eq 'CASH'}">
                Наличка
            </c:when>
            <c:when test="${order[name] eq 'CREDIT_CARD'}">
                Карта
            </c:when>
            <c:otherwise>
                ${order[name]}
            </c:otherwise>
        </c:choose>
    </td>
</tr>


