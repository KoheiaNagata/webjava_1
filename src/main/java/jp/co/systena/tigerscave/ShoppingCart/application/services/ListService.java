package jp.co.systena.tigerscave.ShoppingCart.application.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import jp.co.systena.tigerscave.ShoppingCart.application.data.Item;

@Service
public class ListService {
   private static final List<Item> ITEM_LIST = new ArrayList<>();
   static {
     ITEM_LIST.add(new Item("きゅうり",98));
     ITEM_LIST.add(new Item("いちご",598));
     ITEM_LIST.add(new Item("かぼちゃ",600));
     ITEM_LIST.add(new Item("キウイ",100));
     ITEM_LIST.add(new Item("キャベツ",298));
     ITEM_LIST.add(new Item("じゃがいも",50));

   }

   public List<Item> getItemList(){

     return ITEM_LIST;
   }


}
