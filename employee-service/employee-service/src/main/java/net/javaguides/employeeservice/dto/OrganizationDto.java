package net.javaguides.employeeservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {

    private long id;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private LocalDateTime createDate;

}
