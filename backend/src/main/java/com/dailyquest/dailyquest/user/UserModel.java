package com.dailyquest.dailyquest.user;

import com.dailyquest.dailyquest.userprofile.UserProfileModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String userName;
    @NotBlank
    private String hashedPassword;
    @OneToOne
    private UserProfileModel userProfile;
}
