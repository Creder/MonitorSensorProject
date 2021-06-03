package by.sergeybukatyi.monitorsensors.controllers;

import by.sergeybukatyi.monitorsensors.entities.SensorUnit;
import by.sergeybukatyi.monitorsensors.services.SensorUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/units")
@CrossOrigin("*")
public class SensorUnitController {
    SensorUnitService sensorUnitService;

    @Autowired
    SensorUnitController(SensorUnitService sensorUnitService){
        this.sensorUnitService = sensorUnitService;
    }
    @GetMapping
    public ArrayList<SensorUnit> getAllSensorTypes(){
        return sensorUnitService.getAllSensorUnits();
    }
}
