package com.stackroute.service;

import com.stackroute.domain.Role;
import com.stackroute.domain.ServiceProvider;
import com.stackroute.dto.ServiceProviderDto;
import com.stackroute.repository.ServiceProviderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class ServiceProviderServiceImpl implements ServiceProviderService{

    private ServiceProviderRepository serviceProviderRepository;
    private RabbitTemplate rabbitTemplate;

    /**
     * Constructor based Dependency injection to inject TrackRepository here
     */
    @Autowired
    public ServiceProviderServiceImpl(ServiceProviderRepository serviceProviderRepository, RabbitTemplate rabbitTemplate) {
        this.serviceProviderRepository = serviceProviderRepository;
        this.rabbitTemplate = rabbitTemplate;
    }


    @Value("${spRegister.rabbitmq.exchange}")
    public String exchange;

    @Value("${spRegister.rabbitmq.routingkey}")
    public String routingkey;

    @Value("${spProfile.rabbitmq.exchange}")
    String profileExchange;

    @Value("${spProfile.rabbitmq.routingkey}")
    String profilRoutingkey;


    @Override
    public ServiceProvider saveServiceProvider(ServiceProviderDto provider)  {

        rabbitTemplate.convertAndSend(exchange, routingkey, provider);

        ServiceProvider sp = new ServiceProvider();
        sp.setName(provider.getUserName());
        sp.setEmail(provider.getEmail());


        return serviceProviderRepository.save(sp);

    }

    @Override
    public ServiceProvider getTheProfile(String email) {

        return serviceProviderRepository.findByEmail(email);
    }

    @Override
    public ServiceProvider updateTheProfile(ServiceProvider provider) {


        ServiceProvider serviceProvider = serviceProviderRepository.findByEmail(provider.getEmail());

        System.out.println(serviceProvider.toString());
        serviceProvider.setName(provider.getName());
        serviceProvider.setMobileNo(provider.getMobileNo());
        serviceProvider.setDomain(provider.getDomain());
        serviceProvider.setSubDomain(provider.getSubDomain());
        serviceProvider.setChargePerHour(provider.getChargePerHour());
        serviceProvider.setCurrentLocation(provider.getCurrentLocation());
        serviceProvider.setPreferredLocation(provider.getPreferredLocation());

        Role role = new Role();
        role.setRoleName(provider.getRole().getRoleName());
        role.setExperience(provider.getRole().getExperience());
        role.setSkills(provider.getRole().getSkills());
        serviceProvider.setRole(role);

        System.out.println(serviceProvider.toString());
        ServiceProvider updateServiceProvider = serviceProviderRepository.save(serviceProvider);
        System.out.println(updateServiceProvider.toString());
        rabbitTemplate.convertAndSend(profileExchange,profilRoutingkey, serviceProvider);
        return updateServiceProvider;
    }
}
