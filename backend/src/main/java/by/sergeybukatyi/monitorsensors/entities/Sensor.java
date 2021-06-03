package by.sergeybukatyi.monitorsensors.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sensors")
public class Sensor implements Serializable {

  private static final long serialVersionUID = 587024173182249712L;

  @Id
  @Column(name="sensor_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @Size(max = 30)
  @Column(name = "name", nullable = false, length = 30, unique = true)
  private String name;

  @NotEmpty
  @Size(max = 15)
  @Column(name = "model", nullable = false, length = 15, unique = true)
  private String model;

  @Column(name = "range_from")
  private int rangeFrom;

  @Column(name = "range_to")
  private int rangeTo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "type_id", nullable = false)
  private SensorType type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "unit_id", nullable = false)
  private SensorUnit unit;

  @Size(max = 40)
  @Column(name = "location", length = 40)
  private String location;

  @Size(max = 200)
  @Column(name = "description", length = 200)
  private String description;

  public Sensor(){};

  public Sensor(String name, String model,
      SensorType type, int rangeFrom, int rangeTo, SensorUnit unit, String location, String description) {
    this.name = name;
    this.model = model;
    this.type = type;
    this.rangeFrom = rangeFrom;
    this.rangeTo = rangeTo;
    this.unit = unit;
    this.location = location;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public SensorType getType() {
    return type;
  }

  public void setType(SensorType type) {
    this.type = type;
  }

  public int getRangeFrom() {
    return rangeFrom;
  }

  public int getRangeTo() {
    return rangeTo;
  }

  public void setRangeFrom(int rangeFrom) {
    this.rangeFrom = rangeFrom;
  }

  public void setRangeTo(int rangeTo) {
    this.rangeTo = rangeTo;
  }

  public SensorUnit getUnit() {
    return unit;
  }

  public void setUnit(SensorUnit unit) {
    this.unit = unit;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return rangeFrom == sensor.rangeFrom &&
                rangeTo == sensor.rangeTo &&
                name.equals(sensor.name) &&
                model.equals(sensor.model) &&
                type.equals(sensor.type) &&
                unit.equals(sensor.unit) &&
                Objects.equals(location, sensor.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, rangeFrom, rangeTo, type, unit, location);
    }


}
