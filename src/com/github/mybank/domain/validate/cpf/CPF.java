package com.github.mybank.domain.validate.cpf;

public record CPF(String cpf) {
    public CPF {
        validate(cpf);
    }

    private void validate(String cpf) {

        String clearedCpf = CPFFormatter.validateFormatter(cpf);
        CPFCalculateDigits.validateDigits(clearedCpf);

    }
}
