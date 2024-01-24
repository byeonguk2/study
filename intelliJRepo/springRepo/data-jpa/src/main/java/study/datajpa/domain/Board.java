package study.datajpa.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Board {

    private Long id;
    private String title;
    private String writer;
    private String content;

}
