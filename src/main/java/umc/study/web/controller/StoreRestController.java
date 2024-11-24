package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.service.StoreService.StoreQueryService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreQueryService storeService;
    private final StoreConverter storeConverter;
    @PostMapping
    public ApiResponse<StoreResponseDTO.AddResultDTO> addStore(@RequestBody @Valid StoreRequestDTO.AddDTO request){
        Store store = storeService.addStore(request);

        //AddRequestDTO생성
        return ApiResponse.onSuccess(storeConverter.toResponseDTO(store));
    }

}
