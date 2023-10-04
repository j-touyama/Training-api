package com.example.TrainingApi.controller;

import com.example.TrainingApi.dto.UserDto;
import com.example.TrainingApi.dto.UserListDto;
import com.example.TrainingApi.dto.UserRequestDto;
import com.example.TrainingApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService service;

    /**
     * 初期表示
     */
    @RequestMapping(value="/index",method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserListDto> index() {
        List<UserDto> userList = service.selectAll();
        var result = UserListDto.builder()
                .users(userList)
                .build();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 社員情報表示
     */
    @RequestMapping(value="/info", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserDto> getEmployee(@RequestParam("id") String id) {
        var result = service.selectedId(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 登録の処理
     */
    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> insertEmployee(@RequestBody UserRequestDto requestDto) throws Exception {

        service.insertUser(requestDto);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    /**
     * 更新の処理
     */
    @RequestMapping(value="/update", method= RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateEmployee(@RequestBody UserRequestDto requestDto) throws Exception {

        service.updateUser(requestDto);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    /**
     * 社員情報の削除
     */
    @RequestMapping(value="/delete", method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> deleteEmployee(@RequestParam("staffCode") String staffCode) throws Exception {

        service.deleteUser(staffCode);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}