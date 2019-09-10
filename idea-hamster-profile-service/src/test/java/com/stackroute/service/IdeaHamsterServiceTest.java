//package com.stackroute.service;
//
//import com.stackroute.dto.IdeaHamsterDto;
//import com.stackroute.repository.IdeaHamsterRepository;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class IdeaHamsterServiceTest {
//    private IdeaHamsterDto ideaHamsterDto;
//
//
//    /**
//     * Create a mock for TrackRepository
//     */
//    @Mock
//    private IdeaHamsterRepository ideaHamsterRepository;
//
//    /**
//     * Inject the mocks as dependencies into TrackServiceImplements
//     */
//    @InjectMocks
//    IdeaHamsterServiceImpl ideaHamsterService;
//
//    /**
//     * Run this before each test case
//     */
//    @Before
//    public void setUp() {
//        //Initialising the mock object
//        MockitoAnnotations.initMocks(this);
//        ideaHamsterDto = new IdeaHamsterDto();
//        ideaHamsterDto.setEmail("shivp017");
//        ideaHamsterDto.setUserName("shiv");
//        ideaHamsterDto.getRole();
//
//    }
//
//    @After
//    public void tearDown() {
//        this.ideaHamsterDto = null;
//
//    }
////
////    @Test
////    public void givenIdeahamsterToSaveShouldReturnSavedTrack() throws UserAlreadyFoundException {
////        //act
////        when(ideaHamsterRepository.save((IdeaHamsterDto) any())).thenReturn(ideaHamsterDto);
////        IdeaHamster savedUser = ideaHamsterService.saveIdeaHamster(IdeaHamsterDto);
////        //assert
////        Assert.assertEquals(ideaHamsterDto, savedUser);
////
////        //verify here verifies that trackRepository save method is only called once
////        verify(ideaHamsterRepository, times(1)).save(ideaHamsterDto);
////    }
//}