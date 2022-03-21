package com.whitecollar.service;

import com.whitecollar.model.Picture;
import com.whitecollar.model.Shop;
import com.whitecollar.repository.IshopRepository;

import java.util.List;

public interface IshopService {//--> se definen los metodos necesarios para crud y otros mas especificos

    Shop createShop(Shop shop);

    List<Shop> getAllShop();

    Shop findByIdShop(Integer id);

    Shop updateShop(Shop shop);

    Picture addPicture(Integer id, Picture picture);

    List<Picture> getAllPicture(Integer idShop);

    boolean deleteAllPicture(Integer idShop);


}
