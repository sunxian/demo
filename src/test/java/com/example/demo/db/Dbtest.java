package com.example.demo.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sunxian
 * @version 2022-09-20 16:11
 */
@SpringBootTest
@Slf4j
public class Dbtest {

   @Autowired
   private UserMapper userMapper;

   @Test
   void user(){
     // User user = userMapper.selectById(1L);
      QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
      User user1 = new User();
      user1.setId(1L);
      userQueryWrapper.setEntity(user1);
      User user2 = userMapper.selectOne(userQueryWrapper);
      log.info(user2.getUsername());
   }
}
