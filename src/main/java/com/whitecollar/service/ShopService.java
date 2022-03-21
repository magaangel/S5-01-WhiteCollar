package com.whitecollar.service;

import com.whitecollar.model.Picture;
import com.whitecollar.model.Shop;
import com.whitecollar.repository.IpictureRepository;
import com.whitecollar.repository.IshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements IshopService{

    @Autowired
    private IshopRepository shopRepository;//--> nos permite tener los datos disponibles en la capa Service
    @Autowired
    private IpictureRepository pictureRepository;//-->necesario para la tabla picture


    @Override
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public List<Shop> getAllShop() {
        return (List<Shop>) shopRepository.findAll();
    }

    @Override
    public Shop updateShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop findByIdShop(Integer id) {
        Optional<Shop> op = shopRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    public Picture addPicture(Integer idShop, Picture picture) {
        Picture p = pictureRepository.save(picture);//-->se guarda en la tabla picture
        Shop shop = this.findByIdShop(idShop);
        shop.getPictures().add(p);
        this.updateShop(shop);//-->se actualiza el objeto shop que se busco por id, para poder agregar objetos picture al atributo de tipo List<Picture>
        int index = shop.getPictures().indexOf(p);
        return shop.getPictures().get(index);//-->trae el objeto que se agrego
    }

    @Override
    public List<Picture> getAllPicture(Integer idShop) {
        Shop shop = this.findByIdShop(idShop);
        List<Picture> pictureList = (List<Picture>) pictureRepository.findAll();
        shop.setPictures(pictureList);//--> nos aseguramos de traer la List<Picture> actualizada
        return shop.getPictures();
    }

    @Override
    public boolean deleteAllPicture(Integer idShop) {
        boolean resultado = false;
        Shop shop = this.findByIdShop(idShop);
        List<Picture> pictureList = shop.getPictures();
        pictureList.removeAll(pictureList);
        this.updateShop(shop);
        if(shop.getPictures().isEmpty()){
            return true;
        }
        return resultado;
    }

/*
--> ESTOS METODOS NO SE PIDEN EN EL EJERCICIO

    public void deleteShop(Integer id) {
        shopRepository.deleteById(id);
    }

    public Picture findByIdPicture(Integer idShop, Integer idPicture) {
        Shop shop = this.findByIdShop(idShop);
        List<Picture> pictureList = shop.getPictures();
        for(Picture p: pictureList){
            if(p.getId() == idPicture){
                return p;
            }
        }
        return null;
    }

    public void deletePicture(Integer idShop, Integer idPicture) {
        Shop shop = this.findByIdShop(idShop);
        List<Picture> pictureList = shop.getPictures();
        pictureList.removeIf(x -> x.getId() == idPicture);
    }

 */

}
