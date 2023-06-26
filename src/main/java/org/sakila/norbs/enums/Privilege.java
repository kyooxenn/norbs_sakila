package org.sakila.norbs.enums;

import lombok.Getter;

public enum Privilege {
    READ(0b01),
    WRITE(0b10),
    READ_WRITE(0b11),
    ;

    @Getter
    private final int privilege;

    Privilege(int privilege) {
        this.privilege = privilege;
    }

    public boolean check(int value) {
        return (this.privilege & value) > 0;
    }
}
