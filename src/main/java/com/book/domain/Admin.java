package com.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Getter
    @Setter
    private int adminId;
    @Getter
    @Setter
    private String password;
}
