/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Tai
 */
import DAO.IngredientsDAO;
import DTO.IngredientsDTO;
import java.util.ArrayList;



public class IngredientsBUS {
    private IngredientsDAO ingredientsDAO = new IngredientsDAO();
    private ArrayList<IngredientsDTO> listIngredients = new ArrayList<>();
    
    public IngredientsDTO getIngredientById(long id) {
        return ingredientsDAO.getIngredientById(id);
    }
    
    public boolean addIngredient(IngredientsDTO ingredient){
        return ingredientsDAO.addIngredient(ingredient);
    }
    
    public boolean updateIngredient(IngredientsDTO ingredient) {
        return ingredientsDAO.updateIngredient(ingredient);
    }

    public boolean setIngredientAsDeleted(long id) {
        return ingredientsDAO.setIngredientAsDeleted(id);
    }

    public ArrayList<IngredientsDTO> getAllActiveIngredients() {
        return ingredientsDAO.getAllActiveIngredients();
    }
    public boolean checkIngredientExistence(long ingredientId){
        return ingredientsDAO.checkIngredientExistence(ingredientId);
    }

    public int getIngredientQuantity(long ingredientId){
        return ingredientsDAO.getIngredientQuantity(ingredientId);
    }

    public void updateIngredientQuantity(long ingredientId, int newQuantity){
        ingredientsDAO.updateIngredientQuantity(ingredientId, newQuantity);
    }
}
