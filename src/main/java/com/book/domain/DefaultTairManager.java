package com.book.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultTairManager {
    private Arrays keyArrays;

    public void setConfigServeList(ArrayList<String> configList) {
    }

    public void setTimeOut(int time) {
    }

    public void setCharset(String charset) {
    }

    public void setGroupName(String groupTest) {
    }

    public void init() {
    }

    public void put(int namespace, String key, String value, int version,int expertTime) {
    }

    public void put(int namespace, String key, String value, int version) {
    }

    public void put(int namespace, String key, String value) {
    }

    public void put(int namespace, String key, ArrayList<Book> value) {
    }

    public Result get(int namespace, String key) {
        return new Result();
    }

    public void delete(int namespace, String key) {
    }

    public void mget(int namespace, Arrays keyArrays) {
        this.keyArrays = keyArrays;
    }

    public void mdelete(int namespace, Arrays keyArrays) {
    }

    public void incr(int namespace, String key, int value, int defaultValue, int version) {
    }

    public void lock(int namespace, String key) {
    }

    public void unlock(int namespace, String key) {
    }

    public void invalid(int namespace, String key) {
    }
}
