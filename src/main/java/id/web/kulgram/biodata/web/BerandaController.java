package id.web.kulgram.biodata.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BerandaController {

    @GetMapping
    public String beranda() {
        return "index";
    }

}
