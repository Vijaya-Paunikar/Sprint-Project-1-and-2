import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor.model';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css'],
})
export class VendorComponent implements OnInit {
  vendors: Vendor[] = [];
  selectedVendor: Vendor = new Vendor();
  isNewVendor: boolean = false;

  constructor(private vendorService: VendorService) {}

  ngOnInit(): void {
    this.loadVendors();
  }

  loadVendors(): void {
    this.vendorService.getAllVendors().subscribe((vendors) => {
      this.vendors = vendors;
    });
  }

  editVendor(vendor: Vendor): void {
    this.selectedVendor = { ...vendor };
    this.isNewVendor = true;
    this.openModal();
  }

  createVendor(): void {
    this.isNewVendor = true;
    this.selectedVendor = new Vendor();
    this.openModal();
  }

  saveVendor(): void {
    if (this.isNewVendor) {
      this.vendorService.createVendor(this.selectedVendor).subscribe(() => {
        this.loadVendors();
        this.cancelEdit();
      });
    } else {
      this.vendorService.updateVendor(this.selectedVendor.vendorID, this.selectedVendor).subscribe(() => {
        this.loadVendors();
        this.cancelEdit();
      });
    }
  }

  deleteVendor(id: number): void {
    this.vendorService.deleteVendor(id).subscribe(() => {
      this.loadVendors();
      this.cancelEdit();
    });
  }

  cancelEdit(): void {
    this.selectedVendor = new Vendor();
    this.isNewVendor = false;
    this.closeModal();
  }

  // Additional methods for modal handling
  openModal(): void {
    const modal = document.getElementById('vendorModal');
    if (modal) {
      modal.style.display = 'block';
    }
  }

  closeModal(): void {
    const modal = document.getElementById('vendorModal');
    if (modal) {
      modal.style.display = 'none';
    }
  }
}
