package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static  class AddDTO{

        @NotNull(message = "가게 id는 필수입니다.")
        private Long storeId;

        @NotNull(message = "미션 보상은 필수입니다.")
        private Integer reward;

        @NotNull(message = "미션 마감일은 필수입니다.")
        private LocalDate deadline;

        @NotNull(message = "미션 설명은 필수입니다.")
        private String missionSpec;
    }
}
