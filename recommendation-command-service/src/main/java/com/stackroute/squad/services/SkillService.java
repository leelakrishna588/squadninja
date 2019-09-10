package com.stackroute.squad.services;

import com.stackroute.squad.domain.IdeaHamster;
import com.stackroute.squad.domain.Skills;

import java.util.List;

public interface SkillService {
  public Skills save(Skills skills);

  public List<Skills> getAllSkills();

  public Skills deleteSkills(int id);

  public Skills updateSkills(Skills skills);

}
