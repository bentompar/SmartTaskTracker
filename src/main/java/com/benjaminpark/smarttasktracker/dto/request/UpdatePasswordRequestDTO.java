package com.benjaminpark.smarttasktracker.dto.request;

import com.benjaminpark.smarttasktracker.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;

public class UpdatePasswordRequestDTO {

    @NotBlank(message = "Password Required")
    @ValidPassword
    private String newPassword;

    @NotBlank(message = "Password Required")
    private String oldPassword;

    public UpdatePasswordRequestDTO() {}

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @Override
    public String toString() {
        return "UpdatePasswordRequestDTO{newPassword=[PROTECTED], oldPassword=[PROTECTED]}";
    }

}
