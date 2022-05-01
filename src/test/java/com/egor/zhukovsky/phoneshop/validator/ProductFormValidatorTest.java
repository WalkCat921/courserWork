package com.egor.zhukovsky.phoneshop.validator;

import com.egor.zhukovsky.phoneshop.model.product.CameraСharacteristics;
import com.egor.zhukovsky.phoneshop.model.product.MainСharacteristics;
import com.egor.zhukovsky.phoneshop.model.product.OtherСharacteristics;
import com.egor.zhukovsky.phoneshop.model.product.Product;
import org.junit.Test;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ProductFormValidatorTest {

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

    @Test
    public void validateProductForm() {
        Map<String,String> errors = new HashMap<>();
        String releaseYear = "2015";
        String os = "sdf";
        String osVersion ="asd";
        String screenSize = "asd";
        String buildCamera = "asd";
        String video = "asd";
        String frontalCamera ="asd";
        String diaphragm = "asd";
        String audioType = "asd";
        String battery = "2000";
        String material = "asd";
        String graphics = "asd";
        String core = "1";
        String cpu = "asd";
        String sim = "asd";
        String ram = "1";
        String builtMemory = "512";
        String code = "asd";
        String description = "asd";
        String price = "1";
        Currency currency = Currency.getInstance("USD");
        String stock = "1";
        String imageUrl = "https://mobistore.by/files/products/1/sony-xperia-1-iii-256gb-pr17043_8.800x600w.jpg?0ce18a7d5f54fcc6562414cef775af94";
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
        ProductFormValidator.validateProductForm(code,CODE_PARAM,errors,product::setCode);
        ProductFormValidator.validateProductForm(description,DESCRIPTION_PARAM,errors,product::setDescription);
        ProductFormValidator.validateProductForm(price,PRICE_PARAM,errors,product::setPrice);
        ProductFormValidator.validateProductForm(stock,STOCK_PARAM,errors,product::setStock);
        ProductFormValidator.validateProductForm(imageUrl,IMAGE_URL_PARAM,errors,product::setImageUrl);
        product.setMainСharacteristics(mainСharacteristics);
        product.setCameraСharacteristics(cameraСharacteristics);
        product.setOtherСharacteristics(otherСharacteristics);
        System.out.println(product);
        System.out.println(errors);
        System.out.println(errors.size());
    }
}