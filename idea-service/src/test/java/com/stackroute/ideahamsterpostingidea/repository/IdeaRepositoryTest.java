//package com.stackroute.ideahamsterpostingidea.repository;
//
//import com.stackroute.ideahamsterpostingidea.domain.Idea;
//import com.stackroute.ideahamsterpostingidea.domain.Role;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
///*
// @RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot test features and JUnit
//*/
//@RunWith(SpringRunner.class)
///*
//Using @DataMongoTest annotation will disable full auto-configuration and instead apply only configuration relevant to MongoDB tests.
//*/
//@DataMongoTest
//public class IdeaRepositoryTest {
//  /*
//  Used AutoWire by property to inject TrackRepository here
// */
//  @Autowired
//  private IdeaRepository ideaRepository;
//  private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(("dd/MM/yyyy"));
//  private Idea idea;
//  private Role role;
//
//
//  @Before
//  public void setUp() throws Exception {
//    List<String> list = new ArrayList<>();
//    list.add("java");
//    list.add("html");
//    idea = new Idea();
//    idea.setId("id");
//    idea.setTitle("ecommerce");
//    idea.setDescription("It is an online shopping project");
//    idea.setDomain("IT");
//    idea.setDuration("six month");
//    idea.setCost(50000);
//    idea.setSubDomain("software enginner");
//    role = new Role();
//    role.setExperience("5");
//    role.setNoOfPeople("4");
//    role.setRoleName("ase");
//    role.setSkills(list);
//    List<Role> list1 = new ArrayList<>();
//    list1.add(role);
//    idea.setRole(list1);
//    idea.setLocation("hyderabad");
//    idea.setStatus("close");
//    idea.setPostedBy("sruthi");
//    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//    Date dateobj = new Date();
//    idea.setPostedOn(dateobj);
//
//  }
//
//  @After
//  public void tearDown() throws Exception {
//    idea = null;
//  }
//
//  @Test
//  public void givenIdeaShouldSaveIdea() {
//
//    Assert.assertEquals(idea, ideaRepository.save(idea));
//  }
//
//  @Test
//  public void givenIdeasShouldReturnListOfAllIdeas() {
//    List<String> list = new ArrayList<>();
//    list.add("java");
//    list.add("testing");
//    Idea idea1 = new Idea();
//    idea1.setId("16");
//    idea1.setTitle("java project");
//    idea1.setDescription("It is an shopping project");
//    idea1.setDomain("IT");
//    idea1.setDuration("six month");
//    idea1.setCost(50000);
//    idea1.setSubDomain("software enginner");
//    role = new Role();
//    role.setExperience("5");
//    role.setNoOfPeople("4");
//    role.setRoleName("ase");
//    role.setSkills(list);
//    List<Role> list1 = new ArrayList<>();
//    list1.add(role);
//    idea1.setRole(list1);
//    idea1.setLocation("hyderabad");
//    idea1.setStatus("close");
//    idea1.setPostedBy("sruthi");
//    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//    Date dateobj = new Date();
//    idea1.setPostedOn(dateobj);
//    ideaRepository.save(idea1);
//    List<Idea> list2 = new ArrayList<>();
//    list2.add(idea1);
//    List<Idea> actualResult = ideaRepository.findAll();
//    Assert.assertNotEquals(list2, actualResult);
//  }
//
//  @Test
//  public void givenTrackIdShouldDeleteTrackFailure() {
//    //act
// ideaRepository.deleteById(idea.getId());
//        //assert
//        Assert.assertNotSame(" ", ideaRepository.findById(idea.getId()));
//
// }
//
//
//}
