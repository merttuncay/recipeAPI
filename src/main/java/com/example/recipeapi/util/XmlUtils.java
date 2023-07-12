package com.example.recipeapi.util;

import com.example.recipeapi.category.model.dto.CategoryInsertDto;
import com.example.recipeapi.ingredient.model.dto.IngredientInsertDto;
import com.example.recipeapi.ingredient.model.dto.RecipeIngredientInsertDto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlUtils {
    private XmlUtils() {
    }

    public static Node getNode(Document document, String nodeName){
        NodeList nodeList = document.getElementsByTagName(nodeName);
        if(nodeList.getLength() == 0 ){
            throw new IllegalArgumentException("Document does not contain a " + nodeName + "tag.");
        }
        return nodeList.item(0);
    }

    public static String getRecipeName(Element element){
        return element.getElementsByTagName("title").item(0).getFirstChild().getNodeValue();
    }

    public static List<CategoryInsertDto> getCategories(Element element){
        Element categories = (Element) element.getElementsByTagName("categories").item(0).getFirstChild().getNextSibling();
        List<CategoryInsertDto> categoryList = new ArrayList<>();
        while(categories != null){
            if(categories.getFirstChild().getNodeValue() != null){
                if(!categories.getFirstChild().getNodeValue().contains("\n")){
                    CategoryInsertDto category = new CategoryInsertDto(categories.getFirstChild().getNodeValue());
                    categoryList.add(category);
                }
                if(categories.getNextSibling() instanceof Element element1){
                    categories = element1;
                }else if (categories.getNextSibling() == null){
                    break;
                }
                else
                    categories = (Element) categories.getNextSibling().getNextSibling();
            }
        }
        return categoryList;
    }

    public static List<RecipeIngredientInsertDto> getRecipeIngredients(Element element){
        NodeList ingredients = element.getElementsByTagName("ing");
        int nodeListSize = ingredients.getLength();
        List<RecipeIngredientInsertDto> recipeIngredientInsertDtoList = new ArrayList<>();
        for (int i = 0; i < nodeListSize; i++) {
            RecipeIngredientInsertDto recipeIngredientInsertDto = new RecipeIngredientInsertDto();
            Element amt = (Element) ingredients.item(i).getFirstChild().getNextSibling();
            if(amt.getFirstChild().getNextSibling() != null){
                String qty = amt.getFirstChild().getNextSibling().getFirstChild().getNodeValue();
                recipeIngredientInsertDto.setQuantity(qty);
                if(amt.getFirstChild().getNextSibling().getNextSibling() != null){
                    if(amt.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getFirstChild() != null){
                        String unit = amt.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getFirstChild().getNodeValue();
                        recipeIngredientInsertDto.setUnit(unit);
                    }
                }
            }
            Node ingredient = amt.getNextSibling().getNextSibling();
            if(ingredient != null){
                String ingredientName = ingredient.getFirstChild().getNodeValue();
                IngredientInsertDto ingredientInsertDto = new IngredientInsertDto(ingredientName);
                recipeIngredientInsertDto.setIngredientInsertDto(ingredientInsertDto);
            }
            recipeIngredientInsertDtoList.add(recipeIngredientInsertDto);
        }
        return recipeIngredientInsertDtoList;
    }

    public static String getDirections(Element element){
        String directions = "";
        if(element.getElementsByTagName("step").item(0).getFirstChild() != null){
            directions = element.getElementsByTagName("step").item(0).getFirstChild().getNodeValue();
        }
        return directions;

    }

    public static Document loadXMLFromString(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }
}
