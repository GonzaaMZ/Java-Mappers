package org.example.modelmapper;

import org.example.modelmapper.dto.PersonCustomDto;
import org.example.modelmapper.dto.PersonDefaultDto;
import org.example.modelmapper.entities.Person;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class Main {

    /* Model Mappper - Default */
   /* public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        Person person = new  Person(1L, "John", "Smith", "john@example.com", (byte) 50, 'M');

        System.out.println(person);

        PersonDefaultDto personDefaultDto = modelMapper.map(person, PersonDefaultDto.class);
        System.out.println(personDefaultDto);
    }
    */

    // Model Mapper - Custom
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        TypeMap<Person, PersonCustomDto> propertyMap = modelMapper.createTypeMap(Person.class, PersonCustomDto.class);
        propertyMap.addMapping(Person::getId, PersonCustomDto::setIdDTO);
        propertyMap.addMapping(Person::getName, PersonCustomDto::setNameDTO);
        propertyMap.addMapping(Person::getLastName, PersonCustomDto::setLastNameDTO);
        propertyMap.addMapping(Person::getEmail, PersonCustomDto::setEmailDTO);
        propertyMap.addMapping(Person::getAge, PersonCustomDto::setAgeDTO);
        propertyMap.addMapping(Person::getGender, PersonCustomDto::setGenderDTO);

        Person person = new  Person(1L, "John", "Smith", "john@example.com", (byte) 50, 'M');

        System.out.println(person);

        PersonCustomDto personCustomDto = propertyMap.map(person);
        System.out.println(personCustomDto);

    }
}