package com.dailyquest.dailyquest.activity.userprofile;

import com.dailyquest.dailyquest.user.UserModel;
import jakarta.persistence.*;

@Entity
public class UserProfileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private UserModel user;
}
