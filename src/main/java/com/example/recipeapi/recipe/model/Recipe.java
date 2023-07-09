package com.example.recipeapi.recipe.model;

import com.example.recipeapi.base.model.AuditablePersistentObject;
import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.ingredient.model.RecipeIngredient;
import jakarta.persistence.*;
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
@Table(name = "recipe", schema = "mendix")
public class Recipe extends AuditablePersistentObject {
    @Column(name="recipe_name")
    private String recipeName;
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private Set<RecipeIngredient> recipeIngredients;
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private Set<Category> categories;
}
