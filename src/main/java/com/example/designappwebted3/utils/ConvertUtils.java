package com.example.designappwebted3.utils;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public record ConvertUtils<T>(ModelMapperConfiguration modelMapperConfiguration) {

    public T convertToObject(T object, Class<T> type){
        return modelMapperConfiguration.modelMapper().map(object, type);
    }

    public List<T> convertListToObject(List<T> objects, Class<T> type){
        return objects.stream()
                .map(object -> modelMapperConfiguration.modelMapper().map(object, type))
                .collect(Collectors.toList());
    }

}
