package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.mapstruct.MapStructMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunxian
 * @version 2022-10-10 16:36
 */
@RestController
@Slf4j
public class MapStructTestController {

    @RequestMapping("/u")
    public UserDto getU(){
                User user = new User();
        user.setId(1L);
        user.setName("sun");
        UserDto userDto = MapStructMapper.INSTANCE.toUserDto(user);
        log.info(userDto.toString());
        //14:44:39.386 [http-nio-8001-exec-1] INFO  c.e.d.c.MapStructTestController - UserDto(uid=1, uname=sun)
        return  userDto;
    }


}
