package com.example.TrainingApi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    private String staffCode;
    private String lastName;
    private String firstName;
    private String lastNameRomaji;
    private String firstNameRomaji;
    private String staffDepartment;
    private String projectType;
    private String joinedYear;
    private Boolean newGladFlg;
}