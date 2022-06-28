package com.futcleats.http.dto.request;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Getter
@Setter
public class UserRequest {

    @NotEmpty(message = "Informe o nome.")
    private String name;

    @NotEmpty(message = "Informe o nome de login.")
    private String login;

    @NotEmpty(message = "Informe o CPF.")
    @CPF(message = "Informe um cpf válido.")
    private String cpf;

    @NotEmpty(message = "Informe o telefone pra contato.")
    private String telephone;

    @NotEmpty(message = "Informe o email.")
    @Email(message = "Informe um email válido.")
    private String email;

    @NotNull(message = "Informe a data de nascimento.")
    private Date birthDate;

    @NotEmpty(message = "Informe a senha.")
    @Size(max=20,min=5,message="Mínimo 8 caracteres e máximo 20.")
    private String password;
}
