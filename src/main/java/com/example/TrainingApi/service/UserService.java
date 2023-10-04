package com.example.TrainingApi.service;

import java.util.ArrayList;
import java.util.List;

import com.example.TrainingApi.dto.UserDto;
import com.example.TrainingApi.dto.UserRequestDto;
import com.example.TrainingApi.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


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
    public void insertUser(UserRequestDto request) throws Exception {
        try {
            var dto = convertUserDto(request);
            var result = this.dao.insertUser(dto);
            if (result <= 0) {
                throw new Exception("登録処理に失敗しました。");
            }
        } catch (Exception e) {
            e.getStackTrace();
            throw e;
        }
    }

    /** ユーザー情報を登録 */
    public void updateUser(UserRequestDto request) throws Exception {
        try {
            var dto = convertUserDto(request);
            var result = this.dao.updateUser(dto);
            if (result <= 0) {
                throw new Exception("更新処理に失敗しました。");
            }
        } catch (Exception e) {
            e.getStackTrace();
            throw e;
        }
    }

    /** ユーザー情報を削除 */
    public void deleteUser(String staffCode) throws Exception {

        try {
            var result = this.dao.deleteUser(staffCode);
            if (result <= 0) {
                throw new Exception("更新処理に失敗しました。");
            }
        } catch (Exception e) {
            e.getStackTrace();
            throw e;
        }
    }

    private UserDto convertUserDto(UserRequestDto requestDto) {

        var projectType = requestDto.getProjectType();

        projectType = projectType.replaceAll("\r\n", "<br />");
        projectType = projectType.replaceAll("\n", "<br />");
        projectType = projectType.replaceAll("\r", "<br />");
         return UserDto.builder()
                 .id(Long.parseLong(StringUtils.hasText(requestDto.getId())?requestDto.getId():"0"))
                 .staffCode(requestDto.getStaffCode())
                 .lastName(requestDto.getLastName())
                 .firstName(requestDto.getFirstName())
                 .lastNameRomaji(requestDto.getLastNameRomaji())
                 .firstNameRomaji(requestDto.getFirstNameRomaji())
                 .staffDepartment(requestDto.getStaffDepartment())
                 .projectType(projectType)
                 .joinedYear(requestDto.getJoinedYear())
                 .newGladFlg(requestDto.isNewGladFlg())
                 .build();
    }

}