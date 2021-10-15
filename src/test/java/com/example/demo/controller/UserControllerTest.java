package com.example.demo.controller;

import com.example.demo.model.UserEntity;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// watch Dilip Kafka course, Section Unit Testing using JUnit-5
@WebMvcTest(UserController.class)         // <-- with this we are saying that we are going to test this "Controller" class
@AutoConfigureMockMvc                   // <-- with it we are saying that create a "Mock" of all the endpoints that are injected
public class UserControllerTest {           // in this "UserController.class" , as we have done with @Autowire


    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;


    @Test
    void createUser() throws Exception {
        // given
        UserEntity userEntity = UserEntity.builder().userName("b22").userCity("c22").userMob(123).build();

        // when
        when(userService.createUser(userEntity)).thenReturn(userEntity);

        // then
        mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
