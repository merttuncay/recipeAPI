package com.example.recipeapi.recipe.service.impl;

import com.example.recipeapi.recipe.model.dto.RecipeInsertDto;
import com.example.recipeapi.recipe.repository.RecipeRepository;
import com.example.recipeapi.recipe.service.RecipeParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class RecipeParserServiceImpl implements RecipeParserService {

    private final RecipeRepository recipeRepository;

    @Override
    public RecipeInsertDto saveRecipe(byte[] data) throws Exception {
        RecipeInsertDto recipeInsertDto;

        String recipeString = new String(data);
        Document doc = loadXMLFromString(recipeString);
        doc.getDocumentElement().normalize();


        return null;
    }

    private Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("https://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }
}
