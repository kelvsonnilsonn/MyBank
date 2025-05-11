package com.github.mybank.domain.clientinformation;

import com.github.mybank.domain.validate.cpf.CPF;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientInformation{

    private String holderName;
    private final CPF cpf;
    private final Date dateOfBirth;
    private Contact contact;
    private Address address;

    public ClientInformation(String holderName, String cpf, Date dateOfBirth,
                             String email, String phoneNumber){
        this.holderName = holderName;
        this.cpf = new CPF(cpf);
        this.dateOfBirth = dateOfBirth;
        this.contact = new Contact(email, phoneNumber);
    }

    public void setHolderAddress(Address address) { this.address = address; }

    @Override
    public String toString() {
        return String.format(
                """
                Informações do Cliente:
                ========================================
                  • Nome: %s
                  • CPF: %s
                  • Data Nasc.: %s
                  %s
                  %s
                ========================================
                """,
                holderName != null ? holderName : "Nome indefinido.",
                cpf,
                dateOfBirth != null ? new SimpleDateFormat("dd/MM/yyyy").format(dateOfBirth) : "Data de aniversário indefinida.",
                contact != null ? contact.toString() : "[Contato não cadastrado]",
                address != null ? address.toString() : "[Endereço não cadastrado]"
        );
    }

}
