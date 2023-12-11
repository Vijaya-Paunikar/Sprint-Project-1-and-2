import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { VendorComponent } from './vendor/vendor.component';
import { ServicesComponent } from './services/services.component';
import { UserComponent } from './user/user.component';
import { OrderComponent } from './order/order.component';
import { CartComponent } from './cart/cart.component';
import { RoleComponent } from './role/role.component';
import { RatingReviewComponent } from './rating-review/rating-review.component';
import { AboutComponent } from './about/about.component';
import { AuthComponent } from './auth/auth.component';

const routes: Routes = [
  { path:'', component: HomeComponent },
  { path:'home', component: HomeComponent },
  { path:'about', component:AboutComponent },
  { path:'user', component: UserComponent },
  { path:'vendor', component: VendorComponent },
  { path:'services', component: ServicesComponent },
  { path:'orders', component: OrderComponent },
  { path:'cart', component: CartComponent },
  { path:'role', component: RoleComponent },
  { path:'rating-review', component: RatingReviewComponent },
  { path:'auth', component: AuthComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
