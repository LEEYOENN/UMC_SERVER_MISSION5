package umc.study.converter;

import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.domain.Member;
import umc.study.domain.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = Gender.NONE; // 기본값 설정
        Integer age = request.getAge() != null ? request.getAge() : 0;
        String password = request.getPassword() != null ? request.getPassword() : "";

        if (request.getGender() != null) {
            switch (request.getGender()) {
                case 1:
                    gender = Gender.MALE;
                    break;
                case 2:
                    gender = Gender.FEMALE;
                    break;
                case 3:
                    gender = Gender.NONE;
                    break;
            }
        }
        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(password)
                .gender(gender)
                .age(age)
                .birthYear(request.getBirthYear())
                .birthMonth(request.getBirthMonth())
                .birthday(request.getBirthDay())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .role(request.getRole())
                .memberPreferList(new ArrayList<>())
                .build();
    }

}
