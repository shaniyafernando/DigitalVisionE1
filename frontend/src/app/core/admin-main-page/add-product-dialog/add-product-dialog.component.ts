import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
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
  selector: 'app-add-product-dialog',
  templateUrl: './add-product-dialog.component.html',
  styleUrls: ['./add-product-dialog.component.css']
})
export class AddProductDialogComponent implements OnInit {

  product!: Product;
  title!: String;
  buttonTitle!: String;
  categories: String[] = [];
  value! : String;

  constructor(public dialogRef: MatDialogRef<AddProductDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private productService: ProductService) {
      this.product = data.product;}

  ngOnInit(): void {
    if(this.product != null){
      this.title= "Edit existing product";
      this.productForm.get('title')?.setValue(this.product.title);
      this.productForm.get('description')?.setValue(this.product.description);
      this.productForm.get('url')?.setValue(this.product.image);
      this.productForm.get('category')?.setValue(this.product.category);
      this.productForm.get('brand')?.setValue(this.product.brand);
      this.productForm.get('colour')?.setValue(this.product.colour);
      this.productForm.get('price')?.setValue(this.product.price);
      this.productForm.get('inventory')?.setValue(this.product.quantity);
      this.productForm.get('description')?.setValue(this.product.description);
    }else{
      this.title="Add new product"}

    this.getCategories();
  }

  public getCategories(){
    this.categories = Object.values(Category);
  }

  

  productForm = new FormGroup({
    title: new FormControl('',Validators.required),
    description: new FormControl('',Validators.required),
    url: new FormControl('',Validators.required),
    category:new FormControl('',Validators.required) ,
    colour: new FormControl('',Validators.required),
    brand: new FormControl('',Validators.required),
    price: new FormControl(0,Validators.required),
    inventory:new FormControl(0,Validators.required) 
  });

  public onSubmit(): void {
    const productDetails = {} as Product | any;
    productDetails.id = this.product.id;
    productDetails.title = this.productForm.get('title')?.value;
    productDetails.description = this.productForm.get('description')?.value;
    productDetails.image = this.productForm.get('url')?.value;
    productDetails.category = this.productForm.get('category')?.value;
    productDetails.colour = this.productForm.get('colour')?.value;
    productDetails.brand = this.productForm.get('brand')?.value;
    productDetails.price = this.productForm.get('price')?.value;
    productDetails.quantity = this.productForm.get('quantity')?.value;

    
    if(this.product == null){
      this.productService.addNewProduct(productDetails).subscribe(
        response => console.log(response)
      );
    }
    
    this.productService.updateProduct(productDetails).subscribe(
      response => console.log(response)
    );
    
  }

}
