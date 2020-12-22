package tn.sarra.ehanoutv1;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.sarra.ehanoutv1.dao.CategoryRepository;
import tn.sarra.ehanoutv1.dao.ProductRepository;
import tn.sarra.ehanoutv1.entities.Category;
import tn.sarra.ehanoutv1.entities.Product;

import java.util.Random;

@SpringBootApplication
public class EHanoutV1Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository ;

    public static void main(String[] args) {
        SpringApplication.run(EHanoutV1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        categoryRepository.save(new Category(null, "Computers", null, null));
        categoryRepository.save(new Category(null, "Printers", null, null));
        categoryRepository.save(new Category(null, "Smart phones", null, null));

        Random rnd = new Random();

        categoryRepository.findAll().forEach(c ->{
            for (int i=0; i<10; i++) {
                Product p =new Product();
                p.setName(RandomString.make(18));
                p.setCurrentPrice(100+rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                productRepository.save(p);
            }

        });

    }
}
