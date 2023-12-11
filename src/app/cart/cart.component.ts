import { Component, OnInit } from '@angular/core';
import { Cart } from '../cart.model';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  carts: Cart[] = [];
  selectedCart: Cart = new Cart();
  isNewCart: boolean = false;

  constructor(private cartService: CartService) {}

  ngOnInit(): void {
    this.loadCarts();
  }

  loadCarts(): void {
    this.cartService.getAllCarts().subscribe((carts) => {
      this.carts = carts;
    });
  }

  editCart(cart: Cart): void {
    this.selectedCart = { ...cart };
    this.isNewCart = true;
    this.openModal();
  }

  createCart(): void {
    this.isNewCart = true;
    this.selectedCart = new Cart();
    this.openModal();
  }

  saveCart(): void {
    if (this.isNewCart) {
      this.cartService.createCart(this.selectedCart).subscribe(() => {
        this.loadCarts();
        this.cancelEdit();
      });
    } else {
      this.cartService.updateCart(this.selectedCart.cartID, this.selectedCart).subscribe(() => {
        this.loadCarts();
        this.cancelEdit();
      });
    }
  }

  deleteCart(id: number): void {
    this.cartService.deleteCart(id).subscribe(() => {
      this.loadCarts();
      this.cancelEdit();
    });
  }

  cancelEdit(): void {
    this.selectedCart = new Cart();
    this.isNewCart = false;
    this.closeModal();
  }

  // Additional methods for modal handling
  openModal(): void {
    const modal = document.getElementById('cartModal');
    if (modal) {
      modal.style.display = 'block';
    }
  }

  closeModal(): void {
    const modal = document.getElementById('cartModal');
    if (modal) {
      modal.style.display = 'none';
    }
  }
}
