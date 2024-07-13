package com.Infra.Service_API.domain.student.model;

import java.util.Arrays;

public enum Gender {
    MAN,
    WOMAN,
    ;

    public static Gender from(Integer index) {
        if (index == null) {
            return null;
        }
        return Arrays.stream(values())
                .filter(it -> it.ordinal() == index)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
