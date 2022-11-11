import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

enum Category{
  Stands = "Stands",
  AutomobileCradles = "Automobile Cradles",
  Grips = "Grips",
  ScreenExpandersAndMagnifiers = "Screen Expanders & Magnifiers",
  HandheldGimbalsAndStabilizers = "Handheld Gimbals & Stabilizers"
}

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[]=[];
  noProductData: boolean = false;
  showProductDetail: boolean = false;
  productDetails!: Product;
  categories: string[] = [];
  

  constructor(public productService: ProductService) { }

  ngOnInit(): void {
    this.getAllProducts();
    this.getCategories();
  }

  public getCategories(): void{
    this.categories = Object.values(Category);
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
