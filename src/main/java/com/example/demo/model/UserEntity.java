package com.example.demo.model;


import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @NotNull
    private String userName;

    @NotNull
    private String userCity;

    @NotNull
    private int userMob;

    @NotNull
    private UserAddress userAddress;


}
