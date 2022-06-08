package com.ba.domain;

//lombok

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//3
//@Getter
//@Setter
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

}
