package service.Impl;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();

        products.put(1,new Product(1,"Keo",20,"keo con bo","Candy"));
        products.put(2,new Product(2,"Banh",25,"Banh gao","one.one"));
        products.put(3,new Product(3,"Nuoc Coca-Cola",19,"nuoc co ga","Coca-Cola"));
        products.put(4,new Product(4,"Dau phat linh",15," dau phat linh","dau phat linh"));
        products.put(5,new Product(5,"Giay thuong dinh",50,"giay chay bo","thuong dinh"));
    }


    @Override
    public List<Product> finAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product search(String name) {
        for ( Product p:finAll()) {
            if (p.getName().contains(name))
            {
                return p;
            }
        }
        return null;
    }

}
