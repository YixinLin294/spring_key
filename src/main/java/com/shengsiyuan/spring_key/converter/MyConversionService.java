package com.shengsiyuan.spring_key.converter;


import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConversionService implements ConversionService {

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        // 判断目标类型是否是Data
        // isAssignableFrom 表示调用的类是否可以由 targetType 转换而来, 即调用者是否为 targetType 的类型或其父类
        if (Date.class.isAssignableFrom(targetType)) {
            return true;
        }
        System.out.println(targetType);
        return false;
    }

    @Override
    public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (Date.class.isAssignableFrom(targetType.getObjectType())) {
            return true;
        }
        System.out.println(targetType);
        return false;
    }

    @Override
    public <T> T convert(Object source, Class<T> targetType) {
        System.out.println("convert");
        return null;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        // 如果源类型是 string , 我们直接将他转化为 Date 类型
        if (String.class.isAssignableFrom(sourceType.getObjectType())) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date parse = format.parse((String) source);
                return parse;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println("convert");
        return null;
    }

}
