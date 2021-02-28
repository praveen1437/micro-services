package com.microservices.department.service;

import com.microservices.department.entity.Department;
import com.microservices.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    private static Logger LOGGER = LogManager.getLogger(DepartmentService.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        LOGGER.info("########## in department service saveDepartment");
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long id) {
        LOGGER.info("########## in department service getDepartment");
        return departmentRepository.findByDepartmentId(id);
    }
}
