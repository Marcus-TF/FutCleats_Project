package com.futcleats.http.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID id;

    private String name;

    private String login;

    private String cpf;

    private String telephone;

    private String email;

    private LocalDate birthDate;

    private String password;
}
