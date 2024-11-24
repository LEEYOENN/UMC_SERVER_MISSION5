package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService.MemberMissionService;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

@RestController
@RequestMapping("/api/member-missions")
@RequiredArgsConstructor
public class MemberMissionRestController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.AddResultDTO> challengeMission(@RequestBody @Valid MemberMissionRequestDTO.AddDTO request){
        MemberMission memberMission = memberMissionService.challengeMission(request);

        return ApiResponse.onSuccess(MemberMissionConverter.toAddResponseDTO(memberMission));
    }
}
