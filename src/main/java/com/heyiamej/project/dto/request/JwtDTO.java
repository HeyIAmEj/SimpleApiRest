package com.heyiamej.project.dto.request;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtDTO implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String email;
    private String senha;

}