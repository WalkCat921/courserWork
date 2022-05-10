<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>


<tags:adminDash>
    <jsp:useBean id="products" type="java.util.ArrayList" scope="request"/>

    <div class="container-fluid px-4">
                        <h1 class="mt-4">Панель</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Панель</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                        Посещаемость сайта
                                    </div>
                                    <div class="card-body"><canvas id="myAreaChart" width="100%" height="40"></canvas></div>
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Продажи за месяц
                                    </div>
                                    <div class="card-body"><canvas id="myBarChart" width="100%" height="40"></canvas></div>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Продукты
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>Фото</th>
                                            <th>Название</th>
                                            <th>Код</th>
                                            <th>На складе</th>
                                            <th>Цена</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Фото</th>
                                            <th>Название</th>
                                            <th>Код</th>
                                            <th>На складе</th>
                                            <th>Цена</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    <c:forEach var="product" items="${products}" varStatus="status">
                                        <tr>
                                            <td><img src="${product.imageUrl}" style="max-width: 50px"></td>
                                            <td> ${product.description}</td>
                                            <td>${product.code}</td>
                                            <td>${product.stock}</td>
                                            <td>
                                                <fmt:formatNumber value="${product.price}" type="currency"
                                                                      currencySymbol="${product.currency.symbol}"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
</tags:adminDash>
