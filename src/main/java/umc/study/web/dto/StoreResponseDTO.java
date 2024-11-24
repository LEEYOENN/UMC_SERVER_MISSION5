package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;


public class StoreResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddResultDTO{
        Long storeId;
        String storeName;
    }
}
