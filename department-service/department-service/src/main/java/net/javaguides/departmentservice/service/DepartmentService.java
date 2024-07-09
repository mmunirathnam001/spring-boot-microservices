package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.dto.DepartmentDto;
import org.springframework.stereotype.Service;


public interface DepartmentService {

             DepartmentDto saveDepartment(DepartmentDto departmentDto);
            DepartmentDto getDepartmentByCode(String code);

}
