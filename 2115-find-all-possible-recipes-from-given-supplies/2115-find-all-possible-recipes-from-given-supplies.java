class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        Map<String, List<String>> recipeIngredients = new HashMap<>();
        Set<String> result = new HashSet<>();
        
        for (int i = 0; i < recipes.length; i++) {
            recipeIngredients.put(recipes[i], ingredients.get(i));
        }
        
        boolean foundNewRecipe = true;
        while (foundNewRecipe) {
            foundNewRecipe = false;
            for (String recipe : recipes) {
                if (!result.contains(recipe)) {
                    List<String> requiredIngredients = recipeIngredients.get(recipe);
                    if (supplySet.containsAll(requiredIngredients)) {
                        supplySet.add(recipe);
                        result.add(recipe);
                        foundNewRecipe = true;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}