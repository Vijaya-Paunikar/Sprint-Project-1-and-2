export class Service {
    serviceID: number;
    name: string;
    description: string;
    price: number;
  
    constructor(serviceID?: number, name?: string, description?: string, price?: number) {
      this.serviceID = serviceID || 0;
      this.name = name || '';
      this.description = description || '';
      this.price = price || 0;
    }
}
