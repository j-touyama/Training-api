package com.example.TrainingApi.service;

import java.util.ArrayList;
import java.util.List;

import com.example.TrainingApi.dto.UserDto;
import com.example.TrainingApi.dto.UserRequestDto;
import com.example.TrainingApi.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserDao dao;

    /** 全ユーザーを検索 */
    public List<UserDto> selectAll() {
        try {
            return this.dao.selectAll();
        } catch (Exception e) {
            e.getStackTrace();
            return new ArrayList<>();
        }
    }
    /** idからユーザーを検索 */
    public UserDto selectedId(String id){
        try {
            return this.dao.selectedId(id);
        } catch (Exception e) {
            e.getStackTrace();
            return UserDto.builder().build();
        }
    }

    /** ユーザー情報を登録 */
    public boolean insertUser(UserRequestDto request){
        try {
            return this.dao.insertUser(convertUserDto(request)) > 0;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /** ユーザー情報を登録 */
    public boolean updateUser(UserRequestDto request){
        try {
            return this.dao.updateUser(convertUserDto(request)) > 0;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /** ユーザー情報を削除 */
    public boolean deleteUser(String staffCode) {
        try {
            return this.dao.deleteUser(staffCode) > 0;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    private UserDto convertUserDto(UserRequestDto requestDto) {

         return UserDto.builder()
                 .id(Long.parseLong(requestDto.getId()))
                 .staffCode(requestDto.getStaffCode())
                 .lastName(requestDto.getLastName())
                 .firstName(requestDto.getFirstName())
                 .lastNameRomaji(requestDto.getLastNameRomaji())
                 .firstNameRomaji(requestDto.getFirstNameRomaji())
                 .staffDepartment(requestDto.getStaffDepartment())
                 .projectType(requestDto.getProjectType())
                 .joinedYear(requestDto.getJoinedYear())
                 .newGladFlg(requestDto.isNewGladFlg())
                 .build();
    }

}