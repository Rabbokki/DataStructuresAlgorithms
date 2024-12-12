package vendingMachine_v2.myInterface;


import vendingMachine_v2.vo.Product;

import java.util.List;

public interface ArrayListInterface {
    //1. 삽입
    //2. 수정
    //3. 삭제
    //4. 한개 찾아오기(제품명)
    //5. 전체 찾아오기

    public boolean insert(Product product);

    public boolean update(int idx , Product product);

    public boolean delete(int idx);

    public Product findByName(String name);

    List<Product> findAll();

}
