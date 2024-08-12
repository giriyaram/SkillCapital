package com.dl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dl.exception.LeadDeletionException;
import com.dl.exception.LeadNotFoundException;
import com.dl.model.CreateNewLead;
import com.dl.service.LeadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Tag(name = "CRM Application REST APIs for User Resources", description = "- GellALLLeads, GetLeadById, DeleteLeadById, UpdateLead, PostLead")
@RestController
@RequestMapping("api/leads")
public class LeadController {

    @Autowired
    LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @Operation(summary = "Create lead REST API", description = "Create Lead REST API is used to post the data in Database")
    @ApiResponse(responseCode = "200", description = "HTTP Status ok")
    // http://localhost:8081/api/leads/create-lead
    @PostMapping("/create-lead")
    public CreateNewLead createNewLead(@RequestBody CreateNewLead createNewLead) {

        return leadService.createNewLead(createNewLead);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @Operation(summary = "Get all lead REST API", description = "Get All Leads REST API is used get all the lead records from the database")
    @ApiResponse(responseCode = "200", description = "HTTP status ok")
    // http://localhost:8081/api/leads/getAllLead
    @GetMapping("/getAllLead")
    public List<CreateNewLead> getAllLead() {
        return leadService.getAllLeads();
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @Operation(summary = "getLeadById REST API", description = "GetLeadbyId REST API is used to get  single record from Database")
    @ApiResponse(responseCode = "200", description = "HTTP status ok")
    // http://localhost:8081/api/leads/2
    @GetMapping("/{id}")
    public ResponseEntity<CreateNewLead> getLeadById(@PathVariable Integer id) {
        try {
            CreateNewLead lead = leadService.getLeadById(id);
            return ResponseEntity.ok(lead);

        } catch (LeadNotFoundException e) {
            throw e;
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @Operation(summary = "Update Lead REST API", description = "Update Lead REST API is used to put/update the data in Database")
    @ApiResponse(responseCode = "200", description = "HTTP Status OK")
    // http://localhost:8080/api/leads/updateLead
    @PutMapping("updateLead")
    public CreateNewLead upadLead(@RequestBody CreateNewLead createNewLead) {

        return leadService.updateLead(createNewLead);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
	@Operation(summary = "Get the Lead Count REST API", description = "Get the Lead Count REST API is used get count of the leads")
	@ApiResponse(responseCode = "200", description = "HTTP Status OK")
	// http://localhost:8081/api/leads/users/count
	@GetMapping("/leads/count")
	public long countUser() {

		return leadService.countLead();

	}

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
	@Operation(summary = "Get LeadStatus REST API", description = "Get LeadStatus REST API is used to get lead status for the API")
	@ApiResponse(responseCode = "200", description = "HTTP Status OK")
	// http://localhost:8080/api/leads/Opportunity/leadstatus
	// http://localhost:8080/api/leads/WarmLead/leadstatus
	// http://localhost:8080/api/leads/Attempted/leadstatus
	@GetMapping("/{status}/leadstatus")
	public ResponseEntity<Map<String, Object>> getCountAndOrderByStatus(
			@PathVariable("status") CreateNewLead.LeadStatus leadStatus) {

		List<CreateNewLead> orders = leadService.findOrderByStatus(leadStatus);
		int count = orders.size();

		HashMap<String, Object> response = new HashMap<>();
		response.put("count", count);
		response.put("orders", orders);

		return ResponseEntity.ok(response);

	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@Operation(summary = "DeleteLead REST API", description = "DeleteLead REST API is used delete record from database")
	@ApiResponse(responseCode = "200", description = "HTTP Status OK")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLead(@PathVariable Integer id) {

		try {
			leadService.deleteLead(id);
			return ResponseEntity.ok("Lead with ID : " + id + " deleted Succesfully");
		} catch (Exception e) {
			throw new LeadDeletionException("Error deleting lead with Id " + id + " " + e.getMessage());
		}

	}
}
