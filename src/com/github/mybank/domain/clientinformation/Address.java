package com.github.mybank.domain.clientinformation;

import com.github.mybank.domain.validate.zipcode.ZipCode;

public class Address {
    private String street;          // Nome da rua/av./logradouro
    private String number;          // Número (String para casos como "12A" ou "S/N")
    private String complement;      // Complemento (apto, bloco, etc.)
    private String neighborhood;    // Bairro
    private String city;            // Cidade
    private String state;           // Estado (UF)
    private ZipCode postalCode;      // CEP (formato "12345-678")
    private String country;     // País (padrão "Brasil" se não especificado)

    private HousingType housingType; // Tipo de residência (enum existente)

    public Address(String street, String number, String complement,
                   String neighborhood, String city, String state,
                   String postalCode, HousingType housingType) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.postalCode = new ZipCode(postalCode);
        this.country = "Brasil";
        this.housingType = housingType;
    }

    public void changeHolderCountry(String otherCountry) { this.country = otherCountry; }

    @Override
    public String toString() {
        return String.format(
                """
                Endereço:
                  • Logradouro: %s, %s%s
                  • Bairro: %s
                  • Cidade: %s/%s
                  • CEP: %s
                  • País: %s
                  • Tipo residência: %s
                """,
                street,
                number,
                (complement != null && !complement.isEmpty() ? " (" + complement + ")" : ""),
                neighborhood,
                city,
                state,
                postalCode,
                country,
                housingType.getHousingDescription()
        );
    }

    private enum HousingType {
        APARTMENT("Apartamento"),
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
