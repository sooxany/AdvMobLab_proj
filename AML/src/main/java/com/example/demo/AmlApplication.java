package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.dao.UserMapper;
import com.example.demo.dto.UserDto; 

@SpringBootApplication
public class AmlApplication {
 
    private UserMapper uMapper;
     
    public void userTest() 
    {
        UserDto user = new UserDto();
        user.setUserID("test");
        user.setUserPassword("123456");
        uMapper.insertUser(user);
        
        System.out.println(uMapper.selectOneUser("test"));
    }

    public static void main(String[] args) throws Exception{
    	SpringApplication.run(AmlApplication.class, args);
    }
 
    
}
