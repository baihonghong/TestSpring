package taco.model;

import lombok.Data;

/**
 * @description:TODO
 * @author:baihhw
 * @date:2025/02/15 10:35
 */
@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;


    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
