class FoodRatings {
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, TreeSet<String>> cuisineToFoods;

    private Comparator<String> foodComparator = (a, b) -> {
        int ratingCompare = Integer.compare(foodToRating.get(b), foodToRating.get(a));
        return ratingCompare != 0 ? ratingCompare : a.compareTo(b);
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);

            cuisineToFoods.putIfAbsent(cuisines[i], new TreeSet<>(foodComparator));
            cuisineToFoods.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> foods = cuisineToFoods.get(cuisine);
        foods.remove(food);
        foodToRating.put(food, newRating);
        foods.add(food);
    }
    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first();
    }
}
