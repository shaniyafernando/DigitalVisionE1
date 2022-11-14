import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ProductDetailsDTO } from 'src/app/dtos/productDetailsDTO';
import { SearchDTO } from 'src/app/dtos/SearchDTO';
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
  productDetailsFeatures: ProductDetailsDTO = {} as ProductDetailsDTO;
  value : string = "";
  query: string = "";
  minPrice: number = 0;
  maxPrice: number = 0;
  searchDTO!: SearchDTO ;
  

  constructor(public productService: ProductService) {
   }

  ngOnInit(): void {
    // this.getAllProducts();
    this.getCategories();
    this.allowFeatures();
  }

  public allowFeatures(): void{
// Note from Shaniya to Disal: an unregistered user can't access the add to wishlist and remove from wishlist buttons.

    this.productDetailsFeatures.showAddToWishListButton = true;
    this.productDetailsFeatures.showGoBackButton = true;
    this.productDetailsFeatures.showQuantityFormField = true;
  }

  public getCategories(){
    this.categories = Object.values(Category);
    
  }

  

  public viewProductDetails(product: Product){
    this.showProductDetail = true;
    this.productDetails = product;
  }

  public viewProductList(value: boolean){
    this.showProductDetail = value;
  }


  // public getAllProducts(): any {
  //   this.searchDTO.query = this.query;
  //   this.searchDTO.minPrice = this.minPrice;
  //   this.searchDTO.maxPrice = this.maxPrice;
  //   this.searchDTO.category = this.value;
  //   // this.productService.getAllProducts(this.searchDTO).subscribe
  //   // (
  //   //   (response: any[]) => {
  //   //     this.products = response;
  //   //     console.log(this.products);
  //   //     if(this.products == null){
  //   //       this.noProductData = true;
  //   //     }
  //   //   },
  //   //   (error: HttpErrorResponse) => {
  //   //     alert(error.message);
  //   //   }
  //   // );
  // }

}
