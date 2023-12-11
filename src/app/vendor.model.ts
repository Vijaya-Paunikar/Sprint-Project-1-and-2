export class Vendor {
    vendorID: number;
    vendorName: string;
    description: string;
    contact: string;  // Assuming contact is a string, adjust the type as per your data model
  
    constructor(vendorID?: number, vendorName?: string, description?: string, contact?: string) {
      this.vendorID = vendorID || 0;
      this.vendorName = vendorName || '';
      this.description = description || '';
      this.contact = contact || '';
    }
  }
  