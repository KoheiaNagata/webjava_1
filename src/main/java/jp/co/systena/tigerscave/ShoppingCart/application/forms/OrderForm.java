package jp.co.systena.tigerscave.ShoppingCart.application.forms;

import java.io.Serializable;
import javax.validation.constraints.Size;

public class OrderForm implements Serializable {

  @Size(max=10)         // 入力最大長
  public String name;
  public int price;
  public int num;

  public OrderForm getOrderForm() {
    OrderForm orderform = new OrderForm();
    orderform.name = name;
    orderform.price = price;
    orderform.num =num;

    return orderform;
  }

  public void setOrder(OrderForm orderForm) {
    OrderForm orderform = new OrderForm();
    orderform.name = name;
    orderform.price = price;
    orderform.num =num;
  }


}
