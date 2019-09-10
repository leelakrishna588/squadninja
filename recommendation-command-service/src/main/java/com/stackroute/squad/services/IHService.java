package com.stackroute.squad.services;

import com.stackroute.squad.domain.IdeaHamster;

import java.util.List;

public interface IHService {
  public IdeaHamster save(IdeaHamster ideaHamster);

  public List<IdeaHamster> getAllIdeaHamster();

  public IdeaHamster deleteIdeaHamster(int id);

  public IdeaHamster updateIdeaHamster(IdeaHamster ideaHamster);


}
