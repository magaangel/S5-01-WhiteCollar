package com.whitecollar.repository;

import com.whitecollar.model.Shop;
import org.springframework.data.repository.CrudRepository;


public interface IshopRepository extends CrudRepository<Shop, Integer> {//--> contiene los metodos necesarios para hacer crud
    //lo cuales seran utilizados en la capa Service, mediante el atributo del tipo de la interface

}
