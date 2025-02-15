package taco.model;

import lombok.Data;

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
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Taco> tacos = new ArrayList<>();
    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
