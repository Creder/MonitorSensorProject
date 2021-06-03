
import { SensorType } from './sensortype';
import { SensorUnit } from './sensorunit';

export interface Sensor{
	id: number;
	name: string;
	model: string;
	rangeFrom : number;
	rangeTo: number;
	type: SensorType;
	unit: SensorUnit;
	location: string;
	description: string

}

