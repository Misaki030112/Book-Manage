package com.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class ReaderCard implements Serializable{

    @Getter
    @Setter
    private int readerId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String passwd;

    @Getter
    @Setter
    private int cardState;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String role;

}

//    public void setCardState(int cardState) {
//        this.cardState = cardState;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPasswd(String passwd) {
//        this.passwd = passwd;
//    }
//
//    public void setReaderId(int readerId) {
//        this.readerId = readerId;
//    }
//
//    public int getReaderId() {
//        return readerId;
//    }
//
//    public int getCardState() {
//        return cardState;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPasswd() {
//        return passwd;
//    }

