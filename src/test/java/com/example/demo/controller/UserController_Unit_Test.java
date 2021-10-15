package com.example.demo.controller;

import com.example.demo.model.UserAddress;
import com.example.demo.model.UserEntity;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// watch Dilip Kafka course, Section Unit Testing using JUnit-5
@WebMvcTest(UserController.class)         // <-- this annotation we need to put when we want to create a Test for Controller layer
@AutoConfigureMockMvc                   // <-- this annotation we need when we want to use @MockMvc  annotation in the Test
public class UserController_Unit_Test {           // in this "UserController.class" , as we have done with @Autowire

    @Autowired
    MockMvc mockMvc;          // this we will create a Mock environment for all the endpoints that we defined in the Controller class

    @MockBean                     //<-- just draw in mind at runtime  with this @MockBean only a  Mock is created, it will not
    UserService userService;         // execute the real "UserService" call, for checking this i put  a Logger in the service class


    ObjectMapper objectMapper = new ObjectMapper();  // while sending a Post request we need to send object as Json Object so we need
                                                        // ObjectMapper to convert the UserEntity Object into Json Object
    @Test
    void getUser() throws Exception {
        // given
        UserEntity userEntity = UserEntity.builder().userName("b22").userCity("c22").userMob(123).build();

        // when
        when(userService.createUser2(userEntity)).thenReturn(userEntity);

        // then
        mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createUser() throws Exception {              // as we have used in the  @NonNull & @Valid in the UserEntity class  on the
        // given                                      // UserAddress attribute so we are not allowed to pass "userAddress(null)"
        UserAddress userAddress = UserAddress.builder().add1("add1").add2("add2").build();
        UserEntity userEntity = UserEntity.builder().userName("b22").userCity("c22").userMob(123).userAddress(userAddress).build();

        // when
        when(userService.createUser2(userEntity)).thenReturn(userEntity);

        // then
        String convertIntoJson = objectMapper.writeValueAsString(userEntity);   // as from "Postman" also we are passing the
                                                                                //  object as Json so here first we need to convert
        mockMvc.perform(   post("/user")                              //  this Object into Json
                            .content(convertIntoJson)
                            .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isCreated());
    }
//
/*    @Test
    void createUser_with_Error() throws Exception {              // as we have used in the  @NonNull & @Valid in the UserEntity class  on the
        // given                                      // UserAddress attribute so we are not allowed to pass "userAddress(null)"
        UserEntity userEntity = UserEntity.builder().userName("b22").userCity("c22").userMob(123).userAddress(null).build();

        // when
        when(userService.createUser2(userEntity)).thenReturn(userEntity);
    //    doNothing().when(userService).createUser2(isA(UserEntity.class));

        // then
        String convertIntoJson = objectMapper.writeValueAsString(userEntity);   // as from "Postman" also we are passing the
        // object as Json so here first we need to convert
        mockMvc.perform(   post("/user")                              //  this Object into Json
                .content(convertIntoJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().is4xxClientError());
    }
*/


}
