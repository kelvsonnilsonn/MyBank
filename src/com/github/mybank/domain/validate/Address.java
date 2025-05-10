package com.github.mybank.domain.validate;

import com.github.mybank.domain.validate.zipcode.ZipCode;

public class Address {
    private String street;          // Nome da rua/av./logradouro
    private String number;          // Número (String para casos como "12A" ou "S/N")
    private String complement;      // Complemento (apto, bloco, etc.)
    private String neighborhood;    // Bairro
    private String city;            // Cidade
    private String state;           // Estado (UF)
    private ZipCode postalCode;      // CEP (formato "12345-678")
    private String country;         // País (padrão "Brasil" se não especificado)

    private HousingType housingType; // Tipo de residência (enum existente)

    private enum HousingType {
        APARTMENT("Apartamento"),  // Corrigi a grafia de "APARTAMENT" para "APARTMENT"
        HOUSE("Casa");

        private final String housingDescription;

        HousingType(String description) {
            this.housingDescription = description;
        }

        public String getHousingDescription() {
            return this.housingDescription;
        }
    }
}
