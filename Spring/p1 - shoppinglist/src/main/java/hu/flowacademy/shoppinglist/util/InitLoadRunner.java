package hu.flowacademy.shoppinglist.util;

import hu.flowacademy.shoppinglist.domain.ShoppingItem;
import hu.flowacademy.shoppinglist.domain.User;
import hu.flowacademy.shoppinglist.domain.Variant;
import hu.flowacademy.shoppinglist.repository.ShoppingListRepository;
import hu.flowacademy.shoppinglist.repository.UserRepository;
import hu.flowacademy.shoppinglist.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitLoadRunner implements CommandLineRunner {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VariantRepository variantRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("hajnalandor","qwes","Hajnal Andor");
        User user2 = new User("gitpush2019","pushpull","Pecze Tamas");
        User user3 = new User("miczol","police10","Micsik Zoltan");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        ShoppingItem s1= new ShoppingItem("1","fogkefe","Occso",3,2,399,"Colgate Occso fogkefe",user1);
        ShoppingItem s2= new ShoppingItem("2","hasznaltfogkefe","OccsodeJo",31,22,3299,"Colgate Occso fogkefe",user2);

        shoppingListRepository.save(s1);
        shoppingListRepository.save(s2);

        Variant v1= new Variant("segedfogkefe",12.32D,s1);
        Variant v2 = new Variant("izePotlo",5D,s2);

        variantRepository.save(v1);
        variantRepository.save(v2);



    }
}
