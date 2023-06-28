package com.book.domain;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable{

    @Getter
    @Setter
    private long bookId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String author;

    @Getter
    @Setter
    private String publish;

    @Getter
    @Setter
    private String isbn;

    @Getter
    @Setter
    private String introduction;

    @Getter
    @Setter
    private String language;

    @Getter
    @Setter
    private BigDecimal price;

    @Getter
    @Setter
    private Date pubdate;

    @Getter
    @Setter
    private int classId;

    @Getter
    @Setter
    private int pressmark;

    @Getter
    @Setter
    private int state;

}
