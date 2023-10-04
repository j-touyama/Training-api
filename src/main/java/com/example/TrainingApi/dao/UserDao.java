package com.example.TrainingApi.dao;

import com.example.TrainingApi.dto.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    /** 全ユーザーを検索 */
    List<UserDto> selectAll();

    /** idからユーザーを検索 */
    UserDto selectedId(String id);

    /** ユーザー情報を登録 */
    int insertUser(UserDto dto);

    /** ユーザー情報を更新 */
    int updateUser(UserDto dto);

    /** ユーザー情報を削除 */
    int deleteUser(String staffCode);
}
