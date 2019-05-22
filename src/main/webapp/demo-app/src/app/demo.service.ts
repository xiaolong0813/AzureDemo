import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Demo} from "./demo";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DemoService {

  constructor(
  //HttpClient 是 Angular 通过 HTTP 与远程服务器通讯的机制
    private http : HttpClient
  ) { }

  // 发送给服务端的api。端口为server.port
  private api = 'http://localhost:1230/demo/';

  // 观察者模式方法。用post方法发送Demo类型数据，并等待返回的信息
  // 返回的是json格式，可以在本地建立数据模型，这里用any类型接受
  addToDatabase(demodata : Demo):Observable<any> {
    return this.http.post<any>(this.api + 'newData/', demodata)
  }

  checkDatabase():Observable<Demo[]> {
    return this.http.get<Demo[]>(this.api + 'getData/')
  }

  clearDatabase():Observable<any> {
    return this.http.delete(this.api + 'clearData/')
  }
}
