package com.github.mybank.domain;

import com.github.mybank.domain.validate.Address;
import com.github.mybank.domain.validate.cpf.CPF;
import com.github.mybank.domain.validate.Contact;

import java.util.Date;

public class ClientInformation {

    private static String holderName;
    private Address holderAddress;
    private CPF cpf;
    private Date dateOfBirth;
    private Contact contact;

    public ClientInformation(){}

    public static void setHolderName(String name){ holderName = name; }




}
