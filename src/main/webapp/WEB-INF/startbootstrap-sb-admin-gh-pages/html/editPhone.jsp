<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="product" type="com.egor.zhukovsky.phoneshop.model.product.Product" scope="request"/>




<tags:adminDash>
                    <div class="container">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Новый продукт</h3></div>
                                    <div class="card-body">
                                        <form method="post" autocomplete="off">
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input type="hidden" value="${product.id}" name="id"/>
                                                        <tags:editPhoneFormRow  value="${product.description}" id="inputDescription" type="text" name="description" lable="Название" errors="${errors}" placeholder="Введите название"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <tags:editPhoneFormRow  value="${product.code}" id="inputCode" type="text" name="code" lable="Код" errors="${errors}" placeholder="Введите код"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <tags:editPhoneFormRow  id="inputUrl" value="${product.imageUrl}" type="url" name="imageUrl" lable="URL изображения" errors="${errors}" placeholder="Вставте url изображения"/>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <tags:editPhoneFormRow  value="${product.stock}" id="inputCount" type="number" name="stock" lable="Кол-во"  errors="${errors}" placeholder="Введите кол-во"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <tags:editPhoneFormRow  id="inputPrice" value="${product.price.intValue()}" type="text" name="price" lable="Стоимость" errors="${errors}" placeholder="Введите стоимость"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="accordion mt-5" id="accordionExample">
                                                <div class="accordion-item">
                                                    <h2 class="accordion-header" id="headingOne">
                                                        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collaps   eOne" aria-expanded="true" aria-controls="collapseOne">
                                                            Основные характеристики
                                                        </button>
                                                    </h2>
                                                    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                                        <div class="accordion-body">
                                                            <table class="table table-bordered">
                                                                <tbody>
                                                                <tr>
                                                                    <td>Дата выхода на рынок</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  id="inputReleaseYear" type="number" value="${product.mainСharacteristics.releaseYear}" min="2015" max="2030" name="releaseYear" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Операционная система</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.mainСharacteristics.os}" id="inputOS" name="os" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Версия ОС</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.mainСharacteristics.osVersion}" id="inputOSVersion" name="osVersion" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Размер экрана</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.mainСharacteristics.screenSize}" id="inputScreenSize" name="screenSize" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="accordion-item">
                                                    <h2 class="accordion-header" id="headingTwo">
                                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                                            Камера
                                                        </button>
                                                    </h2>
                                                    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                                                        <div class="accordion-body">
                                                            <table class="table table-bordered">
                                                                <tbody>
                                                                <tr>
                                                                    <td>Встроенная камера</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.cameraСharacteristics.frontalCamera}" id="inputBuiltCamera" name="builtCamera" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Максимальное разрешение видео</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.cameraСharacteristics.video}" id="inputVideo" name="video" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Фронтальная камера</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.cameraСharacteristics.frontalCamera}" id="inputFrontalCamera" name="frontalCamera" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Диафрагма</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.cameraСharacteristics.diaphragm}" id="inputDiaphragm" name="diaphragm" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="accordion-item">
                                                    <h2 class="accordion-header" id="headingThree">
                                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                                            Дополнительно
                                                        </button>
                                                    </h2>
                                                    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                                                        <div class="accordion-body">
                                                            <table class="table table-bordered">
                                                                <tbody>
                                                                <tr>
                                                                    <td>Аудиовыход</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.otherСharacteristics.audioType}" id="inputAudioType" name="audioType" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Емкость аккумулятора</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  id="inputBattery" name="battery" min="2000" value="${product.otherСharacteristics.battery}" max="10000" type="number" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Материал корпуса</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.otherСharacteristics.material}" id="inputMaterial" name="material" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Графический ускоритель</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.otherСharacteristics.graphics}" id="inputGraphics" name="graphics" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Количество ядер</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  id="inputCore" name="core" min="1" value="${product.otherСharacteristics.core}" max="16" type="number" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Процессор</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.otherСharacteristics.cpu}" id="inputCPU" name="cpu" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Формат SIM-карты</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  value="${product.otherСharacteristics.sim}" id="inputSIM" name="sim" type="text" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Объем оперативной памяти</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  id="inputRAM" name="ram" min="8" value="${product.otherСharacteristics.ram}" max="512" type="number" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Объем встроенной памяти</td>
                                                                    <td>
                                                                        <tags:editPhoneFormRow  id="inputBuiltMemory" name="builtMemory" min="8" value="${product.otherСharacteristics.builtMemory}" max="512" type="number" errors="${errors}"/>
                                                                    </td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-primary btn-block">Изменить</button></div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                    </div>
</tags:adminDash>