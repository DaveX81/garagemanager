import {Component, OnDestroy, OnInit} from '@angular/core';
import {Vehicle} from '../vehicle/Vehicle';
import {HomeService} from './home.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {

  vehicles: Vehicle[] = [];
  numberOfFreeParkingPlaces = 0;
  private parkedCarSubscription: Subscription = new Subscription();
  private freeParkedCarsSubscription: Subscription = new Subscription();

  constructor(private homeService: HomeService) { }

  ngOnInit(): void {
    this.parkedCarSubscription = this.homeService.getAllParkedVehicles().subscribe((data: Vehicle[]) => {
      this.vehicles = data;
    });
    this.freeParkedCarsSubscription = this.homeService.getNumberOfFreeParkingPlaces().subscribe((freePlaces: number) => {
      this.numberOfFreeParkingPlaces = freePlaces;
    });
  }

  public ngOnDestroy(): void {
    this.parkedCarSubscription.unsubscribe();
    this.freeParkedCarsSubscription.unsubscribe();
  }
}
