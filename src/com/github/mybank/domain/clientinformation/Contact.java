package com.github.mybank.domain.clientinformation;

import com.github.mybank.domain.validate.email.Email;
import com.github.mybank.domain.validate.phone.PhoneNumber;

class Contact {
    private Email email;
    private PhoneNumber phoneNumber;

    public Contact(String email, String number){
        this.email = new Email(email);
        this.phoneNumber = new PhoneNumber(number);
    }

    @Override
    public String toString() {
        return String.format(
                """
                  • Contato:
                    - Email: %s
                    - Telefone: %s
                """,
                email,
                phoneNumber
        );
    }
}
