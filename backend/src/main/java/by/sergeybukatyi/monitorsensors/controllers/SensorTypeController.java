package by.sergeybukatyi.monitorsensors.controllers;

import by.sergeybukatyi.monitorsensors.entities.SensorType;
import by.sergeybukatyi.monitorsensors.services.SensorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/types")
@CrossOrigin("*")
public class SensorTypeController {
    SensorTypeService sensorTypeService;

    @Autowired SensorTypeController(SensorTypeService sensorTypeService){
        this.sensorTypeService =sensorTypeService;
    }
    @GetMapping
    public ArrayList<SensorType> getAllSensorTypes(){
        return sensorTypeService.getAllSensorTypes();
    }
}
