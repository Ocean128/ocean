package com.auicyh.mylibrary;

import android.support.annotation.NonNull;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * 作者：kelvin
 * 日期：16/5/16 13:23 赵海博
 * 功能：字符串和时间处理工具栏
 * @author Ocean
 */
public class StringUtils {
    /**
     * 判断字符串是否为空串
     * @param string 需要判断的字符串
     * @return true 为空串, false 不为空
     */
    public static boolean isNull(String string) {
        if (string == null) {
            return true;
        }
        String str = string.replace(" ", "");
        return str.length() == 0;
    }

    /**
     * 格式化服务端返回的json数据,剔除xml内容
     * <string xmlns="http://tempuri.org/">{"message":"true"}</string>
     * @param string 服务端返回的内容
     * @return 格式化后的json
     */
    public static String formatJsonStr(String string) throws Exception {
        if (isNull(string)) {
            return "";
        }
        int begin = string.indexOf("{");
        int end = string.lastIndexOf("}") + 1;
        //  当String 不包含'{' 或者 '}' 返回它本事身
        if (begin == -1 || end == -1) {
            return string;
        }
        return string.substring(begin, end);
    }

    /**
     * 判断编辑框是否为空并提示
     * @param editTexts editTex集合
     * @param errorStr  提示的文字
     * @return 如果全部有内容返回 true
     */
    public static boolean editTextNull(List<EditText> editTexts, String errorStr) {
        for (int i = 0; i < editTexts.size(); i++) {
            if ("".equals(editTexts.get(i).getText().toString().trim())) {
                editTexts.get(i).setError(errorStr);
                return false;
            }
        }
        return true;
    }

    /**
     * 判断编辑框是否为空并提示
     * @param editTexts editTex集合
     * @param strArr    提示的内容
     * @return 全部不为空时返回 true
     */
    public static boolean editTextNull(List<EditText> editTexts, String[] strArr) {
        for (int i = 0; i < editTexts.size(); i++) {
            if ("".equals(editTexts.get(i).getText().toString().trim())) {
                editTexts.get(i).setError(strArr[i]);
                return false;
            }
        }
        return true;
    }

    /**
     * 判断编辑框是否为空并提示
     * @param editText editTex集合
     * @param str      提示的内容
     * @return 不为空时返回 true
     */
    public static boolean editTextNull(EditText editText, String str) {
        if ("".equals(editText.getText().toString().trim())) {
            editText.setError(str);
            return false;
        }
        return true;
    }

    /**
     * @param str  传入的值
     * @param str2 为空提换的值
     * @return 为空的话返回替换的值否则返回传入的值
     */
    public static String setString(String str, String str2) {
        return StringUtils.isNull(str) ? str2 : str;
    }


    /**
     * 截取整数
     * @param str1 要截取的字符串
     * @param str2 截取的位置
     * @param i    小数点后几位 位置 第一
     * @return 截取的内容
     */
    public static String cutOutInteger(String str1, String str2, int i) {
        if (str1.contains(str2)) {
            int position = str1.lastIndexOf(str2);
            return str1.substring(0, position + i);
        }
        return str1;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss 格式
     * @param date   要格式的时间毫秒
     * @param format 你要的时间格式 yyyy-MM-dd HH:mm:ss或者yyyy-MM-dd
     * @return 格式化后的时间
     */
    public static String formatDate(Long date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        return formatter.format(date);
    }

    /**
     * @param millis 要格式的时间
     * @param format 格式
     * @return 格式化后的数据
     */
    public static String getDataTime(Long millis, String format) {
        return StringUtils.formatDate(millis, format);
    }

    /**
     * @return 返回当前时间毫秒值
     */
    @NonNull
    public static Long getMillis() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss 格式
     * @param format 你要的时间格式 yyyy-MM-dd HH:mm:ss或者yyyy-MM-dd
     * @return 格式化后的时间
     */
    public static String formatDate(String format) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        return formatter.format(calendar.getTimeInMillis());
    }
}