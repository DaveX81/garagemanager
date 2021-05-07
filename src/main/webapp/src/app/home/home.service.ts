import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Vehicle} from '../vehicle/Vehicle';
import {Observable, timer} from 'rxjs';
import {switchMap} from 'rxjs/operators';
import {Configuration} from '../shared/configuration';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private httpClient: HttpClient) { }

  public getAllParkedVehicles(): Observable<Vehicle[]> {
    return timer(1, 5000).pipe(
      switchMap(() => this.httpClient.get<Vehicle[]>(Configuration.REST_URL.concat('/garage/parkedVehicles')))
    );
  }
  public getNumberOfFreeParkingPlaces(): Observable<number> {
    return timer(1, 5000).pipe(
      switchMap(() =>  this.httpClient.get<number>(Configuration.REST_URL.concat('/garage/freeParkingPlaces')))
    );
  }
}
