//package com.stackroute.userloginservice.service;
//
//import com.stackroute.userloginservice.domain.User;
//import com.stackroute.userloginservice.repository.UserRepository;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//
//public class UserServiceImplTest {
//
//    @Autowired
//    private UserRepository userRepository;
//    private User user;
//
//    @Before
//    public void setUp() throws Exception {
//
//        user=new User();
//        user.setEmailId("abc@gmail.com");
//        user.setPassword("password");
//        userRepository.save(user);
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void findByEmailIdAndPassword() {
//        User user1=userRepository.findByEmailIdAndPassword("abc@gmail.com","password");
//        Assert.assertEquals("abc@gmail.com",user1.getEmailId());
//        Assert.assertEquals("password",user1.getPassword());
//    }
//
//    @Test
//    public void recievedMessage() {
//    }
//
//    @Test
//    public void recieveMessage() {
//    }
//}