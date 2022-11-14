import { Dialog } from '@angular/cdk/dialog';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig} from '@angular/material/dialog';
import { ProductDetailsDTO } from 'src/app/dtos/productDetailsDTO';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';
import { AddProductDialogComponent } from './add-product-dialog/add-product-dialog.component';

@Component({
  selector: 'app-admin-main-page',
  templateUrl: './admin-main-page.component.html',
  styleUrls: ['./admin-main-page.component.css']
})
export class AdminMainPageComponent implements OnInit {

  products!: Product[] ;
  feature!: ProductDetailsDTO;
  newProduct! : Product;

  constructor(public dialog: MatDialog,
    public productService: ProductService) { }

  ngOnInit(): void {
    this.applyProductDetailsFeatures();
    this.getAllProducts();
  }

  public applyProductDetailsFeatures(){
    this.feature.showAddToWishListButton = false;
    this.feature.showGoBackButton = false;
    this.feature.showQuantityFormField = false;
  }


  public openDialog( product : Product): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.width = "50vw";
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {product: product};

    this.dialog.open(AddProductDialogComponent,dialogConfig);                  
  }

  public getAllProducts(){
    this.productService.getAllProducts().subscribe(
      (response) => this.products = response
    );
  }

}
