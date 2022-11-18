import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  

  showAddToWishListButton: boolean = false;
  showRemoveFromWishListButton: boolean = false;
  showQuantityFormField: boolean = false;
  showGoBackButton: boolean = false;
  showEditActionButton: boolean = false;
  showDeleteActionButton: boolean = false;

  data!:any;

  finalProduct!: Product;
  finalComponent!: String;
  quantityForm!: FormGroup;

  constructor(private router: Router, private productService: ProductService, private fb : FormBuilder) { }

  ngOnInit(): void {
    this.data = history.state.data;
    this.finalProduct = this.data.product;
    this.finalComponent = this.data.component;
    this.displayButtons();
    this.fb.group({
      quantity: new FormControl(0,[Validators.required])
    });
  }

  public onSubmit(){}

  public displayButtons():void{
    if(this.finalComponent == 'AdminMainPageComponent'){
      this.showAddToWishListButton= false;
      this.showRemoveFromWishListButton = false;
      this.showQuantityFormField = false;
      this.showGoBackButton = false;
      this.showEditActionButton = true;
      this.showDeleteActionButton= true;
    }
    if(this.finalComponent == 'ProductListComponent'){
      this.showAddToWishListButton = true;
      this.showRemoveFromWishListButton = false;
      this.showQuantityFormField = false;
      this.showGoBackButton = true;
      this.showEditActionButton= false;
      this.showDeleteActionButton= false;
    }
    if(this.finalComponent == 'PublicMainPageComponent'){
      this.showAddToWishListButton= false;
      this.showRemoveFromWishListButton = false;
      this.showQuantityFormField = false;
      this.showGoBackButton= true;
      this.showEditActionButton= false;
      this.showDeleteActionButton= false;
    }
  }

  public navigateToPreviousPage(component:String):void{
    if(component == 'ProductListComponent'){
      this.router.navigate(['']);
    }

    if(component == 'WishListComponent'){
      this.router.navigate(['/wish-list']);
    }
  }

  public navigateToProductForm(product:Product){
      this.router.navigate(['/product-form'], {state: {data: {title:'Edit product',product: product}}});
  }

  public deleteProduct(id:number){
      this.productService.deleteProduct(id);
  }


}
