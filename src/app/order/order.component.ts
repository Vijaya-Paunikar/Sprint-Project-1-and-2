import { Component, OnInit } from '@angular/core';
import { Order } from '../order.model';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  orders: Order[] = [];
  selectedOrder: Order = new Order();
  isNewOrder: boolean = false;

  constructor(private orderService: OrderService) {}

  ngOnInit(): void {
    this.loadOrders();
  }

  loadOrders(): void {
    this.orderService.getAllOrders().subscribe((orders) => {
      this.orders = orders;
    });
  }

  editOrder(order: Order): void {
    this.selectedOrder = { ...order };
    this.isNewOrder = true;
    this.openModal();
  }

  createOrder(): void {
    this.isNewOrder = true;
    this.selectedOrder = new Order();
    this.openModal();
  }

  saveOrder(): void {
    if (this.isNewOrder) {
      this.orderService.createOrder(this.selectedOrder).subscribe(() => {
        this.loadOrders();
        this.cancelEdit();
      });
    } else {
      this.orderService.updateOrder(this.selectedOrder.orderId, this.selectedOrder).subscribe(() => {
        this.loadOrders();
        this.cancelEdit();
      });
    }
  }

  deleteOrder(id: number): void {
    this.orderService.deleteOrder(id).subscribe(() => {
      this.loadOrders();
      this.cancelEdit();
    });
  }

  cancelEdit(): void {
    this.selectedOrder = new Order();
    this.isNewOrder = false;
    this.closeModal();
  }

  // Additional methods for modal handling
  openModal(): void {
    const modal = document.getElementById('orderModal');
    if (modal) {
      modal.style.display = 'block';
    }
  }

  closeModal(): void {
    const modal = document.getElementById('orderModal');
    if (modal) {
      modal.style.display = 'none';
    }
  }
}
