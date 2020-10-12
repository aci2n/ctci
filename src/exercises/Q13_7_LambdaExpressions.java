package exercises;

import java.util.Arrays;
import java.util.List;

public class Q13_7_LambdaExpressions {
    private interface Country {
        String getContinent();

        int getPopulation();
    }

    private static int getPopulation(List<Country> countries, String continent) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(continent))
                .mapToInt(Country::getPopulation)
                .sum();
    }

    public static void main(String[] args) {
        int population = getPopulation(Arrays.asList(
                new Country() {
                    @Override
                    public int getPopulation() {
                        return 10;
                    }

                    @Override
                    public String getContinent() {
                        return "america";
                    }
                }, new Country() {
                    @Override
                    public String getContinent() {
                        return "europe";
                    }

                    @Override
                    public int getPopulation() {
                        return 20;
                    }
                }), "america");

        System.out.println(population);
    }
}
