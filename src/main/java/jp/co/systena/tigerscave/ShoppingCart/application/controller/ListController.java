package jp.co.systena.tigerscave.ShoppingCart.application.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.ShoppingCart.application.data.Item;
import jp.co.systena.tigerscave.ShoppingCart.application.data.Order;
import jp.co.systena.tigerscave.ShoppingCart.application.forms.ListForm;
import jp.co.systena.tigerscave.ShoppingCart.application.forms.OrderForm;
import jp.co.systena.tigerscave.ShoppingCart.application.services.ListService;


@Controller
public class ListController {
  @Autowired
  private ListService listservice;

  @ModelAttribute
  public ModelAndView show() {
    List<Item> itemList =listservice.getItemList();
    List<ListForm> forms = new ArrayList<>();
    for (Item item : itemList) {
      forms.add(new ListForm(item.name,item.price));
    }

    return new ModelAndView("ListView","forms",forms);
  }

    @Autowired
    HttpSession session;                  // セッション管理

    @RequestMapping(value="/koh", method = RequestMethod.GET)          // URLとのマッピング
    public ModelAndView index(ModelAndView mav) {
      // Viewに渡すデータを設定
      // セッション情報から保存したデータを取得してメッセージを生成
      OrderForm orderForm = (OrderForm) session.getAttribute("form");
      session.removeAttribute("form");
      if (orderForm != null) {
        mav.addObject("message", orderForm.getOrderForm()+"を保存しました");
      }
      mav.addObject("orderForm", new OrderForm());  // 新規クラスを設定

      List<Order> orders = (List<Order>) session.getAttribute("orderList");
      if( orders == null) {
          orders = new ArrayList<Order>();
          session.setAttribute("orderList", orders);
      }
      mav.addObject("orders", orders);

      BindingResult bindingResult = (BindingResult) session.getAttribute("result");
      if (bindingResult != null) {
        mav.addObject("bindingResult", bindingResult);
      }
      // Viewのテンプレート名を設定
      mav.setViewName("ListView");
      return mav;
    }

    @RequestMapping(value="/koh", method = RequestMethod.POST)  // URLとのマッピング
    private ModelAndView adduser(ModelAndView mav, @Valid OrderForm orderForm, BindingResult bindingResult, HttpServletRequest request) {

      List<Order> orders = (List<Order>)session.getAttribute("orderList");
      if( orders == null) {
          orders = new ArrayList<Order>();
          session.setAttribute("orderList", orders);
      }

      if (bindingResult.getAllErrors().size() > 0) {
        // エラーがある場合はそのまま戻す
        mav.addObject("orderForm",orderForm);  // 新規クラスを設定

        mav.addObject("orders", orders);

        // Viewのテンプレート名を設定
        mav.setViewName("ListView");
        return mav;

      }
      Order order = new Order();
      order.setOrder(orderForm.getOrderForm());
      orders.add(order);
      // データをセッションへ保存
      session.setAttribute("form", orderForm);
      return new ModelAndView("redirect:/koh");        // リダイレクト
    }

 }
