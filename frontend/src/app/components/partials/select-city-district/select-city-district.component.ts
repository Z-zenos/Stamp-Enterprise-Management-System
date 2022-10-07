import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'ic-select-city-district',
  templateUrl: './select-city-district.component.html',
  styleUrls: ['./select-city-district.component.scss']
})
export class SelectCityDistrictComponent implements OnInit {
  @Input() public form!: FormGroup;

  citiesDetails!: any[];
  cities!: any[];
  citySelected!: 'Hà Nội';
  districts!: any[];
  districtSelected!: string;

  constructor(private _http: HttpClient) { }

  ngOnInit(): void {
    this._http
      .get('https://provinces.open-api.vn/api/?depth=2')
      .subscribe((cities: any) => {
        this.citiesDetails = cities;
        this.cities = this.citiesDetails
          .map((city: any) => city.name.replace(/(Tỉnh|Thành phố) /, ''));
      });
  }

  cityChange(value: string): void {
    this.districts = this.citiesDetails
      ? this.citiesDetails
          .find(city => city.name.includes(value))
          .districts
          .map((d: any) => d.name)
      : [];
  }

}
