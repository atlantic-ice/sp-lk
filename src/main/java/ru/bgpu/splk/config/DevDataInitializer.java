package ru.bgpu.splk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.bgpu.splk.services.*;

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
            // Минимальная реализация для заполнения БД случайными данными
            // Требуется сеттеры в моделях для заполнения данными
        };
    }
} 