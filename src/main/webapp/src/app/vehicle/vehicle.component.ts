import {Component, OnDestroy, OnInit} from '@angular/core';
import {VehicleService} from './vehicle.service';
import {Vehicle} from './Vehicle';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.scss']
})
export class VehicleComponent implements OnInit, OnDestroy {
  vehicles: Vehicle[] = [];
  private vehicleSubscription = new Subscription();

  constructor(private vehicleService: VehicleService) { }

  ngOnInit(): void {
    this.vehicleSubscription = this.vehicleService.getAllVehicles().subscribe((data: Vehicle[]) => {
      this.vehicles = data;
    });
  }

  public ngOnDestroy(): void {
    this.vehicleSubscription.unsubscribe();
  }
}
