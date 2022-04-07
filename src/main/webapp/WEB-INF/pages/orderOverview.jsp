<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="order" type="com.egor.zhukovsky.phoneshop.model.order.Order" scope="request"/>
<tags:master pageTitle="Order overview">
    <p id="product-description-text">
        Обзор заказа
    </p>
    <table class="table">
        <thead>
        <tr>
            <td>Фото</td>
            <td>Название</td>
            <td>Кол-во</td>
            <td>Цена</td>
        </tr>
        </thead>
<%--        <c:forEach var="item" items="${order.itemList}" varStatus="status">--%>
<%--            <tr>--%>
<%--                <td><img src="${item.product.imageUrl}" alt="phone_img"></td>--%>
<%--                <td>${item.product.description}</td>--%>
<%--                <td>--%>
<%--                    <fmt:formatNumber value="${item.quantity}" var="quantity"/>--%>
<%--                        ${item.quantity}--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <fmt:formatNumber value="${item.product.price * item.quantity}" type="currency"--%>
<%--                                      currencySymbol="${item.product.currency.symbol}"/>--%>
<%--                </a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
        <tags:totalRows order="${order}"/>
    </table>
    <h1 id="product-description-text">Ваша информация:</h1>
    <table class="table table-bordered">
        <tags:orderOverviewRow name="firstName" order="${order}" lable="Фамилия"/>
        <tags:orderOverviewRow name="lastName" order="${order}" lable="Имя"/>
        <tags:orderOverviewRow name="phone" order="${order}" lable="Телефон"/>
        <tags:orderOverviewRow name="deliveryDate" order="${order}" lable="Дата доставки"/>
        <tags:orderOverviewRow name="deliveryAddress" order="${order}" lable="Адрес доставки"/>
        <tags:orderOverviewRow name="paymentMethod" order="${order}" lable="Способ оплаты"/>
    </table>
    <a href="/"><button>На главную</button></a>
</tags:master>