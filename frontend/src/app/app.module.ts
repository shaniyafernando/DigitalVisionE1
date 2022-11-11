import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

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

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProductListComponent } from './core/product-list/product-list.component';
import { ProductCardComponent } from './common/product-card/product-card.component';
import { ProductDetailComponent } from './common/product-detail/product-detail.component';
import { WishListComponent } from './core/wish-list/wish-list.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCardComponent,
    ProductDetailComponent,
    WishListComponent
  ],
  imports: [
    BrowserModule,
    MatRadioModule,
    MatDividerModule,
    AppRoutingModule,
    MatButtonModule,
    MatCardModule,
    MatProgressBarModule,
    HttpClientModule,
    MatIconModule,
    MatToolbarModule,
    MatSidenavModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
