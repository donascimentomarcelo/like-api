package br.com.like.validations;

import br.com.like.annotations.ZipcodeValidation;
import br.com.like.constants.Constants;
import br.com.like.dtos.AddressDto;
import br.com.like.exceptions.models.FieldMessage;
import br.com.like.utils.Util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ZipcodeValidator implements ConstraintValidator<ZipcodeValidation, AddressDto> {
    @Override
    public void initialize(ZipcodeValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(final AddressDto dto, final ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if(!dto.getZipcode().matches(Constants.ZIPCODE_PATTERN)) {
            list.add(new FieldMessage(Constants.ZIPCODE, Constants.ZIPCODE_INVALID));
        }

        Util.addInContext(context, list);

        return list.isEmpty();
    }
}
