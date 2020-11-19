package br.com.like.validations;

import br.com.like.annotations.UsernameValidation;
import br.com.like.constants.Constants;
import br.com.like.domains.User;
import br.com.like.dtos.UserDto;
import br.com.like.exceptions.models.FieldMessage;
import br.com.like.services.UserService;
import br.com.like.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UsernameValidator implements ConstraintValidator<UsernameValidation, UserDto> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UsernameValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(final UserDto dto, final ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        User user = userService.findByUsername(dto.getUsername());

        if(user != null) {
            list.add(new FieldMessage(Constants.USERNAME, Constants.USERNAME_UNAVALIBLE));
        }

        Util.addInContext(context, list);

        return list.isEmpty();
    }
}
