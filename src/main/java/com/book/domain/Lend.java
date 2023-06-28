package com.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class Lend implements Serializable {

    @Getter
    @Setter
    private long sernum;

    @Getter
    @Setter
    private long bookId;

    @Getter
    @Setter
    private int readerId;

    @Getter
    @Setter
    private Date lendDate;

    @Getter
    @Setter
    private Date backDate;

//    public void setReaderId(int readerId) {
//        this.readerId = readerId;
//    }
//
//    public void setBookId(long bookId) {
//        this.bookId = bookId;
//    }
//
//    public void setBackDate(Date backDate) {
//        this.backDate = backDate;
//    }
//
//    public void setLendDate(Date lendDate) {
//        this.lendDate = lendDate;
//    }
//
//    public void setSernum(long sernum) {
//        this.sernum = sernum;
//    }
//
//    public int getReaderId() {
//        return readerId;
//    }
//
//    public long getBookId() {
//        return bookId;
//    }
//
//    public Date getBackDate() {
//        return backDate;
//    }
//
//    public Date getLendDate() {
//        return lendDate;
//    }
//
//    public long getSernum() {
//        return sernum;
//    }
}
