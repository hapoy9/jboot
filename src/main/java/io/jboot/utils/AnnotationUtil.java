package io.jboot.utils;


import io.jboot.app.config.JbootConfigManager;

public class AnnotationUtil {

    public static String get(String value) {
        if (StrUtil.isBlank(value)) {
            return null;
        } else {
            value = value.trim();
        }

        if (value.startsWith("${") && value.endsWith("}")) {
            String key = value.substring(2, value.length() - 1);
            if (StrUtil.isBlank(key)) throw new RuntimeException("can not config empty propertie key");
            return JbootConfigManager.me().getConfigValue(key.trim());
        }

        return value;
    }

    public static String[] get(String[] value) {
        if (ArrayUtil.isNullOrEmpty(value)) {
            return null;
        }

        String[] rets = new String[value.length];
        for (int i = 0; i < rets.length; i++) {
            rets[i] = get(value[i]);
        }
        return rets;
    }


}
