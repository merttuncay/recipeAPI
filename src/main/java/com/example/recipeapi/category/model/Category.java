package com.example.recipeapi.category.model;


import com.example.recipeapi.base.model.AuditablePersistentObject;
import com.example.recipeapi.recipe.model.Recipe;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Entity
@Table(name = "category", schema = "mendix")
public class Category extends AuditablePersistentObject {
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Recipe.class)
    @JoinColumn(name = "recipe_id")
    private Recipe recipeId;
    @Column(name="category_name")
    private String categoryName;
}
