package com.ba.domain;

//lombok

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//pushtest
//@Getter
//@Setter
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
    //

}
