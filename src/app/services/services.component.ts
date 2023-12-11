import { Component, OnInit } from '@angular/core';
import { Service } from '../service.model';
import { ServiceService } from '../services.service';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {
  services: Service[] = [];
  selectedService: Service = new Service();
  isNewService: boolean = false;

  constructor(private serviceService: ServiceService) {}

  ngOnInit(): void {
    this.loadServices();
  }

  loadServices(): void {
    this.serviceService.getAllServices().subscribe((services) => {
      this.services = services;
    });
  }

  editService(service: Service): void {
    this.selectedService = { ...service };
    this.isNewService = true;
    this.openModal();
  }

  createService(): void {
    this.isNewService = true;
    this.selectedService = new Service();
    this.openModal();
  }

  saveService(): void {
    if (this.isNewService) {
      this.serviceService.createService(this.selectedService).subscribe(() => {
        this.loadServices();
        this.cancelEdit();
      });
    } else {
      this.serviceService.updateService(this.selectedService.serviceID, this.selectedService).subscribe(() => {
        this.loadServices();
        this.cancelEdit();
      });
    }
  }

  deleteService(id: number): void {
    this.serviceService.deleteService(id).subscribe(() => {
      this.loadServices();
      this.cancelEdit();
    });
  }

  cancelEdit(): void {
    this.selectedService = new Service();
    this.isNewService = false;
    this.closeModal();
  }

  // Additional methods for modal handling
  openModal(): void {
    const modal = document.getElementById('serviceModal');
    if (modal) {
      modal.style.display = 'block';
    }
  }

  closeModal(): void {
    const modal = document.getElementById('serviceModal');
    if (modal) {
      modal.style.display = 'none';
    }
  }
}
