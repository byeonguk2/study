package hello.core.member;

import lombok.Data;

@Data
public class Member {

    private Long id;
    private String name;
    private Grade grade;

}
