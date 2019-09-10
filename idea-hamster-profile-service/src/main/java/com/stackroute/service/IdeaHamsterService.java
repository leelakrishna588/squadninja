package com.stackroute.service;

import com.stackroute.domain.IdeaHamster;
import com.stackroute.dto.IdeaHamsterDto;

public interface IdeaHamsterService {

    /**
     * AbstractMethod to save  IdeaHamster
     */
    IdeaHamster saveIdeaHamster(IdeaHamsterDto provider);

    IdeaHamster getTheProfile(String email);

    IdeaHamster updateTheProfile(IdeaHamster provider);
}
