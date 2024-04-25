package org.example.orikamapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.example.modelmapper.dto.PersonCustomDto;
import org.example.modelmapper.dto.PersonDefaultDto;
import org.example.modelmapper.entities.Person;

public class main {

    // Orika mapper - Default
//    public static void main(String[] args) {
//        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//
//        mapperFactory.classMap(Person.class, PersonDefaultDto.class);
//
//        MapperFacade mapper = mapperFactory.getMapperFacade();
//
//        Person person = new Person(1L, "John", "Smith", "john@example.com", (byte) 50, 'M');
//
//        System.out.println(person);
//
//        PersonDefaultDto personDefaultDto = mapper.map(person, PersonDefaultDto.class);
//
//        System.out.println(personDefaultDto);
//    }


    // Orika mapper - Custom
    public static void main(String[] args) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Person.class, PersonCustomDto.class)
                .field("id", "idDTO")
                .field("name", "nameDTO")
                .field("lastName", "lastNameDTO")
                .field("email", "emailDTO")
                .field("age", "ageDTO")
                .field("gender", "genderDTO")
                .byDefault()
                .register();

        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        Person person = new Person(1L, "John", "Smith", "john@example.com", (byte) 50, 'M');
        System.out.println(person);

        PersonCustomDto personCustomDto = mapperFacade.map(person, PersonCustomDto.class);
        System.out.println(personCustomDto);
    }
}
