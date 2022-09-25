import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SidebarComponent } from './components/partials/sidebar/sidebar.component';
import {NzLayoutModule} from "ng-zorro-antd/layout";
import {NzMenuModule} from "ng-zorro-antd/menu";
import {NzIconModule} from "ng-zorro-antd/icon";
import {NzToolTipModule} from "ng-zorro-antd/tooltip";
import {NzWaveModule} from "ng-zorro-antd/core/wave";
import {NzButtonModule} from "ng-zorro-antd/button";
import { TableComponent } from './components/partials/table/table.component';
import {NzTableModule} from "ng-zorro-antd/table";
import {NzInputModule} from "ng-zorro-antd/input";
import {NzPopconfirmModule} from "ng-zorro-antd/popconfirm";
import { HeaderbarComponent } from './components/partials/headerbar/headerbar.component';
import { LayoutComponent } from './components/layouts/layout/layout.component';
import {NzBreadCrumbModule} from "ng-zorro-antd/breadcrumb";
import { ButtonComponent } from './components/partials/button/button.component';
import { BadgeComponent } from './components/partials/badge/badge.component';
import {NzGridModule} from "ng-zorro-antd/grid";
import {NzFormModule} from "ng-zorro-antd/form";
import {NzSelectModule} from "ng-zorro-antd/select";
import {NzTimePickerModule} from "ng-zorro-antd/time-picker";
import {NzDatePickerModule} from "ng-zorro-antd/date-picker";
import {NzInputNumberModule} from "ng-zorro-antd/input-number";
import { EnterpriseComponent } from './components/forms/enterprise/enterprise.component';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    TableComponent,
    HeaderbarComponent,
    LayoutComponent,
    ButtonComponent,
    BadgeComponent,
    EnterpriseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzLayoutModule,
    NzMenuModule,
    NzIconModule,
    NzToolTipModule,
    NzWaveModule,
    NzButtonModule,
    NzTableModule,
    NzInputModule,
    NzPopconfirmModule,
    NzBreadCrumbModule,
    NzGridModule,
    ReactiveFormsModule,
    NzFormModule,
    NzSelectModule,
    NzTimePickerModule,
    NzDatePickerModule,
    NzInputNumberModule
  ],
  providers: [
    { provide: NZ_I18N, useValue: en_US }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
