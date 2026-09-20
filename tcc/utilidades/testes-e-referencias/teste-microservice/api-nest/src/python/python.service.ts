import { Injectable } from '@nestjs/common';
import { HttpService } from '@nestjs/axios';
import { firstValueFrom } from 'rxjs';

@Injectable()
export class PythonService {
    constructor(private http: HttpService) { }

    async process(value: number) {
        const { data } = await firstValueFrom(
            this.http.post('http://ms-python:8000/process', { value })
        );

        return data;
    }
}
