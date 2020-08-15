package com.example.Recipe.Recipe.services;

import java.util.Set;

import com.example.Recipe.Recipe.command.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}