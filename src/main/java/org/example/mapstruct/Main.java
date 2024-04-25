package org.example.mapstruct;


import org.example.mapstruct.dto.PersonCustomDto;
import org.example.mapstruct.dto.PersonDefaultDto;
import org.example.mapstruct.entities.Person;
import org.example.mapstruct.mapper.PersonMapper;

public class Main {

    // MapStruct - Default
   /* public static void main(String[] args) {

        Person person = new Person(1L, "John", "Smith", "john@example.com", (byte) 50, 'M');

        System.out.println(person);

        PersonDefaultDto personDefaultDto = PersonMapper.INSTANCE.personToPersonDefaultDto(person);
    }
    */

    // MapStruct - Custom
    public static void main(String[] args) {

        Person person = new Person(1L, "John", "Smith", "john@example.com", (byte) 50, 'M');

        System.out.println(person);

        PersonCustomDto personCustomDto = PersonMapper.INSTANCE.personToPersonCustomDto(person);
        System.out.println(personCustomDto);
    }
}
