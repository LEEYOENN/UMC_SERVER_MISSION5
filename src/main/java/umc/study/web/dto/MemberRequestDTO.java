package umc.study.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.domain.enums.Role;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank(message = "이름은 공백이 없어야하고 필수입니다..")
        String name;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;

        Integer gender;

        Integer age;

        Integer birthYear;

        Integer birthMonth;

        Integer birthDay;
        @Size(min=5, max=12)
        String address;
        @Size(min=5, max=12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
        @NotNull
        Role role;
    }
}
