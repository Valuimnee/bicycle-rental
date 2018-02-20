package com.tsalapova.bicyclerental.tag;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/10/2018
 */
public enum InputType {
    LOGIN("type=\"text\" pattern=\"^[-\\w.]{4,20}$\""), PASSWORD("type=\"password\" pattern=\"^[^ ]{8,40}$\""),
    NAME("type=\"text\" pattern=\"^([\\p{L}'][ \\p{L}'-]*\\p{L}|\\p{L}[\\p{L}'-]*)$\""),
    PRODUCT_NAME("type=\"text\" pattern=\"^([\\p{L}\\d'][ \\p{L}\\d'-.]*[\\p{L}\\d]|[\\p{L}\\d][\\p{L}\\d'-.]*)$\""),
    ADDRESS("type=\"text\" pattern=\"^([\\p{L}.,-/\\d]+\\s+)*[\\p{L}.,-/\\d]+$\""),
    PASSPORT("type=\"text\" pattern=\"^(AB|BM|HB|KH|MP|MC|KB|PP)\\d{7}$\""), PHONE("type=\"tel\" pattern=\"^+\\d{12}$\""),
    EMAIL("type=\"email\""), DATETIME("type=\"datetime-local\""), HOURS("type=\"number\" min=\"1\" max=\"168\""),
    CURRENCY("type=\"number\" min=\"0\" step=\"0.01\"");

    private final String pattern;

    InputType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return this.pattern;
    }
}
