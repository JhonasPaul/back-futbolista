package com.ortiz.jonathan.entity.mapper;

import com.ortiz.jonathan.entity.Futbolista;
import com.ortiz.jonathan.entity.dtos.FutbolistaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FutbolistaMapper {

    FutbolistaDto toFutbolistaDto(Futbolista futbolista);
}
