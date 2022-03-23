<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="products" type="java.util.ArrayList" scope="request"/>
<jsp:useBean id="recentlyView" type="java.util.ArrayList" scope="request"/>
<tags:master pageTitle="Product List">

    <div class="carousel slide " id="myCarousel" data-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-label="Slide 1" aria-current="true"></button>
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2" class=""></button>
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3" class=""></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://www.21vek.by/img/tmp/b/6203b3a88ad95730x440_nissan_21vek_site.jpg?1644817576" class="d-block w-100">
            </div>
            <div class="carousel-item ">
                <img src="https://24shop.by/upload/iblock/adc/adc4337619b1d73cf15005d315e4886b.jpg" class="d-block w-100">
                <div class="carousel-caption d-lg-block">
                    <h2>Доставка по всей Беларуси</h2>
                    <p>Минск, Брест, Витебск, Могилев, Гомель, Гродно и ещё 106 городов и 5892 деревни.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://i.ytimg.com/vi/FpoRVORqGLo/maxresdefault.jpg" alt="" class="d-block w-100">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                <%--            <span class="bi bi-arrow-left" aria-hidden="true"></span>--%>
            <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
                <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0zm3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
            </svg>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
            <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                <path d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"/>
            </svg>
            <span class="visually-hidden">Next</span>
        </button>
    </div>




<div class="container">
    <form class="row g-1 mt-4">
        <div class="col-8 col-lg-11">
<%--            <label for="inputQuery" class="visually-hidden">Query</label>--%>
            <input id="inputQuery" class="form-control" placeholder = "Что вы хотите найти?" name="query" value="${param.query}">
        </div>
        <div class="col-4 col-lg-1">
            <button class="btn btn-success">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                </svg>
            </button>
        </div>
    </form>
    <div class="row">
        <a class="text-center" href="/search">Поиск с фильтрами</a>
    </div>
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            Ошибка добавления в корзину
        </div>
    </c:if>
    <c:if test="${not empty param.message}">
        <div class="alert alert-success mt-5" role="alert">
            <p class="error">${param.message}</p>
        </div>
    </c:if>
    <div class="row mt-5">
            <c:forEach var="product" items="${products}" varStatus="status">
                <div class="col-7 col-lg-3">
                    <form method="post" action="${pageContext.servletContext.contextPath}/products">
                        <div class="card text-center hover-overlay hover-zoom hover-shadow ripple" style="width: 18rem;">
                            <a href="${pageContext.servletContext.contextPath}/products/${product.code}" style="text-decoration: none">
                                <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item"><img class="p-2" src="${product.imageUrl}" style="max-width: 200px" class="card-img-top"></li>
                                <li class="list-group-item"> ${product.description}</li>
                                <li class="list-group-item text-success font-weight-bold"><b>В наличии: ${product.stock}</b></li>
                                <input type="hidden" name="productCode" value="${product.code}">
                                <input type="hidden" name="quantity" value="1">
                                <input type="hidden" name="query" value="${param.query}">
                                <li class="list-group-item">
                                    <h2><fmt:formatNumber value="${product.price}" type="currency"
                                                                          currencySymbol="${product.currency.symbol}"/></h2>
                                </li>

                            </ul>
                                </div>
                            </a>
                        <div class="btn-group">
                            <button type="submit" class="btn btn-primary">В корзину</button>
                            <button type="button" onclick="none" data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-primary">Купить</button>
                        </div>
                </div>
                </form>
                </div>
            </c:forEach>
    </div>
</div>

    <br>
    <br>
    <div class="w3-content">

    </div>
    <br>
    <br>
    <br>
    <div>
        <tags:recentlyView recentlyView="${recentlyView}"/>
    </div>
</tags:master>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Покупка в один клик</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="formPhone" action="/" class="was-validated">
                <label for="phoneInput">Введите номер вашего телефона</label>
                <input type="tel" id="phoneInput" placeholder="+375 (xx) xxxxxxx" pattern="^\+375 \((17|29|33|44)\) [0-9]{7}$" required>
                <p>Оператор свяжется с Вами для оформления заказа</p>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
                <button form="formPhone" formaction="/" type="submit" class="btn btn-primary" >Купить</button>
            </div>
        </div>
    </div>
</div>