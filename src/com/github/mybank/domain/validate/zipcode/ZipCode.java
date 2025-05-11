package com.github.mybank.domain.validate.zipcode;

import java.util.Objects;
import java.util.regex.Pattern;

public class ZipCode {

    private static final Pattern ZIPCODE_PATTERN = Pattern.compile(ZipCodeRegex.getZipcodeRegex());

    public void validate(String zipCode) {
        Objects.requireNonNull(zipCode, "O CEP não pode ser nulo.");
        if(!ZIPCODE_PATTERN.matcher(zipCode).matches())
            throw new IllegalArgumentException("O CEP é inválido.");
    }

    private String zipcode;

    public ZipCode(String zipCode){
        validate(zipCode);
        this.zipcode = zipCode;
    }

    public String getZipcode() {
        return zipcode;
    }
}
