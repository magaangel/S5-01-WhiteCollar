package com.whitecollar.controller;

import com.whitecollar.model.Picture;
import com.whitecollar.model.Shop;
import com.whitecollar.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/shops")
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop){
        return new ResponseEntity<>(shopService.createShop(shop), HttpStatus.OK);
    }

    @GetMapping("/shops")
    public ResponseEntity<List<Shop>> getAllShop(){
        List<Shop> shopList = shopService.getAllShop();
        if(shopList.isEmpty()){
            return new ResponseEntity<List<Shop>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Shop>>(shopService.getAllShop(), HttpStatus.OK);
    }

    @PostMapping("/shops/{id}/pictures")
    public ResponseEntity<Picture> addPicture(@PathVariable(name = "id") Integer idShop, @RequestBody Picture picture){
        Shop shop = shopService.findByIdShop(idShop);
        Picture p = null;
        if(shop != null){
            p = shopService.addPicture(shop.getId(), picture);
        }
        return new ResponseEntity<Picture>(p, HttpStatus.OK);
    }

    @GetMapping("/shops/{id}/pictures")
    public ResponseEntity<List<Picture>> getAllPictures(@PathVariable(name = "id") Integer idShop){
        Shop shop = shopService.findByIdShop(idShop);
        if(shop.getPictures().isEmpty()){
            return new ResponseEntity<List<Picture>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Picture>>(shop.getPictures(), HttpStatus.OK);
    }

    @DeleteMapping("/shops/{id}/pictures")
    public ResponseEntity deleteAllPictures(@PathVariable(name = "id") Integer idShop){
        shopService.deleteAllPicture(idShop);
        return new ResponseEntity("Successfully deleted", HttpStatus.OK);
    }

}
