package jp.co.systena.tigerscave.ShoppingCart.application.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import jp.co.systena.tigerscave.ShoppingCart.application.data.Order;

@Service
public class OrderService {

  private static final List<Order> ORDER_LIST = new ArrayList<>();

  public List<Order> getOrderList(){

    return ORDER_LIST;
  }
}