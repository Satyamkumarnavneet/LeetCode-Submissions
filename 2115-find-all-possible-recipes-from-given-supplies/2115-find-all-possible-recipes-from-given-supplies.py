class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        supply_set = set(supplies) 
        recipe_map = {recipe: set(ingredient) for recipe, ingredient in zip(recipes, ingredients)}  
        result = []
        queue = list(supply_set)
        can_create = set(queue)

        while queue:
            ingredient = queue.pop(0)

            for idx, recipe in enumerate(recipes):
                if recipe not in can_create and recipe not in result:
                    if recipe_map[recipe].issubset(can_create):
                        result.append(recipe)
                        queue.append(recipe)
                        can_create.add(recipe)

        return result
