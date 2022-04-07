<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:adminDash>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Таблица</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="adminMenu.jsp">Панель</a></li>
                            <li class="breadcrumb-item active">Продукты</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                Для обновления таблицы обновите страницу.
                                <a href="/admin/menu/tables">Обновить</a>
                                                            </div>
                        </div>
                        <div class="mt-4 mb-4">
                            <a href="/admin/menu/tables/add" class="btn btn-secondary btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-arrow-right"></i>
                                        </span>
                                <span class="text">Добавить новый продукт</span>
                            </a>
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