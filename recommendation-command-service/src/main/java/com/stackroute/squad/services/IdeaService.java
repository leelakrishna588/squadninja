package com.stackroute.squad.services;

import com.stackroute.squad.domain.Idea;


import java.util.List;

public interface IdeaService {
  public Idea save(Idea idea);

  public List<Idea> getAllIdea();

  public Idea deleteIdea(int id);

  public Idea updateIdea(Idea idea);


}
