package com.github.mybank.domain.validate.email;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {

    private static final Pattern pattern = Pattern.compile(EmailRegex.getEmailRegex());

    private void validate(String email){
        Objects.requireNonNull(email, "O e-mail não deve ser nulo.");
        if(!pattern.matcher(email).matches())
            throw new IllegalArgumentException("O e-mail inserido não é válido.");
    }

    private String email;

    public Email(String email){
        validate(email);
        this.email = email;
    }

    public String getEmail(){ return this.email; }
}