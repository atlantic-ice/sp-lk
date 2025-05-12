package ru.bgpu.splk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.bgpu.splk.models.*;
import ru.bgpu.splk.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@Profile("dev")
public class DevDataInitializer {

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private GroupService groupService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MovementJournalService movementJournalService;
    
    @Bean
    public CommandLineRunner initData() {
        return args -> {
            Random random = new Random();
            
            // Создаем категории
            List<Category> categories = new ArrayList<>();
            String[] categoryNames = {"Электроника", "Продукты", "Одежда", "Книги", "Мебель"};
            
            for (String name : categoryNames) {
                Category category = new Category();
                category.setName(name);
                categories.add(categoryService.save(category));
            }
            
            // Создаем продукты
            List<Product> products = new ArrayList<>();
            String[] productNames = {"Телевизор", "Ноутбук", "Хлеб", "Молоко", "Футболка", "Джинсы", "Роман", "Учебник", "Стол", "Стул"};
            
            for (int i = 0; i < productNames.length; i++) {
                Product product = new Product();
                product.setName(productNames[i]);
                product.setPrice(100.0 + random.nextDouble() * 1000);
                product.setCategory(categories.get(i % categories.size()));
                products.add(productService.save(product));
            }
            
            // Создаем журнал движения товаров
            for (Product product : products) {
                // Поступление товаров
                MovementJournal incoming = new MovementJournal();
                incoming.setProduct(product);
                incoming.setQuantity(10 + random.nextInt(90));
                incoming.setType(MovementType.INCOMING);
                movementJournalService.save(incoming);
                
                // Выдача товаров (меньше, чем поступило)
                MovementJournal outgoing = new MovementJournal();
                outgoing.setProduct(product);
                outgoing.setQuantity(random.nextInt(10));
                outgoing.setType(MovementType.OUTGOING);
                movementJournalService.save(outgoing);
            }
            
            // Создаем группы
            List<Group> groups = new ArrayList<>();
            String[] groupNames = {"Администраторы", "Менеджеры", "Кладовщики", "Гости"};
            
            for (String name : groupNames) {
                Group group = new Group();
                group.setName(name);
                groups.add(groupService.save(group));
            }
            
            // Создаем пользователей
            String[] firstNames = {"Иван", "Петр", "Сергей", "Мария", "Елена", "Анна"};
            String[] lastNames = {"Иванов", "Петров", "Сидоров", "Смирнова", "Козлова", "Новикова"};
            Role[] roles = Role.values();
            
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setName(firstNames[random.nextInt(firstNames.length)]);
                user.setSurname(lastNames[random.nextInt(lastNames.length)]);
                user.setGroup(groups.get(random.nextInt(groups.size())));
                user.setRole(roles[random.nextInt(roles.length)]);
                userService.save(user);
            }
        };
    }
} 