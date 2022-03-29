<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="order" type="com.egor.zhukovsky.phoneshop.model.order.Order" scope="request"/>
<tags:master pageTitle="Checkout">
    <div class="container text-center mt-5 justify-content-center">
        <div class="row">
            <div class="container ">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/">Главная</a></li>
                    <li class="breadcrumb-item"><a href="/cart">Корзина</a></li>
                    <li class="breadcrumb-item active">Оформление заказа</li>
                </ol>
            </div>
        </div>
    </div>
    <c:if test="${not empty param.message}">
        <p id="product-description-text" class="success">
            ${param.message}
        </p>
    </c:if>
    <c:if test="${not empty errors}">
        <p class="error" id="product-description-text">
           Что-то пошло не так!
        </p>
    </c:if>

    <div class="row">
        <div class="col-md-5">
            <form method="post" action="${pageContext.servletContext.contextPath}/checkout">

                <h1>Ваша информация:</h1>
                <div class="form-outline mb-4">
                    <tags:orderFormRow type="text" name="firstName" order="${order}" lable="Фамилия" errors="${errors}"/>
                </div>
                <div class="form-outline mb-4">
                    <tags:orderFormRow type="text" name="lastName" order="${order}" lable="Имя" errors="${errors}"/>
                </div>
                <div class="form-outline mb-4">
                    <tags:orderFormRow type="tel" name="phone" order="${order}" lable="Телефон" errors="${errors}"/>
                </div>
                <div class="form-outline mb-4">
                    <tags:orderFormRow type="date" name="deliveryDate" order="${order}" lable="Дата доставки" errors="${errors}"/>
                </div>
                <div class="form-outline mb-4">
                    <tags:orderFormRow type="text" name="deliveryAddress" order="${order}" lable="Адрес доставки" errors="${errors}"/>
                </div>
                <div class="form-outline mb-4">
                    <tags:orderFormRow name="paymentMethod" order="${order}" lable="Способ оплаты" errors="${errors}" paymentMethod="${paymentMethod}"/>
                </div>
                <div>
                    <button class="btn btn-success">Подтвердить заказ</button>
                </div>
            </form>
        </div>
        <div class="col-md-7">
            <div class="card">
                <div class="card-body">
                    <div class="card-text">
                <ul class="list-group">
                    <c:forEach var="item" items="${order.itemList}" varStatus="status">
                        <li class="list-group-item">
                        <img src="${item.product.imageUrl}" style="height: 100px" alt="phone_img">
                                <div class="vr"></div>
                            ${item.product.description}
                        <div class="vr mx-3"></div>
                            ${item.quantity}
                        <div class="vr mx-3"></div>
                        <fmt:formatNumber value="${item.product.price * item.quantity}" type="currency"
                                          currencySymbol="${item.product.currency.symbol}"/>
                    </li>
                    </c:forEach>
                    <li class="list-group-item text-end">Промежуточная стоимость: <fmt:formatNumber value="${order.subtotal}" type="currency"
                                                                  currencySymbol="${order.currency.symbol}"/></li>
                    <li class="list-group-item text-end">Стоимость доставки: <fmt:formatNumber value="${order.deliveryCost}" type="currency"
                                                             currencySymbol="${order.currency.symbol}"/></li>
                    <li class="list-group-item text-end">Итоговая стоимость: <fmt:formatNumber value="${order.totalCost}" type="currency"
                                                             currencySymbol="${order.currency.symbol}"/></li>
                </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <form method="post" id="deleteCartItem"></form>
</tags:master>