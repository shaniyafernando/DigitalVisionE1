import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-wish-list',
  templateUrl: './wish-list.component.html',
  styleUrls: ['./wish-list.component.css']
})
export class WishListComponent implements OnInit {

  products: Product[]=[];
  noProductData: boolean = false;
  showProductDetail: boolean = false;
  productDetails!: Product;
  categories: string[] = [];
  

  constructor(public productService: ProductService) { }

  ngOnInit(): void {
    this.getAllProducts();
  }

  public viewProductDetails(product: Product){
    this.showProductDetail = true;
    this.productDetails = product;
  }

  public viewProductList(value: boolean){
    this.showProductDetail = value;
  }

  public getAllProducts():void{
    this.productService.getAllProducts().subscribe
    (
      (response: Product[]) => {
        this.products = response;
        console.log(this.products);
        if(this.products == null){
          this.noProductData = true;
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
