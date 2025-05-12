package com.dailyquest.dailyquest.userprofile;

import com.dailyquest.dailyquest.habit.HabitModel;
import com.dailyquest.dailyquest.user.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class UserProfileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private UserModel user;
    @NotNull
    @OneToMany
    private List<HabitModel> habits;
}
