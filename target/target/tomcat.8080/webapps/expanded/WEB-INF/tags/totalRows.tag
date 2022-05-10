<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="order" required="true" type="com.egor.zhukovsky.phoneshop.model.order.Order" %>

<tr>
    <td></td>
    <td></td>
    <td>Промежуточный итог:</td>
    <td class="price"><fmt:formatNumber value="${order.subtotal}" type="currency"
                                        currencySymbol="${order.currency.symbol}"/></td>
</tr>
<tr>
    <td></td>
    <td></td>
    <td>Стоимость доставки:</td>
    <td class="price"><fmt:formatNumber value="${order.deliveryCost}" type="currency"
                                        currencySymbol="${order.currency.symbol}"/></td>
</tr>
<tr>
    <td></td>
    <td></td>
    <td>Итог:</td>
    <td class="price"><fmt:formatNumber value="${order.total}" type="currency"
                                        currencySymbol="${order.currency.symbol}"/></td>
</tr>
