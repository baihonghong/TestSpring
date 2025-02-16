package taco.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:TODO
 * @author:baihhw
 * @date:2025/02/15 10:45
 */
@Data
public class TacoOrder {
    //有九个属性：5个⽤于交付信息，3个表⽰付款信息，1个表⽰组成交易的 Taco对象列表。
        @NotBlank(message="Delivery name is required")
        private String deliveryName;
        @NotBlank(message="Street is required")
        private String deliveryStreet;
        @NotBlank(message="City is required")
        private String deliveryCity;
        @NotBlank(message="State is required")
        private String deliveryState;
        @NotBlank(message="Zip code is required")
        private String deliveryZip;
        // @CreditCardNumber 进⾏了注解。该注解声明属性的值必须是通过 Luhn 算法
        //（https://en.wikipedia.org/wiki/Luhn_algorithm）检查过的有效
        //信⽤卡号。这可以防⽌⽤户出错的数据和故意错误的数据，但不能保
        //证信⽤卡号码实际上被分配到⼀个帐户，或该帐户可以⽤于交易
        @CreditCardNumber(message="Not a valid credit card number")
        private String ccNumber;
        @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
                message="Must be formatted MM/YY")
        private String ccExpiration;
        //@Digits以确保值恰好包含三个数字
        @Digits(integer=3, fraction=0, message="Invalid CVV")
        private String ccCVV;
        private List<Taco> tacos = new ArrayList<>();
        public void addTaco(Taco taco) {
            this.tacos.add(taco);
        }
}
