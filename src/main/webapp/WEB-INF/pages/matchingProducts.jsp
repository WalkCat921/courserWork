<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="likedProducts" type="java.util.ArrayList" scope="request"/>
<jsp:useBean id="recentlyView" type="java.util.ArrayList" scope="request"/>
<tags:master pageTitle="Product List">
  <div class="row mt-5">
    <h1 class="text-center">
      Сравни и выбери лучшего!
    </h1>
  </div>
  <div class="row mt-5">
    <c:if test="${not empty error}">
      <div class="alert alert-danger" role="alert">
        Ошибка добавления в корзину
      </div>
    </c:if>
  <c:forEach var="product" items="${likedProducts}" varStatus="status">
    <div class="col-lg-4">
      <form method="post" action="/products">
        <div class="card text-center hover-overlay hover-zoom hover-shadow ripple mx-5" style="width: 18rem;">
          <a href="${pageContext.servletContext.contextPath}/products/${product.code}" style="text-decoration: none">
            <div class="card-body">
              <ul class="list-group list-group-flush">
                <li class="list-group-item"><img class="p-2" src="${product.imageUrl}" style="max-width: 200px" class="card-img-top"></li>
                <li class="list-group-item"> ${product.description}</li>
                <li class="list-group-item text-success font-weight-bold"><b>В наличии: ${product.stock}</b></li>
                <li class="list-group-item">
                  <h2><fmt:formatNumber value="${product.price}" type="currency"
                                        currencySymbol="${product.currency.symbol}"/></h2>
                </li>
                <input type="hidden" name="productCode" value="${product.code}">
                <input type="hidden" name="quantity" value="1">
                <input type="hidden" name="query" value="${param.query}">
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
    <div class="row mt-5" >
      <c:forEach var="product" items="${likedProducts}" varStatus="status">
        <div class="col-lg-4">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th class="text-center" scope="row" colspan="2">${product.description}</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <th scope="row">Дата выхода на рынок</th>
              <td>${product.mainСharacteristics.releaseYear}</td>
            </tr>
            <tr>
              <th scope="row">Операционная система</th>
              <td>${product.mainСharacteristics.os}</td>
            </tr>
            <tr>
              <th scope="row">Исходная версия операционной системы</th>
              <td>${product.mainСharacteristics.osVersion}</td>
            </tr>
            <tr>
              <th scope="row">Размер экрана</th>
              <td>${product.mainСharacteristics.screenSize}</td>
            </tr>
            <tr>
              <th scope="row">Встроенная камера</th>
              <td>${product.cameraСharacteristics.builtCamera}</td>
            </tr>
            <tr>
              <th scope="row">Максимальное разрешение видео</th>
              <td>${product.cameraСharacteristics.video}</td>
            </tr>
            <tr>
              <th scope="row">Фронтальная камера</th>
              <td>${product.cameraСharacteristics.frontalCamera}</td>
            </tr>
            <tr>
              <th scope="row">Диафрагма</th>
              <td>${product.cameraСharacteristics.diaphragm}</td>
            </tr>
            <tr>
              <th scope="row">Аудиовыход</th>
              <td>${product.otherСharacteristics.audioType}</td>
            </tr>
            <tr>
              <th scope="row">Емкость аккумулятора</th>
              <td>${product.otherСharacteristics.battery}  мА·ч</td>
            </tr>
            <tr>
              <th scope="row">Материал корпуса</th>
              <td>${product.otherСharacteristics.material}</td>
            </tr>
            <tr>
              <th scope="row">Графический ускоритель</th>
              <td>${product.otherСharacteristics.graphics}</td>
            </tr>
            <tr>
              <th scope="row">Количество ядер</th>
              <td>${product.otherСharacteristics.core}</td>
            </tr>
            <tr>
              <th scope="row">Процессор</th>
              <td>${product.otherСharacteristics.cpu}</td>
            </tr>
            <tr>
              <th scope="row">Формат SIM-карты</th>
              <td>${product.otherСharacteristics.sim}</td>
            </tr>
            <tr>
              <th scope="row">Объем оперативной памяти</th>
              <td>${product.otherСharacteristics.ram} Гб</td>
            </tr>
            <tr>
              <th scope="row">Объем встроенной памяти</th>
              <td>${product.otherСharacteristics.builtMemory} Гб</td>
            </tr>
            </tbody>
          </table>
        </div>
      </c:forEach>
  <div class="row mt-5">
    <tags:recentlyView recentlyView="${recentlyView}"/>
  </div>
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
  <script>
    let likeIcon = document.getElementsByClassName("far fa-heart");
    let counter=0;
    let addedArray = new Array();
    let button = document.getElementById('matchBtn');
    button.addEventListener('click',function (ev){
      if (counter===0){
        alert("Вы не выбрали товар для сравнения!");
        return;
      } else if (counter===1){
        alert("Выберите минимум 2 продукта для сравнения");
      }
    })
    for (let x = 0;x<likeIcon.length;x++){
      let icon = likeIcon[x];
      icon.addEventListener("click",function (fn){
        //TODO fix problem with likes below 3
        if (icon.className=="far fa-heart"){
          if (counter===3){
            alert("Нельзя добавить больше 3 товаров для сравнения. Для начала уберить какой-нибудь товар")
          } else {
            icon.className = "fas fa-heart";
            let urlParam = '/products/liked?likedCode='+icon.getAttribute("id")
            $.ajax({
              url: urlParam,
              method: "post",
              contentType: 'text/html;charset=UTF-8',
            });
            counter++;
          }
        } else {
          icon.className = "far fa-heart";
          let urlParam = '/products/liked?unlikedCode='+icon.getAttribute("id")
          $.ajax({
            url: urlParam,
            method: "get",
            contentType: 'text/html;charset=UTF-8',
          })
          console.log(addedArray)
          counter--;
        }
      })
    }
  </script>
</tags:master>