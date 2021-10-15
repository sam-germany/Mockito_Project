package com.example.demo.services;

import com.example.demo.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {


    public UserEntity getUser(){

        UserEntity userEntity =  UserEntity.builder()
                                           .userName("aaa")
                                           .userCity("nurnberg")
                                           .userMob(123)
                                           .build();
        log.info("we are inside the UserService class and getUser() method",String.valueOf(userEntity));
        return userEntity;
    }

    public UserEntity createUser2(UserEntity ue){

         UserEntity userEntity =  UserEntity.builder()
                                            .userName(ue.getUserName())
                                            .userCity(ue.getUserCity())
                                            .userMob(ue.getUserMob())
                                            .build();
        log.info("we are inside the UserService class and createUser() method",String.valueOf(userEntity));
        return userEntity;
    }

}
