import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductListComponent } from './core/user-main-page/product-list/product-list.component';
import { WishListComponent } from './core/user-main-page/wish-list/wish-list.component';

const routes: Routes = [
  { path: '', component: ProductListComponent },
  { path: 'wish-list', component: WishListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

