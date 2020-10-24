package br.com.like.validations;

import br.com.like.annotations.EmailUnalterableValidation;
import br.com.like.constants.Constants;
import br.com.like.domains.Client;
import br.com.like.dtos.ClientDto;
import br.com.like.exceptions.models.FieldMessage;
import br.com.like.services.ClientService;
import br.com.like.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class EmailUnalterableValidator implements ConstraintValidator<EmailUnalterableValidation, ClientDto> {

    @Autowired
    private ClientService clientService;

    @Override
    public void initialize(EmailUnalterableValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(ClientDto dto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Client client = clientService.findByEmail(dto.getEmail());

        if(!client.checkEmailEquals(dto.getEmail())) {
            list.add(new FieldMessage(Constants.EMAIL, Constants.EMAIL_UNALTERABLE));
        }

        Util.addInContext(context, list);

        return list.isEmpty();
    }
}
