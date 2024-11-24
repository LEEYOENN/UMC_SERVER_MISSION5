package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberMissionRequestDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddDTO {
        @NotNull(message = "미션 ID는 필수입니다.")
        private Long missionId;

        @NotNull(message = "멤버 ID는 필수입니다.")
        private Long memberId;
    }
}
