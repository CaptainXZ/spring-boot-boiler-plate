#!/bin/bash

# Check if the correct number of arguments are provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <EntityName>"
    exit 1
fi

ENTITY_NAME=$1
PACKAGE="com.example.demo" # Adjust this to your base package
DIRECTORY="src/main/java/com/example/demo" # Adjust this to your base directory

# Create directories if they don't exist
mkdir -p $DIRECTORY/controllers
mkdir -p $DIRECTORY/services
mkdir -p $DIRECTORY/repository
mkdir -p $DIRECTORY/models

# Generate Model
cat <<EOL > $DIRECTORY/models/${ENTITY_NAME}.java
package $PACKAGE.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ${ENTITY_NAME} {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add your fields here
    private String name;

    // Getters and setters
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
}
EOL

# Generate Controller
cat <<EOL > $DIRECTORY/controllers/${ENTITY_NAME}Controller.java
package $PACKAGE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import $PACKAGE.services.${ENTITY_NAME}Service;
import $PACKAGE.models.${ENTITY_NAME};

@RestController
@RequestMapping("/api/${ENTITY_NAME,,}s")
public class ${ENTITY_NAME}Controller {

    @Autowired
    private ${ENTITY_NAME}Service ${ENTITY_NAME,,}Service;

    @GetMapping
    public List<${ENTITY_NAME}> getAll() {
        return ${ENTITY_NAME,,}Service.getAll();
    }

    @PostMapping
    public ${ENTITY_NAME} create(@RequestBody ${ENTITY_NAME} ${ENTITY_NAME,,}) {
        return ${ENTITY_NAME,,}Service.create(${ENTITY_NAME,,});
    }

    @GetMapping("/{id}")
    public ${ENTITY_NAME} getById(@PathVariable Long id) {
        return ${ENTITY_NAME,,}Service.getById(id);
    }

    @PutMapping("/{id}")
    public ${ENTITY_NAME} update(@PathVariable Long id, @RequestBody ${ENTITY_NAME} ${ENTITY_NAME,,}) {
        return ${ENTITY_NAME,,}Service.update(id, ${ENTITY_NAME,,});
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ${ENTITY_NAME,,}Service.delete(id);
    }
}
EOL

# Generate Service
cat <<EOL > $DIRECTORY/services/${ENTITY_NAME}Service.java
package $PACKAGE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import $PACKAGE.repository.${ENTITY_NAME}Repository;
import $PACKAGE.models.${ENTITY_NAME};

@Service
public class ${ENTITY_NAME}Service {

    @Autowired
    private ${ENTITY_NAME}Repository ${ENTITY_NAME,,}Repository;

    public List<${ENTITY_NAME}> getAll() {
        return ${ENTITY_NAME,,}Repository.findAll();
    }

    public ${ENTITY_NAME} create(${ENTITY_NAME} ${ENTITY_NAME,,}) {
        return ${ENTITY_NAME,,}Repository.save(${ENTITY_NAME,,});
    }

    public ${ENTITY_NAME} getById(Long id) {
        return ${ENTITY_NAME,,}Repository.findById(id).orElse(null);
    }

    public ${ENTITY_NAME} update(Long id, ${ENTITY_NAME} ${ENTITY_NAME,,}) {
        ${ENTITY_NAME,,}.setId(id);
        return ${ENTITY_NAME,,}Repository.save(${ENTITY_NAME,,});
    }

    public void delete(Long id) {
        ${ENTITY_NAME,,}Repository.deleteById(id);
    }
}
EOL

# Generate Repository
cat <<EOL > $DIRECTORY/repository/${ENTITY_NAME}Repository.java
package $PACKAGE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import $PACKAGE.models.${ENTITY_NAME};

public interface ${ENTITY_NAME}Repository extends JpaRepository<${ENTITY_NAME}, String> {
}
EOL

echo "Model, Controller, Service, and Repository for ${ENTITY_NAME} created successfully."
