package com.Infra.Service_API.domain.student.dto;

import com.Infra.Service_API.domain.student.model.Student;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;

@JsonNaming(value = SnakeCaseStrategy.class)
public record StudentResponse (
        @Schema(description = "닉네임", example = "nickname", requiredMode = NOT_REQUIRED)
        String nickname,

        @Schema(description = "이름", example = "최준호", requiredMode = NOT_REQUIRED)
        String name,

        @Schema(description = "휴대폰 번호", example = "010-0000-0000", requiredMode = NOT_REQUIRED)
        String phoneNumber,

        @Schema(description = "이메일 주소", example = "koin123@koreatech.ac.kr", requiredMode = NOT_REQUIRED)
        String email,

        @Schema(description = "성별(남:0, 여:1)", example = "1", requiredMode = NOT_REQUIRED)
        Integer gender
) {
    public static StudentResponse from(Student student) {
        Integer userGender = null;
        if (student.getGender() != null) {
            userGender = student.getGender().ordinal();
        }
        return new StudentResponse(
                student.getNickname(),
                student.getName(),
                student.getPhoneNumber(),
                student.getEmail(),
                userGender
        );
    }
}
