package com.example.recipeapi.ingredient.model;


import com.example.recipeapi.base.model.AuditablePersistentObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Entity
@Table(name = "ingredient", schema = "mendix")
public class Ingredient extends AuditablePersistentObject {
    @Column(name="ingredient_name")
    private String ingredientName;
    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredient> recipeIngredients;

}
