package com.stackroute.squad.services;

import com.stackroute.squad.domain.Roles;

import java.util.List;

public interface RolesService {
  public Roles save(Roles roles);

  public List<Roles> getAllRoles();

  public Roles deleteRoles(int id);

  public Roles updateRoles(Roles roles);
}
