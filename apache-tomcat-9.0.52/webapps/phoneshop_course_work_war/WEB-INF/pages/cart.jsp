<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="cart" type="com.egor.zhukovsky.phoneshop.model.cart.Cart" scope="request"/>
<tags:master pageTitle="Cart">
    <p id="product-description-text">
        Ваша корзина
    </p>
    <c:if test="${not empty param.message}">
        <p id="product-description-text" class="success">
                ${param.message}
        </p>
    </c:if>
    <c:if test="${not empty errors}">
        <p class="error" id="product-description-text">
            Ошибка обновления корзины!
        </p>
    </c:if>
    <c:if test="${empty cart.itemList}">
        <p id="product-description-text">
            Корзина пуста!<a href="/">Добавить продукты?</a>
        </p>
    </c:if>
<%--    <a href="">Minsk Kosmonavtov</a>--%>
    <c:if test="${not empty cart.itemList}">
        <form method="post" action="${pageContext.servletContext.contextPath}/cart">
            <table id="details">
                <thead>
                <tr>
                    <td>Фото</td>
                    <td>Название</td>
                    <td>Кол-во</td>
                    <td>Цена</td>
                    <td></td>
                </tr>
                </thead>
                <c:forEach var="item" items="${cart.itemList}" varStatus="status">
                    <tr>
                        <td><img src="${item.product.imageUrl}" alt="phone_img"></td>
                        <td>${item.product.description}</td>
                        <td>
                            <c:set var="error" value="${errors[item.product.code]}"/>
                            <input class="quantity" type="text" name="quantity" pattern="\d+"
                                   value="${not empty error ? quantity[item.product.code] : item.quantity}">
                            <c:if test="${not empty error}">
                                <div class="error">
                                        ${errors[item.product.code]}
                                </div>
                            </c:if>
                            <c:if test="${empty error}">
                                <div class="success">Обновлено успешно!</div>
                            </c:if>
                            <input type="hidden" name="productCode" value="${item.product.code}">
                        </td>
                        <td><a href='#'
                               onclick='javascript:window.open("${pageContext.servletContext.contextPath}/price-history/${item.product.code}",
              "_blank", "scrollbars=0,resizable=0,height=600,width=450,top=250,left=780");' title='Pop Up'>
                            <fmt:formatNumber value="${item.product.price * item.quantity}" type="currency"
                                              currencySymbol="${item.product.currency.symbol}"/>
                        </a>
                        <td>
                            <button form="deleteCartItem"
                                    formaction="${pageContext.servletContext.contextPath}/cart/deleteCartItem/${item.product.code}">
                                Удалить
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>Total quantity:</td>
                    <td>${cart.totalQuantity}</td>
                    <td>Total cost:</td>
                    <td><fmt:formatNumber value="${cart.totalCost}" type="currency"
                                          currencySymbol="${cart.currency.symbol}"/></td>
                </tr>
            </table>
            <div class="button-update">
                <button>Изменить</button>
            </div>
        </form>
        <div class="button-update">
            <form action="${pageContext.servletContext.contextPath}/checkout">
                <button>Проверить заказ</button>
            </form>
        </div>
        <form method="post" id="deleteCartItem"></form>
    </c:if>
</tags:master>