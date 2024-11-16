package com.kidwai.FamilyTree.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private FamilyMember parent;

    @OneToMany(mappedBy = "parent")
    private List<FamilyMember> children;

    @OneToOne
    @JoinColumn(name = "spouse_id")
    private FamilyMember spouse;

    public FamilyMember() {
    }

    public FamilyMember(Long id, String name, FamilyMember parent, List<FamilyMember> children, FamilyMember spouse) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.children = children;
        this.spouse = spouse;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FamilyMember getParent() {
        return parent;
    }

    public void setParent(FamilyMember parent) {
        this.parent = parent;
    }

    public List<FamilyMember> getChildren() {
        return children;
    }

    public void setChildren(List<FamilyMember> children) {
        this.children = children;
    }

    public FamilyMember getSpouse() {
        return spouse;
    }

    public void setSpouse(FamilyMember spouse) {
        this.spouse = spouse;
    }

}
