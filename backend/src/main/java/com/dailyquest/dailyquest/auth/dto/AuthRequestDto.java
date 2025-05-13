package com.dailyquest.dailyquest.auth.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthRequestDto(String username, String password) {
}
