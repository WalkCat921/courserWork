<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>


<tags:adminDash>
                    <div class="container">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Новый продукт</h3></div>
                                    <div class="card-body">
                                        <form method="post">
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputDescription" name="description" type="text" placeholder="Введите название" />
                                                        <label for="inputDescription">Название</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputCode" name="code" type="text" placeholder="Введите код" />
                                                        <label for="inputCode">Код</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputUrl" name="imageUrl" type="url" placeholder="Вставте url изображения" />
                                                <label for="inputUrl">URL изображения</label>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputCount" name="stock" type="text" placeholder="Введите кол-во" />
                                                        <label for="inputCount">Кол-во</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputPrice" name="price" type="text" placeholder="Введите стоимость" />
                                                        <label for="inputPrice">Стоимость</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="accordion mt-5" id="accordionExample">
                                                <div class="accordion-item">
                                                    <h2 class="accordion-header" id="headingOne">
                                                        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
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
                                                                        <input class="form-control" id="inputReleaseYear" value="2015" min="2015" max="2030" name="releaseYear" type="number" placeholder="" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Операционная система</td>
                                                                    <td>
                                                                            <input class="form-control" id="inputOS" name="os" type="text" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Версия ОС</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputOSVersion" name="osVersion" type="text" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Размер экрана</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputScreenSize" name="screenSize" type="text" />
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
                                                                        <input class="form-control" id="inputBuiltCamera" name="builtCamera" type="text" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Максимальное разрешение видео</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputVideo" name="video" type="text" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Фронтальная камера</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputFrontalCamera" name="frontalCamera" type="text" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Диафрагма</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputDiaphragm" name="diaphragm" type="text" />
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
                                                                        <input class="form-control" id="inputAudioType" name="audioType" type="text" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Емкость аккумулятора</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputBattery" name="battery" min="2000" value="2000" max="10000" type="number" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Материал корпуса</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputMaterial" name="material" type="text"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Графический ускоритель</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputGraphics" name="graphics" type="text" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Количество ядер</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputCore" name="core" min="1" value="1" max="16" type="number" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Процессор</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputCPU" name="cpu" type="text" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Формат SIM-карты</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputSIM" name="sim" type="text" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Объем оперативной памяти</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputRAM" name="ram" min="8" value="8" max="512" type="number" />
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Объем встроенной памяти</td>
                                                                    <td>
                                                                        <input class="form-control" id="inputBuiltMemory" name="builtMemory" min="8" value="8" max="512" type="number" />
                                                                    </td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-primary btn-block" href="login.jsp">Добавить</button></div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                    </div>
</tags:adminDash>