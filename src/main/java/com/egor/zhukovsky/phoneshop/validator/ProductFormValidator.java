package com.egor.zhukovsky.phoneshop.validator;

import com.egor.zhukovsky.phoneshop.model.order.PaymentMethod;
import com.egor.zhukovsky.phoneshop.model.product.MainСharacteristics;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

public class ProductFormValidator {
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
    private static final String MESSAGE_REQUIRED_VALUE = "Обязательное поле";
    private static final String MESSAGE_INCORRECT_VALUE = "Неверное значение";
    private static final String REGEX_PHONE = "375[0-9]{9}";
    private static final String REGEX_IMAGE_URL = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)";
    private static final String REGEX_NAME = "[A-Z][a-z]*";
    private static final String REGEX_ADDRESS = "([a-z]{2})+(.| |. )([A-Z][a-z]*)+( )+([0-9]{1,4})(-[0-9]{0,3}|)-[0-9]{1,4}(,| |  |, )[A-Z][a-z]*";

    public static <T> void validateProductForm(String value, String parameter, Map<String, String> errors,
                                             Consumer<T> consumer) {
        if (value == null || value.isEmpty()) {
            errors.put(parameter, MESSAGE_REQUIRED_VALUE);
        } else {
            switch (parameter) {
                case ID_PARAM:
                {
                    if (!StringUtils.isNumeric(value)){
                        errors.put(parameter,MESSAGE_INCORRECT_VALUE);
                        return;
                    } else {
                        Long id = Long.parseLong(value);
                        consumer.accept((T) id);
                        return;
                    }
                }
//                break;
                case DESCRIPTION_PARAM:
                case CODE_PARAM:
                    if (value.length() < 1 || value.length() > 100) {
                        errors.put(parameter, MESSAGE_INCORRECT_VALUE);
                        return;
                    }
                    break;
                case IMAGE_URL_PARAM: {
                    if (!isImageUrlCorrect(value)) {
                        errors.put(parameter, MESSAGE_INCORRECT_VALUE);
                        return;
                    }
                }
                break;
                case STOCK_PARAM:
                    if (!StringUtils.isNumeric(value) || !isStockCorrect(Integer.parseInt(value))) {
                        errors.put(parameter, MESSAGE_INCORRECT_VALUE);
                        return;
                    }else {
                        Integer stock = Integer.parseInt(value);
                        consumer.accept((T) stock);
                        return;
                    }
//                    break;
                case PRICE_PARAM: {
                    if (!StringUtils.isNumeric(value) || !isPriceCorrect(new BigDecimal(value))) {
                        errors.put(parameter, MESSAGE_INCORRECT_VALUE);
                        return;
                    } else {
                        consumer.accept((T) new BigDecimal(value));
                        return;
                    }
                }
                case RELEASE_YEAR_PARAM: {
                    if (!isReleaseYearCorrect(value)) {
                        errors.put(parameter, MESSAGE_INCORRECT_VALUE);
                        return;
                    } else {
                        Integer year = Integer.parseInt(value);
                     consumer.accept((T) year);
                        return;
                    }
                }
//                break;
                case BATTERY_PARAM: {
                    if (!isBatteryCorrect(value)) {
                        errors.put(parameter, MESSAGE_INCORRECT_VALUE);
                        return;
                    }
                    else {
                        Integer battery = Integer.parseInt(value);
                        consumer.accept((T) battery);
                        return;
                    }
                }
//                break;
                case CORE_PARAM: {
                    if (!isCoreCorrect(value)) {
                        errors.put(parameter, MESSAGE_INCORRECT_VALUE);
                        return;
                    }
                    else {
                        Integer core = Integer.parseInt(value);
                        consumer.accept((T) core);
                        return;
                    }
                }
//                break;
                case RAM_PARAM: {
                    if (!isRAMCorrect(value)){
                        errors.put(parameter,MESSAGE_INCORRECT_VALUE);
                        return;
                    }
                    else {
                        Integer ram = Integer.parseInt(value);
                        consumer.accept((T) ram);
                        return;
                    }
                }
//                break;
                case BUILT_MEMORY_PARAM:{
                    if (!isBuiltMemoryCorrect(value)){
                        errors.put(parameter,MESSAGE_INCORRECT_VALUE);
                        return;
                    }
                    else {
                        Integer builtMemory = Integer.parseInt(value);
                        consumer.accept((T) builtMemory);
                        return;
                    }
                }
//                break;
            }
            consumer.accept((T) value);
        }
    }

    private static boolean isImageUrlCorrect(String imageUrl) {
        return imageUrl.matches(REGEX_IMAGE_URL);
    }

    private static boolean isStockCorrect(int stock) {
        return stock > 0;
    }

    private static boolean isPriceCorrect(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isReleaseYearCorrect(String releaseYear) {
        if (StringUtils.isNumeric(releaseYear)) {
            int year = Integer.parseInt(releaseYear);
            if (year >= 2015 && year <= 2030) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBatteryCorrect(String batteryString) {
        if (StringUtils.isNumeric(batteryString)) {
            int battery = Integer.parseInt(batteryString);
            if (battery >= 2000) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCoreCorrect(String coreString) {
        if (StringUtils.isNumeric(coreString)) {
            int core = Integer.parseInt(coreString);
            if (core > 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRAMCorrect(String RAMString) {
        if (StringUtils.isNumeric(RAMString)) {
            int ram = Integer.parseInt(RAMString);
            if (ram > 0 && ram<=512) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBuiltMemoryCorrect(String builtMemoryString){
        if (StringUtils.isNumeric(builtMemoryString)){
            int builtMemory = Integer.parseInt(builtMemoryString);
            if (builtMemory >0 && builtMemory<=512){
                return true;
            }
        }
        return false;
    }
}
