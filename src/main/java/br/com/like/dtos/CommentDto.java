package br.com.like.dtos;

import br.com.like.domains.Comment;
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
public class CommentDto {

    private Integer star;
    private String title;
    private String description;
    private UserDto user;

    public static List<CommentDto> convertList(final List<Comment> comments) {
        return comments
                .stream()
                .map(comment -> new CommentDto(comment.getStar(), comment.getTitle(), comment.getDescription(), UserDto.fromDto(comment.getUser())))
                .collect(Collectors.toList());
    }
}
