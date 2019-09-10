package com.stackroute.domain;

import java.util.Date;
import java.util.List;

public class Idea {

    private int id;
    private String title;
    private String description;
    private String duration;
    private String domain;
    private String subDomain;
    private double cost;
    private List<Role> role;
    private String status;
    private Date postedOn;
    private String location;
}
