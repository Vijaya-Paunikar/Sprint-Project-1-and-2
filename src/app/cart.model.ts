// cart.model.ts
export class Cart {
    cartID: number;
    date: string; // Assuming date is a string, adjust the type as per your data model
    isActive: boolean;
    itemCount: number;
    totalAmount: number;
    specialInstructions: string;
    deliveryAddress: string;
  
    constructor(
      cartID?: number,
      date?: string,
      isActive?: boolean,
      itemCount?: number,
      totalAmount?: number,
      specialInstructions?: string,
      deliveryAddress?: string
    ) {
      this.cartID = cartID || 0;
      this.date = date || '';
      this.isActive = isActive || false;
      this.itemCount = itemCount || 0;
      this.totalAmount = totalAmount || 0;
      this.specialInstructions = specialInstructions || '';
      this.deliveryAddress = deliveryAddress || '';
    }
  }
  