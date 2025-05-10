package com.github.mybank.domain.validate.cpf;

import java.util.Objects;

class CPFFormatter {

    private static String clearCPF(String cpf) {
        Objects.requireNonNull(cpf, "[ERRO] CPF não deve se null.");
        return cpf.replaceAll("[^0-9]", "");
    }

    private static void validLength(String cpf) {
        if(cpf.length() != 11){
            System.out.printf("Tamanho do cpf: %d\n", cpf.length());
            throw new IllegalArgumentException("[ERRO] CPF deve conter tamanho fixo de 11 algarismos.");
        }
    }

    private static void validSequence(String cpf) {
        if(cpf.matches("(\\d)\\1{10}")){
            throw new IllegalArgumentException("[ERRO] CPF inválido.");
        }
    }

    public static String validateFormatter(String cpf){
        String clearedCPF = clearCPF(cpf);
        validLength(clearedCPF);
        validSequence(clearedCPF);

        return clearedCPF;
    }
}