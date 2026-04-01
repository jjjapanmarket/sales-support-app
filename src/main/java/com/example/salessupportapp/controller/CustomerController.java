package com.example.salessupportapp.controller;

import com.example.salessupportapp.entity.Customer;
import com.example.salessupportapp.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // ★必須！
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    // 一覧表示
    @GetMapping("/customers")
    public String listCustomers(Model model) {
        List<Customer> customers = repository.findAll();
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    // 登録画面を表示
    @GetMapping("/customers/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    // データを保存
    @PostMapping("/customers")
    public String saveCustomer(Customer customer) {
        repository.save(customer);
        return "redirect:/customers";
    }

    // ★詳細画面を表示
    @GetMapping("/customers/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        Customer customer = repository.findById(id).orElseThrow();
        model.addAttribute("customer", customer);
        return "customer-detail";
    }
    // 削除処理
    @PostMapping("/customers/{id}/delete")
    public String deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/customers";
    }
}

//@Controller
//イメージ： 「私はこのお店の店員（接客担当）です」という名札をつけている。
//役割： Spring Bootに「このクラスが画面の案内係だよ」と教えます。

//CustomerRepository repository;
//イメージ： 「厨房（データベース）へつながる注文用タブレット」を持っている。
//役割： データを取ってくるための道具を使えるようにしています。

//@GetMapping("/customers")
//イメージ： お客さんが「メニュー（/customers）を見せて」と言ってきた時の対応ルール。
//役割： ブラウザでそのURLが開かれた時に、この下の処理を動かします。

//model.addAttribute("customers", customers);
//イメージ： 厨房から持ってきた料理（データ）を、お盆（model）に乗せて「はい、どうぞ」とテーブルへ運ぶ準備。
//役割： Javaで作ったデータを、HTML（画面）で使えるように渡しています。

//return "customer-list";
//イメージ： 「では、あちらの『customer-list』という席へご案内します」という案内。
//役割： 次に表示するHTMLファイルの名前を指定しています。


