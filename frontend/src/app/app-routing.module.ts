import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailComponent } from './common/product-detail/product-detail.component';
import { AdminMainPageComponent } from './core/admin-main-page/admin-main-page.component';
import { ProductFormComponent } from './core/admin-main-page/product-form/product-form.component';
import { LoginComponent } from './core/authentication/login/login.component';
import { RegisterComponent } from './core/authentication/register/register.component';
import { ProductListComponent } from './core/user-main-page/product-list/product-list.component';
import { WishListComponent } from './core/user-main-page/wish-list/wish-list.component';

const routes: Routes = [
  { path: '', component: ProductListComponent },
  { path: 'wish-list', component: WishListComponent },
  { path: 'product-details', component: ProductDetailComponent },
  { path: 'product-form', component: ProductFormComponent },
  { path: 'admin-panel', component: AdminMainPageComponent },
  {path:'register', component: RegisterComponent},
  {path:'login', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

