
export class Order {
    orderId: number;
    date: Date;
    totalAmount: number;
    
    constructor(orderId?: number, date?: Date, totalAmount?: number) {
      this.orderId = orderId || 0;
      this.date = date || new Date();
      this.totalAmount = totalAmount || 0;
    }
  }
  