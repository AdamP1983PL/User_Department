package com.user_department.model.enums;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private final String displayText;

    Role(String displayText) {
        this.displayText = displayText;
    }

}
