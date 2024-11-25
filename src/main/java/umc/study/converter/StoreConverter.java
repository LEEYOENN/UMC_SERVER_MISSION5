package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConverter {
    //DTO -> Entity 변환
    public static Store toEntity(StoreRequestDTO.AddDTO dto, Region region){
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .region(region)
                .build();
    }

    //Entity -> DTO
    public static StoreResponseDTO.AddResultDTO toResponseDTO(Store store){
        return StoreResponseDTO.AddResultDTO.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .build();
    }


}
