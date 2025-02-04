import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './not-found/not-found.component';
import { OrdersListComponent } from './orders-list/orders-list.component';
import { OrdersComponent } from './orders/orders.component';

const routes: Routes=[
  {path:'',component:OrdersListComponent,pathMatch:'full'},
  {path:'**',component:NotFoundComponent}
]

@NgModule({
  declarations:[
    OrdersListComponent,
    OrdersComponent,
    NotFoundComponent
  ],
  imports: [RouterModule.forRoot(routes), CommonModule, ReactiveFormsModule, FormsModule],
  exports: [RouterModule]
})

export class AppRoutingModule { }
