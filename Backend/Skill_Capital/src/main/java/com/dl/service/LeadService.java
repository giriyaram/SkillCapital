package com.dl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.exception.LeadNotFoundException;
import com.dl.model.CreateNewLead;
import com.dl.repository.LeadRepository;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    // create record
    public CreateNewLead createNewLead(CreateNewLead createNewLead) {
        return leadRepository.save(createNewLead);
    }

    // Get records
    public List<CreateNewLead> getAllLeads() {
        return leadRepository.findAll();
    }

    // Find by id
    public CreateNewLead getLeadById(Integer id) {

        return leadRepository.findById(id)
                .orElseThrow(() -> new LeadNotFoundException("Lead with ID " + id + " not found"));

    }

    // update ID
    public CreateNewLead updateLead(CreateNewLead createNewLead){

        return leadRepository.save(createNewLead);
    }

    // count by status
    public long countLead(){
        return leadRepository.count();
    }

    // status
    public List<CreateNewLead> findOrderByStatus(CreateNewLead.LeadStatus leadStatus){
        return leadRepository.findByLeadStatus(leadStatus);
    }

    // delete
    public void deleteLead(Integer id){
        leadRepository.deleteById(id);
    }
}
