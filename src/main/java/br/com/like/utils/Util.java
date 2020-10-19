package br.com.like.utils;

import br.com.like.exceptions.models.FieldMessage;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ConstraintValidatorContext;
import java.net.URI;
import java.util.List;

public class Util {

    public static void addInContext(final ConstraintValidatorContext context, final List<FieldMessage> list) {
        list.stream()
                .forEach(item -> {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(item.getMessage())
                            .addPropertyNode(item.getFieldName())
                            .addConstraintViolation();
                });
    }

    public static URI getUri(final Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(id)
                .toUri();
    }
}
