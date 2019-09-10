package com.stackroute.squad.services;

import com.stackroute.squad.domain.ServiceProvider;
import com.stackroute.squad.dto.IdeaDto;
import com.stackroute.squad.dto.ServiceProviderDto;
import com.stackroute.squad.repository.ServiceProviderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {
  ServiceProviderRepository serviceProviderRepository;

  @Autowired
  public ServiceProviderServiceImpl(ServiceProviderRepository serviceProviderRepository) {
    this.serviceProviderRepository = serviceProviderRepository;
  }

  @Override
  public ServiceProvider save(ServiceProvider serviceProvider) {
    return serviceProviderRepository.save(serviceProvider);
  }

  @RabbitListener(queues = "${spProfile.rabbitmq.queue}")
  public void receive(ServiceProviderDto serviceProviderDto) {
    ServiceProvider serviceProvider = new ServiceProvider();
    serviceProvider.setId(serviceProviderDto.getId());
    serviceProvider.setChargePerHour(serviceProviderDto.getChargePerHour());
    serviceProvider.setDomain(serviceProviderDto.getDomain());
    serviceProvider.setEmail(serviceProviderDto.getEmail());
    serviceProvider.setMobileNo(serviceProviderDto.getMobileNo());
    serviceProvider.setName(serviceProviderDto.getName());
    serviceProvider.setPreferredLocation(serviceProviderDto.getPreferredLocation());
    serviceProvider.setCurrentLocation(serviceProviderDto.getCurrentLocation());
    serviceProviderRepository.save(serviceProvider);
    System.out.println(serviceProviderDto);
  }
  @RabbitListener(queues = "${spUpdate.rabbitmq.queue}")
  public void updatedServiceProvider(ServiceProviderDto serviceProviderDto) {
    ServiceProvider retrievedServiceProvider = serviceProviderRepository.findByEmail(serviceProviderDto.getEmail());
    retrievedServiceProvider.setId(serviceProviderDto.getId());
    retrievedServiceProvider.setChargePerHour(serviceProviderDto.getChargePerHour());
    retrievedServiceProvider.setDomain(serviceProviderDto.getDomain());
    retrievedServiceProvider.setMobileNo(serviceProviderDto.getMobileNo());
    retrievedServiceProvider.setName(serviceProviderDto.getName());
    retrievedServiceProvider.setPreferredLocation(serviceProviderDto.getPreferredLocation());
    retrievedServiceProvider.setCurrentLocation(serviceProviderDto.getCurrentLocation());
    serviceProviderRepository.save(retrievedServiceProvider);
   serviceProviderRepository.findByRoles(serviceProviderDto.getEmail(),serviceProviderDto.getRolesDto().getRoleName());
    for (int i = 0; i < serviceProviderDto.getRolesDto().getSkills().size(); i++) {
   serviceProviderRepository.findBySkills(serviceProviderDto.getEmail(),serviceProviderDto.getRolesDto().getSkills().get(i));}
    IdeaDto ideaDto=new IdeaDto();
    serviceProviderRepository.createRelation(serviceProviderDto.getEmail(),ideaDto.getTitle());
    System.out.println(serviceProviderDto);
  }



  @Override
  public List<ServiceProvider> getAllServiceProvider() {
    List<ServiceProvider> allServiceProviders = (List<ServiceProvider>) serviceProviderRepository.findAll();
    return allServiceProviders;

  }

  @Override
  public ServiceProvider deleteServiceProvider(int id) {
    ServiceProvider retrivedServiceProvider = serviceProviderRepository.findById(id);
    serviceProviderRepository.deleteById(id);
    return retrivedServiceProvider;

  }

  @Override
  public ServiceProvider updateServiceProvider(ServiceProvider serviceProvider) {
    ServiceProvider updateServiceProvider = serviceProviderRepository.save(serviceProvider);
    return updateServiceProvider;

  }
}
