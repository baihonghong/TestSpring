package taco.model;

import lombok.Data;

import java.util.List;

/**
 * @description:TODO
 * @author:baihhw
 * @date:2025/02/15 10:44
 */
@Data
public class Taco {
    private String name;
    private List<Ingredient> ingredients;
}
