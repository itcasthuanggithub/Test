package com.shucheng.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class WebUtils {
    public static <T>T copyParamToBean(HttpServletRequest request,T bean){
        try {
            // System.out.println("注入之前"+bean);
            BeanUtils.populate(bean, request.getParameterMap());
            return bean;
            // System.out.println("注入之后："+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
  /*  字符串转换成int
    param  ：strId 字符串类型的数值
    param defaultvalue 转换失败的默认值
*/
    public static int parseInt(String strId,int defaultValue) {
        try {
            return Integer.parseInt(strId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
