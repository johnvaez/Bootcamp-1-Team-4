package com.scotiabank.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class CustomerDTO {

    @NotNull
    private String documentType;

    @NotNull
    private String documentNumber;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate documentIssueDate;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private String email;

    @NotNull
    private String cellphone;
}
