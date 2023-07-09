package com.example.recipeapi.ingredient.model;

import com.example.recipeapi.base.model.AuditablePersistentObject;
import com.example.recipeapi.recipe.model.Recipe;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Entity
@Table(name = "recipe_ingredient", schema = "mendix")
public class RecipeIngredient extends AuditablePersistentObject {
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;
    @Column(name="unit")
    private String unit;
    @Column(name="quantity")
    private BigDecimal quantity;
    @Column(name="decription")
    private String description;
}
