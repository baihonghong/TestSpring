package taco.controller;

import lombok.extern.slf4j.Slf4j;
import taco.model.Ingredient;
import taco.model.Taco;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * //@Slf4j，它是 Lombok 提供的注解，在运⾏时将⾃动⽣成类中的记录器。这个适当的注解具有与显式地在类中添加以下⾏相同的效果：
 * private static final org.slf4j.Logger log =org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
 * 通过@SessionAttributes注解将ModelMap中的属性存入到Session中以后：
 * 可以在本次请求对应的jsp页面中使用request.getAttribute("");和session.getAttribute("");获取到该属性；
 * 还可以通过下次其它请求对应的jsp页面中使用session.getAttribute("");和ModelMap#get("");获得到该属性；
 * 也可以通过@ModelAattribute注解标识的参数中获取。
 * 补充：request.getAttribute("")的scope为request，也就是在当前请求，从控制器到jsp携带的ModelMap对象中获取，而session.getAattribute("")的scope为session，是从Session中去获取属性值。
 * 注意：@SessionAttributes注解只能使用在类上，用于在多个请求之间传递参数，类似于Session的Attribute，但不完全一样，一般来说@SessionAttributes设置的参数只用于暂时的传递（存入sessionAttributeStore），
 * 而不是长期的保存，长期保存的数据还是要放到Session中。
 * @ModelAttribute是Spring框架中的一个注解，它可以用于方法或方法的参数上。这个注解的主要作用是将方法的参数或返回值绑定到一个命名的模型属性上，并传递给Web视图。
 * @ModelAttribute**注解用于方法上时，这个方法会在控制器的任何其他请求处理方法之前被调用。这意味着你可以在这个方法中初始化一些模型属性，这些属性之后会被多个请求处理方法所使用。
 * @ModelAttribute**注解用于方法参数上时，Spring会尝试从模型中获取与参数名称相匹配的属性。如果找到了，它就会将该属性传递给方法；如果没有找到，它会查看请求中是否有匹配的参数，并尝试创建和填充对象。
 */
@Slf4j
@Controller
@SessionAttributes("tacoOrder")
@RequestMapping("/design")
public class DesignTacoController {
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
    @GetMapping("/design")
    public String showDesignForm(Model model) {
        model.addAttribute("taco", new Taco());
        return "design";
    }
    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
