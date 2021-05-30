package io.github.jass2125.gatling.mapper;

import io.github.jass2125.gatling.dto.PersonRequest;
import io.github.jass2125.gatling.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {

    public abstract Person toPerson(PersonRequest personRequest);

}
