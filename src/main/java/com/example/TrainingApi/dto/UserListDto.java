package com.example.TrainingApi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserListDto {
    private List<UserDto> users;
}
