package br.com.like.dtos;

import br.com.like.annotations.CpfValidation;
import br.com.like.annotations.EmailValidation;

@CpfValidation
@EmailValidation
public class ClientNewDto extends ClientDto {

}
