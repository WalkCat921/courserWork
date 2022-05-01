<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="products" type="java.util.ArrayList" scope="request"/>

<tags:master pageTitle="Search">
    <div class="row mt-5">
        <div class="col-md-12">
            <h1>Расширенный поиск</h1>
        </div>
    </div>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger" role="alert">
            Что-то пошло не так!
        </div>
    </c:if>
    <c:if test="${not empty paramValues && empty errors}">
        <div class="alert alert-success" role="alert">
            Поиск выполнен!
            Найдено ${products.size()} продуктов!
        </div>
    </c:if>
    <div class="row mt-5">
        <div class="col-md-12">
    <h1 class="text-center">Фильтры:</h1>
    <form method="get">
        <tags:searchFilter name="productCode" value="${param.productCode}" lable="Код продукта" errors="${errors}"/>
        <tags:searchFilter name="minPrice" value="${param.minPrice}" lable="Мин. цена" errors="${errors}"/>
        <tags:searchFilter name="maxPrice" value="${param.maxPrice}" lable="Макс. цена" errors="${errors}"/>
        <tags:searchFilter name="minStock" value="${param.minStock}" lable="Мин. кол-во" errors="${errors}"/>
        <div class="text-center">
        <button class="btn btn-success">Поиск</button>
        </div>
    </form>
        </div>
    </div>
        <table class="table table-hover">
        <thead>
        <tr>
            <td>Фото</td>
            <td>Название</td>
            <td>Цена</td>
        </tr>
        </thead>
        <c:forEach var="product" items="${products}" varStatus="status">
            <tr>
                <a href="products/${product.code}">
                <td><img src="${product.imageUrl}" alt="phone_img" style="width: 100px"></td>
                <td>${product.description}</td>
                <td>
                    <fmt:formatNumber value="${product.price}" type="currency"
                                      currencySymbol="${product.currency.symbol}"/>
                </td>
                </a>
            </tr>
        </c:forEach>
    </table>
    <script>
        window.setTimeout(function() {
            $(".alert").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 2000);
    </script>
</tags:master>