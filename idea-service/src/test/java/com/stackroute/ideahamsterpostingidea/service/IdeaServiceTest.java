package com.stackroute.ideahamsterpostingidea.service;

import com.stackroute.ideahamsterpostingidea.domain.Idea;
import com.stackroute.ideahamsterpostingidea.domain.Role;
import com.stackroute.ideahamsterpostingidea.exception.IdeaNotFoundException;
import com.stackroute.ideahamsterpostingidea.repository.IdeaRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class IdeaServiceTest {
  private Idea idea;
  private List<Idea> expectedIdeas;
  private Role role;
  /*
    Create a mock for TrackRepository
 */
  @Mock
  IdeaRepository ideaRepository;
  /*
   Inject the mocks as dependencies into TrackServiceImplements
 */
  @InjectMocks
  IdeaServiceImpl ideaServiceimplements;

  /*
   * Run this before each test case
   */
  @Before
  public void setUp() {
    //Initialising the mock object
    MockitoAnnotations.initMocks(this);
    idea = new Idea();
    List<String> list = new ArrayList<>();
    list.add("java");
    list.add("testing");
    idea.setId("16");
    idea.setTitle("java project");
    idea.setDescription("It is an shopping project");
    idea.setDomain("IT");
    idea.setDuration("four month");
    idea.setCost(50000);
    idea.setSubDomain("software enginner");
    role = new Role();
    role.setExperience("4");
    role.setNoOfPeople("3");
    role.setRole("se");
    role.setSkills(list);
    List<Role> list1 = new ArrayList<>();
    list1.add(role);
    idea.setRole(list1);
    idea.setLocation("banglore");
    idea.setStatus("open");
    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Date dateobj = new Date();
    idea.setPostedOn(dateobj);
    idea.setPostedBy("sruthi");
    expectedIdeas = new ArrayList<>();
  }

  @After
  public void tearDown() {
    this.idea = null;
    this.expectedIdeas = null;
    this.role = null;
  }

  //get the idea by id
  @Test
  public void givenIdShouldReturnIdea() throws IdeaNotFoundException {
    ideaRepository.save(idea);
    when(ideaRepository.existsById("id")).thenReturn(true);
    when(ideaRepository.findById("id")).thenReturn(java.util.Optional.ofNullable((idea)));
    Idea getIdea = ideaServiceimplements.getIdeaById("id");
    Assert.assertEquals(idea, getIdea);
    verify(ideaRepository, Mockito.times(1)).findById("id");
  }

  //get the idea by title
  @Test
  public void givenTitleShouldGetIdea() throws IdeaNotFoundException {
    ideaRepository.save(idea);
    when(ideaRepository.findByTitle("java project")).thenReturn(idea);
    Idea getByTitle = ideaServiceimplements.getIdeaByTitle("java project");
    Assert.assertEquals(idea, getByTitle);
    verify(ideaRepository, Mockito.times(1)).findByTitle("java project");

  }
//get the idea by location

  @Test
  public void getIdeaByLocation() throws IdeaNotFoundException {
    ideaRepository.save(idea);
    when(ideaRepository.findByLocation("banglore")).thenReturn(idea);
    Idea getByLocation = ideaServiceimplements.getIdeaByLocation("banglore");
    verify(ideaRepository, Mockito.times(1)).findByLocation("banglore");
  }

  //get the list of ideas
  @Test
  public void getAllIdeas() throws Exception {
    ideaRepository.save(idea);
    when(ideaRepository.findAll()).thenReturn(expectedIdeas);
    List<Idea> ideaList = ideaServiceimplements.getAllIdeas();
    Assert.assertEquals(expectedIdeas, ideaList);
    verify(ideaRepository, Mockito.times(1)).findAll();
  }

  //deleting the idea by id
  @Test
  public void deleteIdeaById() throws IdeaNotFoundException {
    ideaRepository.save(idea);
    when(ideaRepository.existsById("id")).thenReturn(true);
    when(ideaRepository.findById("id")).thenReturn(java.util.Optional.ofNullable(idea));
    Idea deleteIdea = ideaServiceimplements.deleteIdeaById("id");
    Assert.assertEquals(idea, deleteIdea);
    verify(ideaRepository, Mockito.times(1)).findById("id");
  }

  //deleting the idea by title
  @Test
  public void givenTitleShouldDeleteIdea() throws IdeaNotFoundException {
    ideaRepository.save(idea);
    when(ideaRepository.findByTitle("java project")).thenReturn(idea);
    Idea deleteIdeaByTitle = ideaServiceimplements.deleteIdeaByTitle("java project");
    Assert.assertEquals(idea, deleteIdeaByTitle);
    verify(ideaRepository, Mockito.times(1)).findByTitle("java project");
  }

  //getting the recent ideas which are posted
  @Test
  public void givenDateShouldGetRecentIdeas() {
    ideaRepository.save(idea);
    when(ideaRepository.findByTitle("id")).thenReturn((idea));
    List<Idea> recentIdeas = ideaServiceimplements.getRecentIdeas();
    Assert.assertEquals(expectedIdeas, recentIdeas);
    verify(ideaRepository, Mockito.times(1)).findAll(Sort.by(Sort.Direction.DESC, "postedOn"));
  }
}


