package com.example.salessupportapp.controller;

import com.example.salessupportapp.entity.Customer;
import com.example.salessupportapp.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller // 「これが画面制御の担当ですよ」という目印
public class CustomerController {

    private final CustomerRepository repository;

    // 道具箱（Repository）を使えるように準備
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers") // ブラウザで localhost:8080/customers を開いた時の処理
    public String listCustomers(Model model) {
        // 1. DBから全データを取ってくる
        List<Customer> customers = repository.findAll();

        // 2. 画面（HTML）にデータを渡すための「荷札」をつける
        model.addAttribute("customers", customers);

        // 3. 表示するHTMLファイルの名前を指定
        return "customer-list";
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