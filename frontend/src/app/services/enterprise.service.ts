import { Injectable } from '@angular/core';
import {User} from "../models/user.model";
import {enterpriseData} from "../../data";

@Injectable({
  providedIn: 'root'
})
export class EnterpriseService {

  constructor() { }

  getAllEnterprises(): User[] {
    return enterpriseData;
  }
}
