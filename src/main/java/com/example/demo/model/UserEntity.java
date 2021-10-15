package com.example.demo.model;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @NonNull
    private String userName;

    @NonNull
    private String userCity;

    @NonNull
    private int userMob;


}
