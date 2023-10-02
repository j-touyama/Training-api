package com.example.TrainingApi.controller;

import com.example.TrainingApi.dto.UserDto;
import com.example.TrainingApi.dto.UserRequestDto;
import com.example.TrainingApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<UserDto> index() {
        return service.selectAll();
    }


    /**
     * 社員情報表示
     */
    @RequestMapping(value="/info", method=RequestMethod.GET)
    @ResponseBody
    public UserDto getEmployee(@RequestParam("id") String id) {
        return service.selectedId(id);
    }


    /**
     * 登録の処理
     */
    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    public String insertEmployee(@RequestBody UserRequestDto requestDto) {

        return String.valueOf(service.insertUser(requestDto));
    }

    /**
     * 更新の処理
     */
    @RequestMapping(value="/update", method= RequestMethod.POST)
    @ResponseBody
    public String updateEmployee(@RequestBody UserRequestDto requestDto) {

        return String.valueOf(service.updateUser(requestDto));
    }

    /**
     * 社員情報の削除
     */
    @RequestMapping(value="/delete", method= RequestMethod.GET)
    @ResponseBody
    public String deleteEmployee(@RequestParam("staffCode") String staffCode) {

        return String.valueOf(service.deleteUser(staffCode));
    }
}