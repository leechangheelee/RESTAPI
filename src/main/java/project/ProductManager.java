package project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductManager {
    private List<Product> datas = new ArrayList<>();
    
    public ProductManager() {
        datas.add(new Product(1, "iPhone 11 pro", 1500000));
        datas.add(new Product(2, "Galaxy Note 10", 1400000));
        datas.add(new Product(3, "Galaxy Fold", 2500000));
        datas.add(new Product(4, "LG G9", 1000000));
    }
    
    public void addProduct(Product p) {
        p.setId(datas.size() + 1);
        datas.add(p);
    }
    
    public List<Product> getDatas() {
        return datas;
    }
    
    public Product getProduct(int id) {
        return datas.get(id - 1);
    }
    
    public void delProduct(int id) {
        datas.remove(id - 1);
    }
}