package com.example.demo.services;

import com.example.demo.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public UserEntity getUser(){

        UserEntity userEntity =  UserEntity.builder()
                                           .userName("aaa")
                                           .userCity("nurnberg")
                                           .userMob(123)
                                           .build();
        return userEntity;
    }

    public UserEntity createUser(UserEntity ue){

         UserEntity userEntity =  UserEntity.builder()
                                            .userName(ue.getUserName())
                                            .userCity(ue.getUserCity())
                                            .userMob(ue.getUserMob())
                                            .build();
        return userEntity;
    }

}
