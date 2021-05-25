package project;

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;*/
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value="msg", required=false) String msg) {
        return msg;
    }
    
    @Autowired
    ProductManager pm;
    
    @GetMapping("/product")
    public List<Product> getAll() {
        return pm.getDatas();
    }
    
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return pm.getDatas().get(id - 1);
    }
    
    @PostMapping("/product")
    public String addProduct(@RequestBody Product p) {
        pm.addProduct(p);
        return "상품 추가됨!";
    }
    
    @DeleteMapping("/product/{id}")
    public String delProduct(@PathVariable int id) {
        pm.delProduct(id);
        return "상품 삭제됨!";
    }
}