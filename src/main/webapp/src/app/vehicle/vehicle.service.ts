import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Vehicle} from './Vehicle';
import {Observable} from 'rxjs';
import {Configuration} from '../shared/configuration';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private httpClient: HttpClient) { }

  public getAllVehicles(): Observable<Vehicle[]> {
    return this.httpClient.get<Vehicle[]>(Configuration.REST_URL.concat('/vehicles'));
  }

  public addVehicle(vehicle: Vehicle): any {
    return this.httpClient.post(Configuration.REST_URL.concat('/vehicles'), vehicle);
  }
}
