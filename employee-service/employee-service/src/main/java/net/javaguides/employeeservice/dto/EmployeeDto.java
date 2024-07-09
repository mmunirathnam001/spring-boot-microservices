package net.javaguides.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "EmployeeDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    @Schema(
            description = "Employee First Name"
    )
    private String firstName;
    @Schema(
            description = "Employee Last Name"
    )
    private String lastName;
    @Schema(
            description = "Employee Email Address"
    )
    private String email;
    @Schema(
            description = "Employees' s Department Code"
    )
    private String departmentCode;
    @Schema(
            description = "Employees' s Organization Code"
    )
    private String organizationCode;
}
