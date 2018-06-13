package com.gmail.grind3x;

import com.gmail.grind3x.model.Catalog;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
@RequestMapping("/")
public class MyController {
    private Catalog catalog = new Catalog();

    @RequestMapping("/")
    public String onIndex(){
        return "index";
    }

    @RequestMapping (value = "/add_xml", method = RequestMethod.POST)
    public String onAddXML(Model model, @RequestParam MultipartFile file) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String str;
            String xml = "";
            for (;(str = br.readLine()) != null ;) {
                xml += str + "\n";
            }
            Catalog load = Catalog.fromXML(xml);
            catalog.addAll(load.getAdvertisements());
            model.addAttribute("message", "Succsess loaded " + load.getAdvertisements().size() + " advertisements!" );
            model.addAttribute("load", load.getAdvertisements());
        } catch (IOException | NullPointerException e) {
            model.addAttribute("message" , "Error. Maybe you have a wrong XML structure!");
        }
        return "result";
    }

    @RequestMapping(value = "/view_all")
    public String onViewAll(Model model) {
        model.addAttribute("advertisements", catalog.getAdvertisements());
        return "view_all";
    }

    @RequestMapping("/img/{id}")
    public ResponseEntity<byte[]> onImg(@PathVariable("id") Long id) {
        byte[] bytes = catalog.getAdvById(id).getImage();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(bytes,httpHeaders, HttpStatus.OK);
    }
}
