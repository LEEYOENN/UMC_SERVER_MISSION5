package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class StoreRequestDTO {

    @Getter
    @Setter
    public static class AddDTO {
        @NotNull(message = "가게 이름은 필수 입력 항목입니다.")
        private String name;

        @NotNull(message = "주소는 필수 입력 항목입니다.")
        private String address;

        @NotNull(message = "지역 ID는 필수 입력 항목입니다.")
        private Long regionId;
    }
}
