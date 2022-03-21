package com.whitecollar.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration//-->indica que es una clase de configuracion
@PropertySource("h2.properties")//-->archivo properties donde se definen las propiedades de configuracion H2
@Profile("h2")//-->nombre del perfil (h2), en el application.properties se define el perfil a usar por este nombre
public class H2Profile {
}
