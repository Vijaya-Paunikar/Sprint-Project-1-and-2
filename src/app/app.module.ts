import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { VendorComponent } from './vendor/vendor.component';

import { HttpClientModule } from '@angular/common/http';
import { ServicesComponent } from './services/services.component';
import { UserComponent } from './user/user.component';
import { OrderComponent } from './order/order.component';
import { CartComponent } from './cart/cart.component';
import { RoleComponent } from './role/role.component';
import { RatingReviewComponent } from './rating-review/rating-review.component';
import { AboutComponent } from './about/about.component';
import { AuthComponent } from './auth/auth.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    VendorComponent,
    ServicesComponent,
    UserComponent,
    OrderComponent,
    CartComponent,
    RoleComponent,
    RatingReviewComponent,
    AboutComponent,
    AuthComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
