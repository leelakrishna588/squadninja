//package com.stackroute.userloginservice.controller;
//
//import com.stackroute.userloginservice.domain.User;
//import com.stackroute.userloginservice.exception.EmailIdNotFoundException;
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
//@RunWith(SpringRunner.class)
//@SpringBootTest
//
//public class UserControllerTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private User user;
//
//    @Before
//    public void setUp() throws Exception {
//        user=new User();
//        user.setEmailId("prerna@gmail.com");
//        user.setPassword("pass@%");
//        userRepository.save(user);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void loginTest() {
//        User user1=userRepository.findByEmailIdAndPassword("prerna@gmail.com","pass@%");
//        Assert.assertEquals("prerna@gmail.com",user1.getEmailId());
//        Assert.assertEquals("pass@%",user1.getPassword());
//    }
//
////    @Test
////    public void loginFailTest() throws EmailIdNotFoundException {
//////        ResponseEntity responseEntity=null;
//////        try {
////            User user1 = userRepository.findByEmailIdAndPassword("abc@gmail.com", "pass@%");
////
////            Assert.assertNotEquals("abc@gmail.com", user1.getEmailId());
//////        }
//////        catch (EmailIdNotFoundException e) {
//////            responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//////            e.getMessage();
//////        }
//////        Assert.assertEquals("pass@%",user1.getPassword());
////    }
//
//
//}