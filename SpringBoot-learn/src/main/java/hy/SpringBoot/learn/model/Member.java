package hy.SpringBoot.learn.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    private Long id;
    private String name;
}
