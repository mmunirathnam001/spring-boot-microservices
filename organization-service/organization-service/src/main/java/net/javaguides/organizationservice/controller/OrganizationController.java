package net.javaguides.organizationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entity.Organization;
import net.javaguides.organizationservice.service.OrganizationService;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.AttributedCharacterIterator;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
@Tag(
        name="Organization Service-OrganizationController",
        description = "OrganizationController expose REST APIs for Organization Service"
)
public class OrganizationController {
    private OrganizationService organizationService;

    //Build save Organization REST API
    @PostMapping()
    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to Organization Object in the Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization=  organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
    //Build Get Organization By code REST API
    @GetMapping("{code}")
    @Operation(
            summary = "get Organization REST API",
            description = "Get Organization REST API is used to Organization Object in the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
    OrganizationDto organizationDto= organizationService.getOrganizationByCode(organizationCode);
   return ResponseEntity.ok(organizationDto);
    }


}
