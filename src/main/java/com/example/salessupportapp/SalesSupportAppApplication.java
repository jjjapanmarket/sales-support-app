package com.example.salessupportapp; // 自分のパッケージ名に合わせてください

import com.example.salessupportapp.entity.Customer;
import com.example.salessupportapp.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class SalesSupportAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesSupportAppApplication.class, args);
    }

    @Bean
    CommandLineRunner sampleData(CustomerRepository repository) {
        return args -> {
            // 1. データを1件作る（保存のテスト）
            Customer c = new Customer();
            c.setName("テスト株式会社");
            c.setEmail("test@example.com");
            c.setTodo("挨拶の電話をする");
            repository.save(c);

            System.out.println("--- データを保存しました！ ---");

            // 2. データを全部持ってくる（取得とListのテスト）
            List<Customer> customers = repository.findAll();

            System.out.println("--- 現在の顧客一覧を表示します ---");
            // 拡張for文
            for (Customer customer : customers) {
                System.out.println("名前: " + customer.getName() + " / 用件: " + customer.getTodo());
            }
        };
    }
}
