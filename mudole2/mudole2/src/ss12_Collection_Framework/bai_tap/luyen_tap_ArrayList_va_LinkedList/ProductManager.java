package ss12_Collection_Framework.bai_tap.luyen_tap_ArrayList_va_LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void create(Product product){
        products.add(product);
    }

    public void update (Product product){
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getId() == product.getId()){
                products.set(i,product);
                break;
            }
        }
    }

    public void delete(int id){
//        for (int i = 0; i < products.size(); i++) {
//            if(products.get(i).getId() == id){
//                products.remove(i);
//                break;
//            }
//        }
            products.removeIf(e-> e.getId() == id);

    }

     List<Product> findAll() {
        return products;
    }

    List<Product> search(String name){
        List result = new ArrayList<Product>();
        for (int i = 0; i < products.size() ; i++) {
            if (products.get(i).getName().equals(name)){
                result.add(products.get(i));
            }
        }
        return result;
    }

    public void sort (boolean isASC){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return isASC ? (int)(o1.getPrice() - o2.getPrice()) : (int)(o2.getPrice() - o1.getPrice());
            }
        });
    }
}
