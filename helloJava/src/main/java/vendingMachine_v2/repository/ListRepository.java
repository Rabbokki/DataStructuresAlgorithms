package vendingMachine_v2.repository;

import vendingMachine_v2.myInterface.ArrayListInterface;
import vendingMachine_v2.vo.Product;

import java.util.ArrayList;
import java.util.List;

public class ListRepository implements ArrayListInterface {
    List<Product> productList = new ArrayList<>();

    @Override
    public boolean insert(Product product) {
        productList.add(product);
        return true;
    }

    @Override
    public boolean update(int idx, Product product) {
        productList.set(idx,product);
        return true;
    }

    @Override
    public boolean delete(int idx) {
        productList.remove(idx);
        return false;
    }

    @Override
    public Product findByName(String name) {
        for (Product p : productList) {
            if(p.getItem().equals(name)){
                return p;
            }
        }
        return null;

    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}
