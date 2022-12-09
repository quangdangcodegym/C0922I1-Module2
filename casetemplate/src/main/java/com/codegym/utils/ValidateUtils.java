package com.codegym.utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    private static final String patternName = "^[A-Z]([A-Z]*[a-z0-9]*[ ]?)+$";

    public static boolean validateProductName(String nameProduct) {
        return Pattern.compile(patternName).matcher(nameProduct).matches();
    }
}
