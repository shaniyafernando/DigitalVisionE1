import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatDividerModule} from '@angular/material/divider';
import { HttpClientModule } from '@angular/common/http';
import {MatRadioModule} from '@angular/material/radio';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatDialogModule} from '@angular/material/dialog';
import {MatSelectModule} from '@angular/material/select';
import { ReactiveFormsModule } from '@angular/forms';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatSnackBarModule} from '@angular/material/snack-bar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProductListComponent } from './core/user-main-page/product-list/product-list.component';
import { ProductCardComponent } from './common/product-card/product-card.component';
import { ProductDetailComponent } from './common/product-detail/product-detail.component';
import { WishListComponent } from './core/user-main-page/wish-list/wish-list.component';
import { UserMainPageComponent } from './core/user-main-page/user-main-page.component';
import { AdminMainPageComponent } from './core/admin-main-page/admin-main-page.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ProductFormComponent } from './core/admin-main-page/product-form/product-form.component';
import { LoginComponent } from './core/authentication/login/login.component';
import { RegisterComponent } from './core/authentication/register/register.component';
import { PublicMainPageComponent } from './core/public-main-page/public-main-page.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCardComponent,
    ProductDetailComponent,
    WishListComponent,
    UserMainPageComponent,
    AdminMainPageComponent,
    ProductFormComponent,
    LoginComponent,
    RegisterComponent,
    PublicMainPageComponent
  ],
  imports: [
    BrowserModule,
    MatRadioModule,
    MatDividerModule,
    FormsModule,
    MatPaginatorModule,
    AppRoutingModule,
    MatSnackBarModule,
    MatButtonModule,
    MatCardModule,
    MatProgressBarModule,
    HttpClientModule,
    MatIconModule,
    MatSelectModule,
    MatToolbarModule,
    MatSidenavModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatGridListModule,
    FlexLayoutModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
