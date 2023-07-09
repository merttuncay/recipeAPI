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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
    @Column(name="category_name")
    private String categoryName;
}
