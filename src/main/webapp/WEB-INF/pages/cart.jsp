<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="cart" type="com.egor.zhukovsky.phoneshop.model.cart.Cart" scope="request"/>
<tags:master pageTitle="Cart">
    <div class="container text-center mt-5 justify-content-center">
        <div class="row">
            <div class="container ">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/">Главная</a></li>
                    <li class="breadcrumb-item active">Корзина</li>
                </ol>
            </div>
        </div>
    </div>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger" role="alert">
            <strong>Ошибка обновления корзины!</strong>
        </div>
    </c:if>
    <c:if test="${not empty param.message && param.message == 'success'}">
        <div class="alert alert-success" role="alert">
            <strong>Корзина обновлена!</strong>
        </div>
    </c:if>
    <c:if test="${empty cart.itemList}">
        <div class="container text-center">
            <h4>
                Корзина пуста!<a href="/">Добавить продукты?</a>
            </h4>
        </div>
    </c:if>

    <c:if test="${not empty cart.itemList}">
        <form method="post" action="${pageContext.servletContext.contextPath}/cart">
            <table class="table table">
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
                        <td><img src="${item.product.imageUrl}" alt="phone_img" style="height: 200px"></td>
                        <td>${item.product.description}</td>
                        <td>
                            <c:set var="error" value="${errors[item.product.code]}"/>
                            <input class="quantity" type="text" name="quantity" pattern="\d+"
                                   value="${not empty error ? quantity[item.product.code] : item.quantity}">
                            <c:if test="${not empty error}">
                                <div class="text-danger">

                                        ${errors[item.product.code]}
                                </div>
                            </c:if>
                            <c:if test="${empty error}">
                                <div class="text-success">Обновлено успешно!</div>
                            </c:if>
                            <input type="hidden" name="productCode" value="${item.product.code}">
                        </td>
                        <td>
                            <fmt:formatNumber value="${item.product.price * item.quantity}" type="currency"
                                              currencySymbol="${item.product.currency.symbol}"/>
                        <td>
                            <button class="btn btn-danger" form="deleteCartItem"
                                    formaction="${pageContext.servletContext.contextPath}/cart/deleteCartItem/${item.product.code}">
                                Удалить
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td>Итоговое кол-во:</td>
                    <td>${cart.totalQuantity}</td>
                    <td>Итоговая стоимость (без доставки):</td>
                    <td><fmt:formatNumber value="${cart.totalCost}" type="currency"
                                          currencySymbol="${cart.currency.symbol}"/></td>
                </tr>
            </table>
            <div class="d-flex justify-content-end btn-group" role="group">
                <button class="btn btn-primary">Изменить</button>
                <button form="overviewBtnForm" class="btn btn-success">Оформить заказ</button>
            </div>
        </form>
        <div>
            <form id="overviewBtnForm" action="${pageContext.servletContext.contextPath}/checkout">
            </form>
        </div>
        <form method="post" id="deleteCartItem"></form>
    </c:if>
    <script>
        window.setTimeout(function() {
            $(".alert").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 2000);
    </script>
</tags:master>