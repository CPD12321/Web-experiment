package com.wm.Model;

public class User {         //javabean�������ݿ��ֶ�����һ��
    private int id;
    private String account;
    private String password;


    public User(){          //�޲ι���

    }

    public User(String account,String password)     //ע���вι���
    {
        this.account=account;
        this.password=password;
    }


    //�෽��
    public int getId(){return id;}

    public void setId(int id){this.id=id;}

    public String getaccount(){return account;}

    public void setaccount(String account){this.account=account;}

    public String getpassword(){return password;}

    public void setpassword(String password){this.password=password;}
}

