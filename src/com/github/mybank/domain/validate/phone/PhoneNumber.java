package com.github.mybank.domain.validate.phone;

import java.util.Objects;
import java.util.regex.Pattern;


public class PhoneNumber {

    private static final Pattern PHONE_PATTERN = Pattern.compile(PhoneNumberRegex.getPhoneNumberRegex());

    public void validate(String phoneNumber) {
        Objects.requireNonNull(phoneNumber, "[ERROR] phone number cannot be null.");
        if(!PHONE_PATTERN.matcher(phoneNumber).matches())
            throw new IllegalArgumentException("[ERROR] Invalid phone number");
    }

    private String phoneNumber;

    public PhoneNumber(String phoneNumber){
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
