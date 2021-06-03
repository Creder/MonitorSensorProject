package by.sergeybukatyi.monitorsensors.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "sensor_units")
public class SensorUnit implements Serializable {

  private static final long serialVersionUID = -1849185653895806788L;
  @Id
  @Column(name="unit_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Column(name = "name")
  private String unitName;

  @JsonIgnore
  @OneToMany(mappedBy = "unit", fetch = FetchType.LAZY)
  private List<Sensor> sensors;

  public SensorUnit(){}

  public SensorUnit(String unitName) {
    this.unitName = unitName;
  }
  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SensorUnit that = (SensorUnit) o;
    return unitName.equals(that.unitName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unitName);
  }

  @Override

  public String toString() {
    return unitName;
  }
}
