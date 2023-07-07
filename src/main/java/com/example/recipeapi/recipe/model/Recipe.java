package com.example.recipeapi.recipe.model;

import com.example.recipeapi.base.model.AuditablePersistentObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Entity
@Table(name = "recipe", schema = "mendix")
public class Recipe extends AuditablePersistentObject {
    @Column(name="recipe_name")
    private String recipeName;
}
