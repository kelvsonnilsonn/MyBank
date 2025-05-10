package com.github.mybank.domain.validate.email;

class EmailRegex {
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    // ^ -> Informa o ponto de partida da string.

    // [a-zA-Z0-9_+&*-]+ -> Informa o quais caracteres serão permitidos (Letras minusculas de a a z,
    //                                                                  maiusculas de A a Z e
    //                                                                  digitos de 0 a 9.
    //                                                                  Também _, +, &, * e -)

    // (?:\\.[a-zA-Z0-9_+&*-]+)* -> Informa que também é permitido pontos (o ?:\ é chamado de ponto capturador e não armazena o resultado.
    //                                                                      o \\. é um ponto literal
    //                                                                      o * significa "zero ou mais repetições".
    //
    //                                                                      Ou seja, esse padrão diz que pode haver um . seguido de caracteres e esse padrão pode se repetir várias vezes.
    //                                                                      nome.extra.mais.um, por exemplo).

    // @ -> o @ se torna obrigatório.

    // (?:[a-zA-Z0-9-]+\\.)+ -> Refere-se ao domínio do e-mail: gmail, hotmail e etc. (Mesma coisa de sempre e o \\. diz que o ponto é obrigatório.)

    // [a-zA-Z]{2,7} -> Informa os caracteres permitidos e o {2,7} indica o tamanho do que vem depois do : .com .org e etc...

    // $ -> Indica o fim da string.

    public static String getEmailRegex() { return EMAIL_REGEX; }

}