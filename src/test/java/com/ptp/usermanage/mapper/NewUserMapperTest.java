package com.ptp.usermanage.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.abel533.entity.Example;
import com.ptp.usermanage.pojo.User;

public class NewUserMapperTest {
    
    private NewUserMapper newUserMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        this.newUserMapper = applicationContext.getBean(NewUserMapper.class);
    }

    @Test
    public void testSelectOne() {
        User record = new User();
        //设置查询条件
        record.setUserName("zhangsan");
        record.setPassword("123456");
        User user=this.newUserMapper.selectOne(record);
        System.out.println(user);
    }

    @Test
    public void testSelect() {
        List<User> list=this.newUserMapper.select(null);
        for(User user:list){
            System.out.println(user);
        }
    }

    @Test
    public void testSelectCount() {
        System.out.println(this.newUserMapper.selectCount(null));
    }

    @Test
    public void testSelectByPrimaryKey() {
        User user = this.newUserMapper.selectByPrimaryKey("1");
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        User record = new User();
        //设置查询条件
        record.setUuid("7");
        record.setUserName("test_username_1");
        record.setName("test_username_1");
        record.setPassword("123456");
        record.setSex(1);
        record.setAge(20);
        record.setBirthday(new Date());
        record.setInsert_time(new Date());
        record.setUpdate_time(new Date());
        //使用所有的字段作为插入语句的字段
        int count =this.newUserMapper.insert(record);
        System.out.println(count);
    }

    @Test
    public void testInsertSelective() {
        User record = new User();
        //设置查询条件
        record.setUuid("8");
        record.setUserName("test_username_2");
        //record.setName("test_username_2");
        //record.setPassword("123456");
        record.setSex(1);
        //record.setAge(20);
        //record.setBirthday(new Date());
        record.setInsert_time(new Date());
        record.setUpdate_time(new Date());
        //将不为null的字段作为插入语句的字段
        int count =this.newUserMapper.insertSelective(record);
        System.out.println(count);
    }

    @Test
    public void testDelete() {
        //this.newUserMapper.delete(null);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        System.out.println(this.newUserMapper.deleteByPrimaryKey("8"));
    }

    @Test
    public void testUpdateByPrimaryKey() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        User record = new User();
        record.setUuid("1");
        record.setAge(20);
        this.newUserMapper.updateByPrimaryKeySelective(record);
    }

    @Test
    public void testSelectCountByExample() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteByExample() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectByExample() {
        Example example = new Example(User.class);
        List<Object> values = new ArrayList<Object>();
        values.add("1");
        values.add("2");
        values.add("3");
        //SELECT PASSWORD,UPDATE_TIME,BIRTHDAY,USER_NAME USERNAME,AGE,NAME,INSERT_TIME,SEX,UUID FROM ptp_base_user WHERE ( UUID in(?,?,?) ) 
        example.createCriteria().andIn("uuid",values);
        List<User> list=this.newUserMapper.selectByExample(example);
        for(User user:list){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateByExampleSelective() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateByExample() {
        fail("Not yet implemented");
    }

}
