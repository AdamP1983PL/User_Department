package com.user_department.model.enums;

import lombok.Getter;

@Getter
public enum Role {
    USER("USER"),
    ADMIN("ADMIN");

    private final String displayText;

    Role(String displayText) {
        this.displayText = displayText;
    }

}
