package br.com.like.dtos;

import br.com.like.domains.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private String description;

    public static List<QuestionDto> convertList(final List<Question> questions) {
        return questions
                .stream()
                .map(question -> new QuestionDto(question.getDescription()))
                .collect(Collectors.toList());
    }
}
