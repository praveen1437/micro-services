package com.microservices.userservice.service;

import com.microservices.userservice.VO.Department;
import com.microservices.userservice.VO.RestTemplateVO;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user) {
        log.info("######### in UserService saveUser");
        return userRepository.save(user);
    }

    public RestTemplateVO getUserWithDepartment(Long userId) {
        log.info("######### in UserService getUserWithDepartment");
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        RestTemplateVO restTemplateVO = new RestTemplateVO();
        restTemplateVO.setUser(user);
        restTemplateVO.setDepartment(department);
        return restTemplateVO;

    }
}
