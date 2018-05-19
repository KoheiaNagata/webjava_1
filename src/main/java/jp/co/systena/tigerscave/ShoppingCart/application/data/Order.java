package jp.co.systena.tigerscave.ShoppingCart.application.data;

import java.io.Serializable;
import jp.co.systena.tigerscave.ShoppingCart.application.forms.OrderForm;

public class Order implements Serializable{

  public String name;
  public int price;
  public int num;


  public Order getOrder() {
    Order order = new Order();
    order.name = name;
    order.price = price;
    order.num =num;

    return order;
  }

  public void setOrder(OrderForm orderForm) {
    Order order = new Order();
    order.name = name;
    order.price = price;
    order.num =num;
  }



}
