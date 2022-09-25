export class User {
  id!: number;
  name!: string;
  phone!: string;
  email!: string;
  password?: string;
  taxcode!: string;
  city!: string;
  district!: string;
  address!: string;
  status!: number;
  createdAt?: Date;
  updatedAt?: Date;
}
