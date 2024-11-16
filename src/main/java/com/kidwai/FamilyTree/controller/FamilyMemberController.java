package com.kidwai.FamilyTree.controller;

import com.kidwai.FamilyTree.model.FamilyMember;
import com.kidwai.FamilyTree.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/family")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberService familyMemberService;

    // Get all family members
    @GetMapping
    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberService.getAllFamilyMembers();
    }

    // Get a specific family member
    @GetMapping("/{id}")
    public Optional<FamilyMember> getFamilyMember(@PathVariable Long id) {
        return familyMemberService.getFamilyMemberById(id);
    }

    // Add new family member
    @PostMapping
    public FamilyMember addFamilyMember(@RequestBody FamilyMember familyMember) {
        return familyMemberService.addFamilyMember(familyMember);
    }

    // Update family member
    @PutMapping("/{id}")
    public FamilyMember updateFamilyMember(@PathVariable Long id, @RequestBody FamilyMember familyMember) {
        return familyMemberService.updateFamilyMember(id, familyMember);
    }

    // Delete family member
    @DeleteMapping("/{id}")
    public boolean deleteFamilyMember(@PathVariable Long id) {
        return familyMemberService.deleteFamilyMember(id);
    }
}