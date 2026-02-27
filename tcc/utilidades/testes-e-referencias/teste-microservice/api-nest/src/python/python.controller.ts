import { Controller, Get, Query } from '@nestjs/common';
import { PythonService } from './python.service';

@Controller('test')
export class PythonController {
    constructor(private service: PythonService) { }

    @Get()
    async test(@Query('value') value: string) {
        return this.service.process(Number(value));
    }
}
