package com.example.study.model;

public class SearchParam {

    private String account;
    private String email;
    private int page;

    public SearchParam(){}


    // 필요한 부분만 따로 받기도 한다.
    // 생성자를 만드는 데 시간이 많이 든다.
    public SearchParam(String account){
        this.account = account;
    }

    public SerachParam(String account, String email, int page) {
        this.account = acount;
        this.email = email;
        this.page = page;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
