package com.stackroute.squad.services;


import com.stackroute.squad.domain.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {
  public ServiceProvider save(ServiceProvider serviceProvider);

  public List<ServiceProvider> getAllServiceProvider();

  public ServiceProvider deleteServiceProvider(int id);

  public ServiceProvider updateServiceProvider(ServiceProvider serviceProvider);

}
