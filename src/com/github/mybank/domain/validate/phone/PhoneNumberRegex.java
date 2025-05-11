package com.github.mybank.domain.validate.phone;

class PhoneNumberRegex {
    private static final String PHONE_REGEX =
            "^(?:(?:\\+|00)?(55)\\s?)?(?:\\(?([1-9][0-9])\\)?\\s?)?(?:((?:9\\d|[2-9])\\d{3})\\-?(\\d{4}))$";

    public static String getPhoneNumberRegex() {
        return PHONE_REGEX;
    }
}
