import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PackagePageComponent} from "./components/pages/package-page/package-page.component";
import {EnterprisePageComponent} from "./components/pages/enterprise-page/enterprise-page.component";

const routes: Routes = [
  { path: '', redirectTo: '/enterprises', pathMatch: 'full' },
  { path: 'enterprises', component: EnterprisePageComponent },
  { path: 'packages', component: PackagePageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
