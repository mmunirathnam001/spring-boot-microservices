package net.javaguides.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.OrganizationDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@Log4j2
@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {

    private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeImpl.class);
   private EmployeeRepository employeeRepository;
   //private RestTemplate restTemplate;
    private WebClient webClient;
     private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

       Employee employee= EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee=employeeRepository.save(employee);

       EmployeeDto savedEmployeeDto=EmployeeMapper.mapToEmployeeDot(savedEmployee);

        return savedEmployeeDto;
    }
    @CircuitBreaker(name="${spring.application.name}",fallbackMethod ="getDefaultMethod")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        log.info("inside getEmployeeById() method");
          Employee employee=employeeRepository.findById(employeeId).get();

/*
    ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity
                ("http://localhost:8080/api/departments/ "+ employee.
                getDepartmentCode(),DepartmentDto.class);
        DepartmentDto departmentDto=responseEntity.getBody();*/
    DepartmentDto departmentDto=webClient
            .get()
            .uri("http://localhost:8080/api/departments/"+ employee
         .getDepartmentCode())
         .retrieve()
         .bodyToMono(DepartmentDto.class)
         .block();
       //DepartmentDto DepartmentDto= apiClient.DepartmentDto(employee.getDepartmentCode());
        OrganizationDto organizationDto=webClient.get().
                uri("http://localhost:8090/api/organizations/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDot(employee);

        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
        return apiResponseDto;
    }
    public APIResponseDto getDefaultMethod(Long employeeId, Exception exception){
         LOGGER.info("inside getDefaultMethod() method");
         Employee employee=employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Development");

        EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDot(employee);
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;

    }
}
