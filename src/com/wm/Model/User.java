package com.wm.Model;

public class User {         //javabean，与数据库字段类型一致
    private int id;
    private String account;
    private String password;


    public User(){          //无参构造

    }

    public User(String account,String password)     //注入有参构造
    {
        this.account=account;
        this.password=password;
    }


    //类方法
    public int getId(){return id;}

    public void setId(int id){this.id=id;}

    public String getaccount(){return account;}

    public void setaccount(String account){this.account=account;}

    public String getpassword(){return password;}

    public void setpassword(String password){this.password=password;}
}

