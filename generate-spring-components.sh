#!/bin/bash

# Function to create a Java class file with given content
create_file() {
    local path=$1
    local content=$2
    echo "$content" > "$path"
    echo "Created $path"
}

# Base directory for your project
BASE_DIR="/Users/phatsopheak/Documents/Spring Boot/06-07-2024/Homework/src/main/java/com/example/demo"

# Names of the folders
FOLDERS=("controllers" "services" "repository" "models")

# Lombok annotations for models
LOMBOK_ANNOTATIONS=("Getter" "Setter")

# Template for controller
CONTROLLER_TEMPLATE=$(cat <<END
package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/{name_lower}")
public class {name}Controller {

    // Define your endpoints here

}
END
)

# Template for service
SERVICE_TEMPLATE=$(cat <<END
package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class {name}Service {

    // Define your service methods here

}
END
)

# Template for repository
REPOSITORY_TEMPLATE=$(cat <<END
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.{name};

@Repository
public interface {name}Repository extends JpaRepository<{name}, String> {

    // Define your query methods here

}
END
)

# Template for model
MODEL_TEMPLATE=$(cat <<END
package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class {name} {

    @Id
    private UUID id;

    // Define your fields here

}
END
)

# Function to generate component
generate_component() {
    local name=$1
    local name_capitalized="$(echo $name | awk '{print toupper(substr($0, 1, 1)) substr($0, 2)}')"
    local name_lower="$(echo $name | awk '{print tolower($0)}')"

    for folder in "${FOLDERS[@]}"; do
        dir_path="$BASE_DIR/$folder"
        mkdir -p "$dir_path"

        case "$folder" in
            "controllers")
                content=$(echo "$CONTROLLER_TEMPLATE" | sed "s/{name}/$name_capitalized/g; s/{name_lower}/$name_lower/g")
                create_file "$dir_path/${name_capitalized}Controller.java" "$content"
                ;;
            "services")
                content=$(echo "$SERVICE_TEMPLATE" | sed "s/{name}/$name_capitalized/g")
                create_file "$dir_path/${name_capitalized}Service.java" "$content"
                ;;
            "repository")
                content=$(echo "$REPOSITORY_TEMPLATE" | sed "s/{name}/$name_capitalized/g")
                create_file "$dir_path/${name_capitalized}Repository.java" "$content"
                ;;
            "models")
                content=$(echo "$MODEL_TEMPLATE" | sed "s/{name}/$name_capitalized/g")
                create_file "$dir_path/${name_capitalized}.java" "$content"
                ;;
            *)
                echo "Unknown folder: $folder"
                ;;
        esac
    done
}

# Main script starts here
# Prompt user for component name
read -p "Enter the name of the component: " component_name

# Generate the component
generate_component "$component_name"
