package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank(message = "이름은 공백이 없어야하고 필수입니다..")
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer age;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min=5, max=12)
        String address;
        @Size(min=5, max=12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}
