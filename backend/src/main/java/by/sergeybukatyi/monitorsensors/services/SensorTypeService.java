package by.sergeybukatyi.monitorsensors.services;

import by.sergeybukatyi.monitorsensors.entities.SensorType;
import by.sergeybukatyi.monitorsensors.persistence.JpaSensorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SensorTypeService {

    JpaSensorTypeRepository jpaSensorTypeRepository;

    @Autowired SensorTypeService( JpaSensorTypeRepository jpaSensorTypeRepository){
        this.jpaSensorTypeRepository = jpaSensorTypeRepository;
    }
    public ArrayList<SensorType> getAllSensorTypes() {
        return jpaSensorTypeRepository.getAll();
    }
}
