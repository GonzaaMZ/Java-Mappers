package org.example.mapstruct.mapper;

import org.example.mapstruct.dto.PersonCustomDto;
import org.example.mapstruct.dto.PersonDefaultDto;
import org.example.mapstruct.entities.Person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDefaultDto personToPersonDefaultDto(Person person);

    @Mapping(source = "id", target = "idDTO")
    @Mapping(source = "name", target = "nameDTO")
    @Mapping(source = "lastName", target = "lastNameDTO")
    @Mapping(source = "email", target = "emailDTO")
    @Mapping(source = "age", target = "ageDTO")
    @Mapping(source = "gender", target = "genderDTO")
    PersonCustomDto personToPersonCustomDto(Person person);
}
