package br.com.like.domains.enums;

import br.com.like.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Profile {

    ADMIN(Constants.ADMIN_CODE, Constants.ROLE_ADMIN),
    CLIENT(Constants.CLIENT_CODE, Constants.ROLE_CLIENTE);

    private Integer code;
    private String description;

    public static Profile toEnum(final Integer code) {

        if (code == null) {
            return null;
        }

        for (Profile profile: Profile.values()) {
            if(code.equals(profile.getCode())) {
                return profile;
            }
        }

        return null;
    }
}
