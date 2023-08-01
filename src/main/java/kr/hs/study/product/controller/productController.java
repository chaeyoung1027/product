package kr.hs.study.product.controller;

import kr.hs.study.product.dto.productDTO;
import kr.hs.study.product.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class productController {
    @Autowired
    private productService service;

//    @GetMapping("/")
//    public String list(Model model){
//        List<productDTO> list=service.listAll();
//        model.addAttribute("list1",list);
//        return "list";
//    }
    @GetMapping("/add")
    public String add_form() {
        return "add_form";
    }
    @PostMapping("/add_done")
    // 사용자가 입력값이 productDTO에 자동주입해야해
    public String add_done(productDTO dto) {

        System.out.println("id:"+dto.getProductId());
        service.insert(dto);
        return "redirect:/";

    }

    @GetMapping("/list")
    public String list(Model model){
        List<productDTO> list = service.listAll();
        System.out.println("list : "+list);
        model.addAttribute("list1",list);
        return "list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.del_Product(id);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String update_form(@PathVariable("id") String id, Model model) {
      productDTO  dto=service.readOne(id);
      model.addAttribute("dto",dto);
        System.out.println("dto:"+dto);
                return "readOne";
    }

}
