package com.heima.pojo;

public class Account {

    private int id;
    private String name;
    private int money;

    //get 和 set 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //为了方便查看 ，toString()

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name='" + name + '\'' + ", money=" + money + '}';
    }
}
