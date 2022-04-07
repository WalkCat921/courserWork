
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="recentlyView" required="true" type="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div  class="container mb-5">
    <h1>Ранее просмотренные:</h1>
    <div class="row">
        <c:forEach var="productViewed" items="${recentlyView}">
            <div class="col-md-3">
                <div class="card text-center">
                    <a href="${pageContext.servletContext.contextPath}/products/${productViewed.code}" style="text-decoration: none">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item"><img src="${productViewed.imageUrl}" alt="product_img" style="height: 200px"></li>
                            <li class="list-group-item">${productViewed.description}</li>
                            <li class="list-group-item">
                                <h2><fmt:formatNumber value="${productViewed.price}" type="currency"
                                                      currencySymbol="${productViewed.currency.symbol}"/></h2>
                            </li>
                        </ul>
                    </a>
                </div>
                </div>
        </c:forEach>
    </div>
</div>


