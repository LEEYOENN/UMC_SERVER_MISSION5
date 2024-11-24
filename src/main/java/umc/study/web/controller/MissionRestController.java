package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionQueryService missionService;

    @PostMapping("/")
    @Operation(summary = "새로운 미션 추가", description = "새로운 미션을 추가합니다.")
    public ApiResponse<MissionResponseDTO.AddResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.AddDTO request){
        Mission response = missionService.addMission(request);

        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(response));
    }
}
