package br.com.like.validations;

import br.com.like.annotations.CpfValidation;
import br.com.like.constants.Constants;
import br.com.like.domains.Client;
import br.com.like.dtos.ClientDto;
import br.com.like.exceptions.models.FieldMessage;
import br.com.like.services.ClientService;
import br.com.like.utils.CpfUtil;
import br.com.like.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CpfValidator implements ConstraintValidator<CpfValidation, ClientDto> {

    @Autowired
    private ClientService clientService;

    @Override
    public void initialize(CpfValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(final ClientDto dto, final ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        checkCpfFormat(dto, list);

        checkIfCpfIsAvailable(dto, list);

        Util.addInContext(context, list);

        return list.isEmpty();
    }

    private void checkIfCpfIsAvailable(final ClientDto dto, final List<FieldMessage> list) {
        Client client = clientService.findByCpf(dto.getCpf());

        if (client != null) {
            list.add(new FieldMessage(Constants.CPF, Constants.CPF_UNAVALIBLE));
        }
    }

    private void checkCpfFormat(final ClientDto dto, final List<FieldMessage> list) {
        if (!CpfUtil.isValidCPF(dto.getCpf())) {
            list.add(new FieldMessage(Constants.CPF, Constants.CPF_INVALID));
        }
    }


}
