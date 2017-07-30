package com.ptp.usermanage.pojo;

import java.util.Date;

public class User {

    private String uuid;

    // 用户名
    private String user_name;

    // 密码
    private String password;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 性别，1男性，2女性
    private Integer sex;

    // 出生日期
    private Date birthday;

    // 创建时间
    private Date insert_time;

    // 修改时间
    private Date update_time;

    

    public String getUuid() {
        return uuid;
    }



    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUser_name() {
        return user_name;
    }



    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public Integer getAge() {
        return age;
    }



    public void setAge(Integer age) {
        this.age = age;
    }



    public Integer getSex() {
        return sex;
    }



    public void setSex(Integer sex) {
        this.sex = sex;
    }



    public Date getBirthday() {
        return birthday;
    }



    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



    public Date getInsert_time() {
        return insert_time;
    }



    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }



    public Date getUpdate_time() {
        return update_time;
    }



    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }



    @Override
    public String toString() {
        return "User [uuid=" + uuid + ", userName=" + user_name + ", password=" + password + ", name=" + name
                + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday + ", insert_time=" + insert_time
                + ", update_time=" + update_time + "]";
    }

}
