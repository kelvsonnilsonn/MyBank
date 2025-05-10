package com.github.mybank.domain.validate;

import com.github.mybank.domain.validate.email.Email;
import com.github.mybank.domain.validate.phone.PhoneNumber;

public class Contact {
    private Email email;
    private PhoneNumber phoneNumber;

    public Contact(String email, String number){
    }
}
