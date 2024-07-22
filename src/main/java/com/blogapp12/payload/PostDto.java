package com.blogapp12.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class PostDto {

    private long id;
    @NotEmpty
    @Size(min =3,message = "Title is should be Atlest 3 Charaterr in Dto Class")
    private String title;
    @NotEmpty
    @Size(min = 3, message = "min 3 Charater" )
    private String description;
    private String content;
    @Size
    private String email;


}

