package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.mapper.DepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //Department dto convert into department jpa entity
       Department department= DepartmentMapper.mapToDepartment(departmentDto);

        Department saveddepartment=departmentRepository.save(department);
        DepartmentDto savedDepartment=DepartmentMapper.mapToDepartmentDto(saveddepartment);
        return savedDepartment;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto=DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }
}
