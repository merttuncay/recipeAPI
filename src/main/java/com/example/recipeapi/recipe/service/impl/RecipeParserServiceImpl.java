package com.example.recipeapi.recipe.service.impl;

import com.example.recipeapi.category.model.dto.CategoryInsertDto;
import com.example.recipeapi.ingredient.model.dto.RecipeIngredientInsertDto;
import com.example.recipeapi.recipe.model.dto.RecipeInsertDto;
import com.example.recipeapi.recipe.repository.RecipeRepository;
import com.example.recipeapi.recipe.service.RecipeParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static com.example.recipeapi.util.XmlUtils.*;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class RecipeParserServiceImpl implements RecipeParserService {

    private final RecipeRepository recipeRepository;

    @Override
    public RecipeInsertDto saveRecipe(byte[] data) throws ParserConfigurationException, IOException, SAXException {
        RecipeInsertDto recipeInsertDto = new RecipeInsertDto();

        String recipeString = new String(data);
        Document doc = loadXMLFromString(recipeString);
        doc.getDocumentElement().normalize();
        Node recipe = getNode(doc,"recipe");
        Element head = ((Element) recipe.getFirstChild().getNextSibling());
        recipeInsertDto.setRecipeName(getRecipeName(head));
        List<CategoryInsertDto> categoryInsertDtoList = getCategories(head);
        recipeInsertDto.setCategories(categoryInsertDtoList);
        int yieldNumber = Integer.parseInt(head.getElementsByTagName("yield").item(0).getFirstChild().getNodeValue());
        recipeInsertDto.setYieldNumber(yieldNumber);
        Element ingredients = (Element) head.getNextSibling().getNextSibling();
        List<RecipeIngredientInsertDto> recipeIngredientInsertDtoList = getRecipeIngredients(ingredients);
        recipeInsertDto.setRecipeIngredients(recipeIngredientInsertDtoList);
        Element directions = (Element) ingredients.getNextSibling().getNextSibling();
        recipeInsertDto.setDirections(getDirections(directions));
        recipeRepository.save(recipeInsertDto.toRecipe());

        return recipeInsertDto;
    }

}
