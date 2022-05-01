package com.egor.zhukovsky.phoneshop.web.admin;

import com.egor.zhukovsky.phoneshop.dao.ProductDao;
import com.egor.zhukovsky.phoneshop.dao.impl.ArrayListProductDao;
import com.egor.zhukovsky.phoneshop.model.product.CameraСharacteristics;
import com.egor.zhukovsky.phoneshop.model.product.MainСharacteristics;
import com.egor.zhukovsky.phoneshop.model.product.OtherСharacteristics;
import com.egor.zhukovsky.phoneshop.model.product.Product;
import com.egor.zhukovsky.phoneshop.validator.ProductFormValidator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class EditProductPageServlet extends HttpServlet {

    private static final String ID_PARAM = "id";
    private static final String DESCRIPTION_PARAM = "description";
    private static final String CODE_PARAM = "code";
    private static final String IMAGE_URL_PARAM = "imageUrl";
    private static final String STOCK_PARAM = "stock";
    private static final String PRICE_PARAM = "price";
    private static final String RELEASE_YEAR_PARAM = "releaseYear";
    private static final String OS_PARAM = "os";
    private static final String OS_VERSION_PARAM = "osVersion";
    private static final String SCREEN_SIZE_PARAM = "screenSize";
    private static final String BUILT_CAMERA_PARAM = "builtCamera";
    private static final String VIDEO_PARAM = "video";
    private static final String FRONTAL_CAMERA_PARAM = "frontalCamera";
    private static final String DIAPHRAGM_PARAM = "diaphragm";
    private static final String AUDIO_TYPE_PARAM = "audioType";
    private static final String BATTERY_PARAM = "battery";
    private static final String MATERIAL_PARAM = "material";
    private static final String GRAPHICS_PARAM = "graphics";
    private static final String CORE_PARAM = "core";
    private static final String CPU_PARAM = "cpu";
    private static final String SIM_PARAM = "sim";
    private static final String RAM_PARAM = "ram";
    private static final String BUILT_MEMORY_PARAM = "builtMemory";
    private static final String ERROR_SESSION_ATTRIBUTE = "ErrorSessionAddProductPage";
    private static final String CACHE_HEADER = "Cache-Control";
    private static final String CACHE_HEADER_PARAMETERS = "no-cache, no-store, must-revalidate";
    //    private static final String PRODUCT_TABLE_ATTRIBUTE = "products";
    private static final String ADMIN_MENU_JSP_PATH = "/WEB-INF/startbootstrap-sb-admin-gh-pages/html/formForPhone.jsp";
    private ProductDao productDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDao = ArrayListProductDao.getInstance();
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAttributeFromSession(request, ERROR_SESSION_ATTRIBUTE, "errors");
        String productCode = request.getParameter("productCode");
            Product product = productDao.getByCode(productCode);
        if (product == null){
            response.sendRedirect("/admin/menu/tables");
        } else {
            request.setAttribute("product",product);
            request.getRequestDispatcher("/WEB-INF/startbootstrap-sb-admin-gh-pages/html/editPhone.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> errors = new HashMap<>();
        String id = request.getParameter(ID_PARAM);
        String releaseYear = request.getParameter(RELEASE_YEAR_PARAM);
        String os = request.getParameter(OS_PARAM);
        String osVersion = request.getParameter(OS_VERSION_PARAM);
        String screenSize = request.getParameter(SCREEN_SIZE_PARAM);
        String buildCamera = request.getParameter(BUILT_CAMERA_PARAM);
        String video = request.getParameter(VIDEO_PARAM);
        String frontalCamera = request.getParameter(FRONTAL_CAMERA_PARAM);
        String diaphragm = request.getParameter(DIAPHRAGM_PARAM);
        String audioType = request.getParameter(AUDIO_TYPE_PARAM);
        String battery = request.getParameter(BATTERY_PARAM);
        String material = request.getParameter(MATERIAL_PARAM);
        String graphics = request.getParameter(GRAPHICS_PARAM);
        String core = request.getParameter(CORE_PARAM);
        String cpu = request.getParameter(CPU_PARAM);
        String sim = request.getParameter(SIM_PARAM);
        String ram = request.getParameter(RAM_PARAM);
        String builtMemory = request.getParameter(BUILT_MEMORY_PARAM);
        String code = request.getParameter(CODE_PARAM);
        String description = request.getParameter(DESCRIPTION_PARAM);
        String price = request.getParameter(PRICE_PARAM);
        Currency currency = Currency.getInstance("USD");
        String stock = request.getParameter(STOCK_PARAM);
        String imageUrl = request.getParameter(IMAGE_URL_PARAM);
        Product product = new Product();
        MainСharacteristics mainСharacteristics = new MainСharacteristics();
        CameraСharacteristics cameraСharacteristics = new CameraСharacteristics();
        OtherСharacteristics otherСharacteristics = new OtherСharacteristics();
        ProductFormValidator.validateProductForm(releaseYear,RELEASE_YEAR_PARAM,errors,mainСharacteristics::setReleaseYear);
        ProductFormValidator.validateProductForm(os,OS_PARAM,errors,mainСharacteristics::setOs);
        ProductFormValidator.validateProductForm(osVersion,OS_VERSION_PARAM,errors,mainСharacteristics::setOsVersion);
        ProductFormValidator.validateProductForm(screenSize,SCREEN_SIZE_PARAM,errors,mainСharacteristics::setScreenSize);
        ProductFormValidator.validateProductForm(buildCamera,BUILT_CAMERA_PARAM,errors,cameraСharacteristics::setBuiltCamera);
        ProductFormValidator.validateProductForm(video,VIDEO_PARAM,errors,cameraСharacteristics::setVideo);
        ProductFormValidator.validateProductForm(frontalCamera,FRONTAL_CAMERA_PARAM,errors,cameraСharacteristics::setFrontalCamera);
        ProductFormValidator.validateProductForm(diaphragm,DIAPHRAGM_PARAM,errors,cameraСharacteristics::setDiaphragm);
        ProductFormValidator.validateProductForm(audioType,AUDIO_TYPE_PARAM,errors,otherСharacteristics::setAudioType);
        ProductFormValidator.validateProductForm(battery,BATTERY_PARAM,errors,otherСharacteristics::setBattery);
        ProductFormValidator.validateProductForm(material,MATERIAL_PARAM,errors,otherСharacteristics::setMaterial);
        ProductFormValidator.validateProductForm(graphics,GRAPHICS_PARAM,errors,otherСharacteristics::setGraphics);
        ProductFormValidator.validateProductForm(core,CORE_PARAM,errors,otherСharacteristics::setCore);
        ProductFormValidator.validateProductForm(cpu,CPU_PARAM,errors,otherСharacteristics::setCpu);
        ProductFormValidator.validateProductForm(sim,SIM_PARAM,errors,otherСharacteristics::setSim);
        ProductFormValidator.validateProductForm(ram,RAM_PARAM,errors,otherСharacteristics::setRam);
        ProductFormValidator.validateProductForm(builtMemory,BUILT_MEMORY_PARAM,errors,otherСharacteristics::setBuiltMemory);
        ProductFormValidator.validateProductForm(id,ID_PARAM,errors,product::setId);
        ProductFormValidator.validateProductForm(code,CODE_PARAM,errors,product::setCode);
        ProductFormValidator.validateProductForm(description,DESCRIPTION_PARAM,errors,product::setDescription);
        ProductFormValidator.validateProductForm(price,PRICE_PARAM,errors,product::setPrice);
        ProductFormValidator.validateProductForm(stock,STOCK_PARAM,errors,product::setStock);
        ProductFormValidator.validateProductForm(imageUrl,IMAGE_URL_PARAM,errors,product::setImageUrl);
        product.setMainСharacteristics(mainСharacteristics);
        product.setCameraСharacteristics(cameraСharacteristics);
        product.setOtherСharacteristics(otherСharacteristics);
        if (errors.isEmpty()){
            productDao.update(product);
//            request.getRequestDispatcher("/WEB-INF/startbootstrap-sb-admin-gh-pages/html/tables.jsp").forward(request,response);
            response.sendRedirect("/admin/menu/tables");
        } else {
            setValueInSession(request, ERROR_SESSION_ATTRIBUTE, errors);
            response.sendRedirect("/admin/menu/tables/edit?update=error");
        }
    }

    private void setValueInSession(HttpServletRequest request, String sessionAttribute, Object object) {
        request.getSession().setAttribute(sessionAttribute, object);
    }

    private void setAttributeFromSession(HttpServletRequest request, String sessionAttribute,
                                         String attribute) {
        if (request.getSession().getAttribute(sessionAttribute) != null) {
            request.setAttribute(attribute, request.getSession().getAttribute(sessionAttribute));
            request.getSession().removeAttribute(sessionAttribute);
        }
    }
}