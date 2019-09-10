//package com.stackroute.repository;
////
////import static org.junit.Assert.*;
////
////public class IdeaHamsterRepositoryTest {
////
////}
//
//import com.stackroute.domain.Idea;
//import com.stackroute.domain.IdeaHamster;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.management.relation.Role;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
///*
//@RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot test features and JUnit
//*/
//@RunWith(SpringRunner.class)
///*
//Using @DataMongoTest annotation will disable full auto-configuration and instead apply only configuration relevant to MongoDB tests.
//*/
//@DataMongoTest
//public class IdeaHamsterRepositoryTest {
//    /*
//    Used AutoWire by property to inject TrackRepository here
//   */
//    @Autowired
//    private IdeaHamsterRepository ideaHamsterRepository;
//    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(("dd/MM/yyyy"));
//    private IdeaHamster ideaHamster;
//    private Role role;
//    @Before
//    public void setUp() throws Exception {
//          ideaHamster.setEmail("abc");
//          ideaHamster.setName("xyz");
//          ideaHamster.setMobileNo(21221);

//    }
//    @After
//    public void tearDown() throws Exception {
//        ideaHamster = null;
//    }
//    @Test
//    public void givenIdeaShouldSaveIdea() {
//        Assert.assertEquals(ideaHamster, ideaHamsterRepository.save(ideaHamster));
//    }
//    @Test
//    public void givenIdeaDataShouldReturnIdeaProfile() {
//
//        ideaHamster.setEmail("abc");
//        ideaHamster.setName("xyz");
//        ideaHamster.setMobileNo(21221);
//        ideaHamster1 actualResult = ideaHamsterRepository.findAll();
//        Assert.assertNotEquals(ideaHamster, actualResult);
//    }
