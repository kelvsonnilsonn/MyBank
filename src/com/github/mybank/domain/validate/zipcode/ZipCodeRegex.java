package com.github.mybank.domain.validate.zipcode;

class ZipCodeRegex {

    private static final String ZIPCODE_REGEX = "^\\d{5}-?\\d{3}$";

    public static String getZipcodeRegex() { return ZIPCODE_REGEX; }

}
