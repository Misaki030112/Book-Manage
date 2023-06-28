package com.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class ReaderInfo implements Serializable{
    @Getter
    @Setter
    private int readerId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String sex;

    @Getter
    @Setter
    private Date birth;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String telcode;

    @Getter
    @Setter
    private String password;
//    public void setName(String name) {
//        this.name = name;
//    }

//    public void setReaderId(int readerId) {
//        this.readerId = readerId;
//    }

//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public void setBirth(Date birth) {
//        this.birth = birth;
//    }

//    public void setTelcode(String telcode) {
//        this.telcode = telcode;
//    }

//    public String getName() {
//        return name;
//    }

//    public int getReaderId() {
//        return readerId;
//    }
//
//    public Date getBirth() {
//        return birth;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public String getTelcode() {
//        return telcode;
//    }
}
