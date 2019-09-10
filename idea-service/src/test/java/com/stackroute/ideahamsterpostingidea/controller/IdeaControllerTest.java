package com.stackroute.ideahamsterpostingidea.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.ideahamsterpostingidea.domain.Idea;
import com.stackroute.ideahamsterpostingidea.domain.Role;
import com.stackroute.ideahamsterpostingidea.exception.GlobalExceptions;
import com.stackroute.ideahamsterpostingidea.service.IdeaService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

/*
 @RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot test features and JUnit
*/
@RunWith(SpringRunner.class)
@WebMvcTest

public class IdeaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Idea idea;
    private Role role;

    /* Create a mock for TrackService*/
    @MockBean
    private IdeaService ideaService;

    /* Inject the mocks as dependencies into TrackController */

    @InjectMocks
    private IdeaController ideaController;

    /* Run this before each test case */

    private List<Idea> list = null;

    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ideaController).setControllerAdvice(new GlobalExceptions()).build();
        //act
        List<String> list1 = new ArrayList<>();
        list1.add("java");
        list1.add("testing");
        idea = new Idea();
        idea.setId("16");
        idea.setTitle("online");
        idea.setDescription("It is an online shopping project");
        idea.setDomain("IT");
        idea.setDuration("six month");
        idea.setCost(5000);
        idea.setSubDomain("software enginner");
        role = new Role();
        role.setExperience("6");
        role.setNoOfPeople("5");
        role.setRole("engineer");
        role.setSkills(list1);
        List<Role> list2 = new ArrayList<>();
        list2.add(role);
        idea.setRole(list2);
        idea.setLocation("banglore");
        idea.setStatus("open");
        DateFormat dft = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        idea.setPostedOn(dateobj);
        list = new ArrayList<>();

    }

    @After
    public void tearDown() {
        this.idea = null;
        this.role = null;
        this.list = null;
    }

    //for saving idea service
    @Test
    public void givenPostMappingUrlShouldReturnTheSavedIdea() throws Exception {
        when(ideaService.save(any())).thenReturn(idea);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/idea")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(idea)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    //for getting an idea by id
    @Test
    public void givenIdShouldGetIdea() throws Exception {
        when(ideaService.getIdeaById(any())).thenReturn(idea);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/idea/16")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(idea)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //for getting an idea by title
    @Test
    public void givenGetUrlShouldGetIdeaByTitle() throws Exception {
        when(ideaService.getIdeaByTitle(anyString())).thenReturn(idea);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ideas/online")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(idea)))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());
    }

    //for getting an idea by location
    @Test
    public void givenGetUrlShouldGetIdeaByLocation() throws Exception {
        when(ideaService.getIdeaByLocation(anyString())).thenReturn(idea);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ideas/banglore")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(idea)))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());
    }

    //for getting list of ideas
    @Test
    public void givenUrlShouldReturnAllIdeas() throws Exception {
        when(ideaService.getAllIdeas()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ideas")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(idea)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //for deleting the idea by id
    @Test
    public void givenIdShouldDeleteIdeaById() throws Exception {
        when(ideaService.deleteIdeaById(any())).thenReturn(idea);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/idea/16")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(idea)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //for deleting the idea by title
    @Test
    public void givenIdShouldDeleteIdeaByTitle() throws Exception {
        when(ideaService.deleteIdeaByTitle(anyString())).thenReturn(idea);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/ideas/banglore")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(idea)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //for updating the idea
    @Test
    public void givenPutMappingUrlAndTrackShouldReturnUpdatedIdea() throws Exception {
        when(ideaService.updateIdea(any())).thenReturn(idea);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/ideas")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(idea)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    //for getting the recent ideas
    @Test
    public void givenUrlShouldReturnAllRecentIdeas() throws Exception {
        when(ideaService.getRecentIdeas()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/recentIdeas")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(idea)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

