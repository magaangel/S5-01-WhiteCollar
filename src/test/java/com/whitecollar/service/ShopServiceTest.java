package com.whitecollar.service;

import com.whitecollar.model.Picture;
import com.whitecollar.model.Shop;
import com.whitecollar.repository.IpictureRepository;
import com.whitecollar.repository.IshopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ShopServiceTest {

    @Mock
    private IshopRepository shopRepository;//-->simula el objeto
    @Mock
    private IpictureRepository pictureRepository;
    @InjectMocks//--> inyecta con el objeto simulado
    private ShopService shopService;

    private Shop shop;//--> se debe crear la variable de retorno del metodo
    private Picture picture;


    @BeforeEach//-->se ejecuta antes de cada test
    void setUp() {
        MockitoAnnotations.openMocks(this);//--> inicializa Mockito

        shop = new Shop();//-->se simula una instancia de la variable, importante definir todos sus atributos para no tener NullPointerExceptions
        //shop.setId(1);
        shop.setName("mi tienda");
        shop.setStorageCapacity(50);
        shop.setPictures(new ArrayList<>());

        picture = new Picture();
        //picture.setId(1);
        picture.setName("mi pintura");
        picture.setAuthor("mi autor");
        picture.setEntryDate("20-01-2022");
        picture.setPrice(200);
    }

    @Test
    void createShop() {
        when(shopRepository.save(any(Shop.class))).thenReturn(shop);//-->se prueba el mock(simulado)
        assertEquals(shopService.createShop(shop), shop);//-->se prueba injectmocks
    }

    @Test
    void getAllShop() {
        when(shopRepository.findAll()).thenReturn(Arrays.asList(shop));
        assertNotNull(shopService.getAllShop());
    }

    @Test
    void updateShop() {
        when(shopRepository.save(any(Shop.class))).thenReturn(shop);
        assertEquals(shopService.updateShop(shop), shop);
    }

    @Test
    void findByIdShop() {
        when(shopRepository.findById(any(Integer.class))).thenReturn(Optional.of(shop));
        assertEquals(shopService.findByIdShop(shop.getId()), shop);
    }

    @Test
    void addPicture() {
        when(pictureRepository.save(any(Picture.class))).thenReturn(picture);
        when(shopRepository.findById(any(Integer.class))).thenReturn(Optional.of(shop));
        assertEquals(shopService.addPicture(shop.getId(), picture), picture);
    }

    @Test
    void getAllPicture() {
        when(shopRepository.findById(shop.getId())).thenReturn(Optional.of(shop));
        when(pictureRepository.findAll()).thenReturn(Arrays.asList(picture));
        assertNotNull(shopService.getAllPicture(shop.getId()));
    }

    @Test
    void deleteAllPicture() {
        when(shopRepository.findById(shop.getId())).thenReturn(Optional.of(shop));
        assertTrue(shopService.deleteAllPicture(shop.getId()));
    }
}