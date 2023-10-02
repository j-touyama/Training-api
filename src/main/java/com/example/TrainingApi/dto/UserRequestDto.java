package com.example.TrainingApi.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String id;
    private String staffCode;
    private String lastName;
    private String firstName;
    private String lastNameRomaji;
    private String firstNameRomaji;
    private String staffDepartment;
    private String projectType;
    private String joinedYear;
    private boolean newGladFlg=true;
}
